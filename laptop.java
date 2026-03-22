public class Laptop extends Hardware {

    protected int ramSize;

    public Laptop(int id, String brand, String model, int ramSize) {
        super(id, brand, model, ramSize);
        this.ramSize = ramSize;
    }

    @Override
    public String getSpec() {
        return ramSize + "GB RAM";
    }

    public int getRamSize() {
        return ramSize;
    }
}