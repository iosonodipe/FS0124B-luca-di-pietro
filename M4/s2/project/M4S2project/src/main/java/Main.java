import catalogo_bibliotecario.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.FileArchivioSvc;

public class Main {
    Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        FileArchivioSvc archivio = new FileArchivioSvc();
        Libro libro1 = new Libro("titolo", 2000, 10, "luca", "thriller");
        Libro libro2 = new Libro("titolo", 2000, 10, "luca", "thriller");
        Libro libro3 = new Libro("titolo", 2000, 10, "luca", "thriller");
        archivio.addElement(libro1, libro2, libro3);
        archivio.deleteElementByISBN(1);
        archivio.getByISBN(2);
        System.out.println(archivio.getCatalogue());
    }
}