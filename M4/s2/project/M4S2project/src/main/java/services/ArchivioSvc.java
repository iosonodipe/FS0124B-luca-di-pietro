package services;

import catalogo_bibliotecario.Catalogo;

import java.util.List;
import java.util.Optional;

public interface ArchivioSvc {
    void addElement(Catalogo... element);
    void deleteElementByISBN(Integer isbn);
    List<Catalogo> getByISBN(Integer isbn);
    List<Catalogo> getByPublishYear(Integer year);
    List<Catalogo> getByAuthor(String author);
}
