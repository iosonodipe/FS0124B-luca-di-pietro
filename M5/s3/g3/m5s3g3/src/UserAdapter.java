import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class UserAdapter implements DataSource {

    private Info info;

    public UserAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }

    @Override
    public int getEta() {
        LocalDate birthDate = info.getDataNascita().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        return age.getYears();
    }
}
