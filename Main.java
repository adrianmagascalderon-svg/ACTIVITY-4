import java.util.*;

public class Main {

    public static void printMasterlist(List<Hardware> list) {
        System.out.println("\n=== HARDWARE MASTERLIST ===");
        for (Hardware h : list) {
            h.displayInfo();
        }
    }

    public static void printFiltered(List<Hardware> list) {
        System.out.println("\n=== FILTERED RESULT ===");
        if (list.isEmpty()) {
            System.out.println("No matching hardware found.");
        } else {
            for (Hardware h : list) {
                h.displayInfo();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HardwareRepo repo = new HardwareRepo();
        repo.fetchData(); 

        List<Hardware> list = repo.getAllHardware();
        printMasterlist(list);

        System.out.println("\n=== SEARCH FILTER ===");
        System.out.print("Enter type (Laptop/Phone): ");
        String type = sc.nextLine();

        System.out.print("Enter spec value (RAM GB or Camera MP): ");
        int spec = sc.nextInt();

        List<Hardware> filtered = repo.filterHardware(type, spec);
        printFiltered(filtered);

        sc.close();
    }
}