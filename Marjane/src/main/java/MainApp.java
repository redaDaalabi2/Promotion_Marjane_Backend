import DAO.Imple.AdminDao;
import Entity.Admin;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDao();
        ArrayList<Admin> admins = adminDao.getAllAdmin();
        admins.stream().forEach(admin -> {
            System.out.println(admin.getId());
            System.out.println(admin.getNom());
            System.out.println(admin.getPrenom());
            System.out.println(admin.getEmail());
            System.out.println(admin.getPassword());
            System.out.println(admin.getCentreId());
            System.out.println(admin.getCreatedAt());
            System.out.println(admin.getUpdatedAt());
        });
    }
}
