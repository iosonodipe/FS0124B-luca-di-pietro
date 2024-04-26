package services;

import catalogo_bibliotecario.Catalogo;

import java.util.Optional;

public interface ArchivioSvc {
    void addElement(Catalogo... element);
    void deleteElementByISBN(Integer isbn);
    Optional<Catalogo> getByISBN(Integer isbn);
    Catalogo getByPublishYear(Integer year);
    Catalogo getByAuthor(String author);
}
