import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HardwareRepo {

    private List<Hardware> hardwareList = new ArrayList<>();

    public void fetchData() {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hardware_db",
                    "root",
                    ""
            );

            String sql = "SELECT * FROM hardware";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int spec = rs.getInt("spec");

                if (type.equalsIgnoreCase("Laptop")) {
                    hardwareList.add(new Laptop(id, brand, model, spec));
                } else if (type.equalsIgnoreCase("Phone")) {
                    hardwareList.add(new Phone(id, brand, model, spec));
                }
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Hardware> getAllHardware() {
        return hardwareList;
    }

    // 🔥 NEW METHOD (for user input filtering)
    public List<Hardware> filterHardware(String type, int specValue) {
        List<Hardware> result = new ArrayList<>();

        for (Hardware h : hardwareList) {

            if (type.equalsIgnoreCase("Laptop") && h instanceof Laptop) {
                Laptop l = (Laptop) h;
                if (l.getRamSize() == specValue) {
                    result.add(l);
                }
            }

            if (type.equalsIgnoreCase("Phone") && h instanceof Phone) {
                Phone p = (Phone) h;
                if (p.getCameraMP() == specValue) {
                    result.add(p);
                }
            }
        }

        return result;
    }
}