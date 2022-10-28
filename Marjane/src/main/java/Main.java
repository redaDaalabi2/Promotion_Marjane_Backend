import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import Entity.*;
import Repository.*;
import Services.*;

public class Main {
    public static void main(String[] args) {
        ResponsableRayonRepo.CreateResponsableRayon("ZAKHA", "Amine", "amine@gmail.com", "amine", 8);
    }
}
