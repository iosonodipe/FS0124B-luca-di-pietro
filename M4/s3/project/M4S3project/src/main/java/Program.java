import data.Libri;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import services.FileArchivio;

public class Program {
    Logger logger = LoggerFactory.getLogger(Program.class);

    public static void main(String[] args) {
        var FileArchivio = new FileArchivio();

        Libri libri1 = new Libri("libro1", 2000, 5, "luca", "comico");
        Libri libri2 = new Libri("libro2", 2010, 10, "paolo", "giallo");
        Libri libri3 = new Libri("libro3", 1900, 15, "maria", "thriller");

        FileArchivio.save(libri1);
        FileArchivio.save(libri2);
        FileArchivio.save(libri3);

    }
}
