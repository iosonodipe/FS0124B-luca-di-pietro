import catalogo_bibliotecario.Libro;
import catalogo_bibliotecario.Periodicita;
import catalogo_bibliotecario.Rivista;
import services.FileArchivioSvc;

public class Main {
    public static void main(String[] args) {
        FileArchivioSvc archivio = new FileArchivioSvc();
        Libro libro1 = new Libro("libro1", 2000, 10, "luca", "thriller");
        Libro libro2 = new Libro("libro2", 2010, 10, "mario", "thriller");
        Libro libro3 = new Libro("libro3", 2000, 10, "luca", "thriller");
        Rivista rivista1 = new Rivista("rivista1", 2010, 50, Periodicita.WEEKLY);
        archivio.addElement(libro1, libro2, libro3, rivista1);
        archivio.deleteElementByISBN(1);
        //archivio.getByISBN(2);
        //archivio.getByPublishYear(2010);
        //System.out.println(archivio.getByAuthor("luca"));
        //archivio.getByAuthor("luca");
        archivio.load();

    }
}