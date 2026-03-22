public class Hardware {
    private int id;
    private String brand;
    private String model;
    protected int specValue;

    public Hardware(int id, String brand, String model, int specValue) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.specValue = specValue;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }

    // NOT abstract anymore
    public String getSpec() {
        return specValue + " units"; // default (fallback)
    }

    public void displayInfo() {
        System.out.println("ID: " + id +
                " | Brand: " + brand +
                " | Model: " + model +
                " | Spec: " + getSpec());
    }
}