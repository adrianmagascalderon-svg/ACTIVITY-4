public class Phone extends Hardware {

    protected int cameraMP;

    public Phone(int id, String brand, String model, int cameraMP) {
        super(id, brand, model, cameraMP);
        this.cameraMP = cameraMP;
    }

    @Override
    public String getSpec() {
        return cameraMP + " Megapixels";
    }

    public int getCameraMP() {
        return cameraMP;
    }
}