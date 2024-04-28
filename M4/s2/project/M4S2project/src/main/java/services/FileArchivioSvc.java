package services;

import catalogo_bibliotecario.Catalogo;
import catalogo_bibliotecario.Libro;
import catalogo_bibliotecario.Periodicita;
import catalogo_bibliotecario.Rivista;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileArchivioSvc implements ArchivioSvc{
    private ArrayList<Catalogo> catalogue = new ArrayList<>();
    private ArrayList<Catalogo> loadedCatalogue = new ArrayList<>();
    Logger logger = LoggerFactory.getLogger(FileArchivioSvc.class);
    private final File f = new File("./catalogo.csv");


    @Override
    public void addElement(Catalogo... element) {
        catalogue.addAll(Arrays.asList(element));
        save();
    }

    @Override
    public void deleteElementByISBN(Integer isbn) {
        catalogue.removeIf(e -> e.getIsbn().equals(isbn));
        save();
    }

    @Override
    public List<Catalogo> getByISBN(Integer isbn) {
        var elemento = catalogue.stream()
                .filter(catalogo -> catalogo.getIsbn().equals(isbn))
                .toList();
        System.out.println(elemento);
        return elemento;
    }

    @Override
    public List<Catalogo> getByPublishYear(Integer year) {
        var elemento = catalogue.stream()
                .filter(catalogo -> catalogo.getPublish_year().equals(year))
                .toList();
        for (Catalogo libro: elemento) System.out.print(libro);
        return elemento;
    }

    @Override
    public List<Catalogo> getByAuthor(String author) {
        var elemento = catalogue.stream()
                .filter(catalogo -> catalogo instanceof Libro && ((Libro) catalogo).getAuthor().equals(author))
                .toList();
        for (Catalogo libro: elemento) System.out.print(libro);
        return elemento;
    }

    public ArrayList<Catalogo> getCatalogue() {
        return catalogue;
    }

    public void save(){
        try{
            FileUtils.delete(f);
        } catch (IOException err) {
            IOException e = err;
            logger.error("Eccezione durante l'eliminazione",e);
        }
        catalogue.stream().forEach(c -> {
            try{
                List lines;
                if(c instanceof Libro){
                    lines = Arrays.asList("Libro > " + c.getIsbn().toString()+ ", " + c.getTitle()+ ", " + c.getPublish_year()+ ", "+ c.getPages()+ ", "+ ((Libro) c).getAuthor() + ", " + ((Libro) c).getGenre());
                }else{
                    lines = Arrays.asList("Rivista > " + c.getIsbn().toString()+", "+ c.getTitle()+", "+c.getPublish_year()+", "+c.getPages()+", "+((Rivista) c).getPeriodicity());
                }
                FileUtils.writeLines(f, StandardCharsets.ISO_8859_1.name(), lines, true);

            }catch (IOException e){
                logger.error("Eccezione:", e);
            }
        });
    }

    public List<String> load() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] el = line.split("\\s*(,|\\s*>\\s*)\\s*");
                Libro libro;
                Rivista rivista;
                String title = el[2];
                Integer publishYear = Integer.parseInt(el[3]);
                Integer pages = Integer.parseInt(el[4]);
                if (el.length == 7){
                    String author = el[5];
                    String genre = el[6];
                    libro = new Libro(title, publishYear, pages, author, genre);
                    loadedCatalogue.add(libro);
                } else {
                    Periodicita periodicity = Periodicita.valueOf(el[5]);
                    rivista = new Rivista(title, publishYear, pages, periodicity);
                    loadedCatalogue.add(rivista);
                }
                lines.add(line);
            }
            System.out.println(loadedCatalogue);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    }
