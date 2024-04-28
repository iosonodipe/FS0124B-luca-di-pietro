package services;

import catalogo_bibliotecario.Catalogo;
import catalogo_bibliotecario.Libro;
import catalogo_bibliotecario.Periodicita;
import catalogo_bibliotecario.Rivista;
import exceptions.UnknownElementException;
import exceptions.UnknownISBN;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileArchivioSvc implements ArchivioSvc{
    private final ArrayList<Catalogo> catalogue = new ArrayList<>();
    private final ArrayList<Catalogo> loadedCatalogue = new ArrayList<>();
    private File f = new File("./catalogo.csv");
    Logger logger = LoggerFactory.getLogger(FileArchivioSvc.class);

    public void addElementManual(Catalogo... element){
        catalogue.addAll(List.of(element));
        save();
    }
    @Override
    public void addElement() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.print("Vuoi aggiungere un libro o una rivista? ");
            String element = scanner.nextLine();
            scanner.reset();
            if (!element.equalsIgnoreCase("libro") && !element.equalsIgnoreCase("rivista")) throw new UnknownElementException();
            System.out.println();
            System.out.print("Titolo: ");
            String title = scanner.nextLine();
            scanner.reset();
            System.out.print("Anno di pubblicazione: ");
            int publishYear = scanner.nextInt();
            scanner.reset();
            System.out.print("Numero di pagine: ");
            int pages = scanner.nextInt();
            scanner.nextLine();
            if (element.equalsIgnoreCase("libro")){
                System.out.print("Autore: ");
                String author = scanner.nextLine();
                scanner.reset();
                System.out.print("Genere: ");
                String genre = scanner.nextLine();
                scanner.reset();
                catalogue.add(new Libro(title, publishYear, pages, author, genre));
            } else if(element.equalsIgnoreCase("rivista")){
                System.out.print("Periodicità: ");
                Periodicita periodicity = Periodicita.valueOf(scanner.nextLine().toUpperCase());
                scanner.reset();
                catalogue.add(new Rivista(title, publishYear, pages, periodicity));
            } else throw new UnknownElementException();
            save();

            System.out.println();
            System.out.println("Catalogo aggiornato con successo!\n");
            System.out.println(catalogue + "\n");

        }
        catch (InputMismatchException ex){
            logger.error(String.valueOf(ex));
        }
        catch (UnknownElementException ex){
            logger.error("Elemento non esistente, puoi aggiungere libro o rivista.\n");
        }

    }

    @Override
    public void deleteElementByISBN() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.print("Inserisci il codice ISBN dell'elemento da rimuovere: ");
            int isbn = scanner.nextInt();
            if (!catalogue.removeIf(e -> e.getIsbn().equals(isbn))) throw new UnknownISBN();
            save();

            System.out.println();
            System.out.println("Catalogo aggiornato con successo!\n");
            System.out.println(catalogue + "\n");
        } catch (UnknownISBN ex){
            logger.error("ISBN non trovato.");
        } catch (InputMismatchException ex){
            logger.error(String.valueOf(ex));
        }
    }

    @Override
    public List<Catalogo> getByISBN(Integer isbn) {
        var elemento = catalogue.stream()
                .filter(catalogo -> catalogo.getIsbn().equals(isbn))
                .toList();
        System.out.println("\nElemento trovato: " + elemento);
        return elemento;
    }

    @Override
    public List<Catalogo> getByPublishYear(Integer year) {
        var elemento = catalogue.stream()
                .filter(catalogo -> catalogo.getPublish_year().equals(year))
                .toList();
        System.out.println("\nElementi trovati: ");
        for (Catalogo libro: elemento) System.out.print(libro);
        return elemento;
    }

    @Override
    public List<Catalogo> getByAuthor(String author) {
        var elemento = catalogue.stream()
                .filter(catalogo -> catalogo instanceof Libro && ((Libro) catalogo).getAuthor().toLowerCase().equals(author))
                .toList();
        System.out.println("\nElementi trovati: ");
        for (Catalogo libro: elemento) System.out.print(libro);
        return elemento;
    }

    public ArrayList<Catalogo> getCatalogue() {
        return catalogue;
    }

    public void save(){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(f));
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
            System.out.println("\nCatalogo salvato: ");
            System.out.println(loadedCatalogue);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    }
