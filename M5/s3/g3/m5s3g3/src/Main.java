import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Info info = new Info("Luca", "Di Pietro", new Date(100, 6, 15));
        UserAdapter userAdapter = new UserAdapter(info);
        UserData userData = new UserData();
        userData.getData(userAdapter);
        System.out.println(userData.getNomeCompleto());
        System.out.println(userData.getEta());
    }
}