package services;

import catalogo_bibliotecario.Catalogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class FileArchivioSvc implements ArchivioSvc{
    private ArrayList<Catalogo> catalogue = new ArrayList<>();

    @Override
    public void addElement(Catalogo... element) {
        catalogue.addAll(Arrays.asList(element));
    }

    @Override
    public void deleteElementByISBN(Integer isbn) {
        catalogue.removeIf(e -> e.getIsbn().equals(isbn));
        System.out.println("elemento eliminato");

    }

    @Override
    public Optional<Catalogo> getByISBN(Integer isbn) {
        var elemento = catalogue.stream()
                .filter(catalogo -> catalogo.getIsbn().equals(isbn))
                .findFirst();

        System.out.println("oggetto trovato da isbn" + elemento);

        return elemento;
    }

    @Override
    public Catalogo getByPublishYear(Integer year) {
        return null;
    }

    @Override
    public Catalogo getByAuthor(String author) {
        return null;
    }

    public ArrayList<Catalogo> getCatalogue() {
        return catalogue;
    }
}
