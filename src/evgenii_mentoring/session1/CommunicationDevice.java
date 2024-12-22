package evgenii_mentoring.session1;

public abstract class CommunicationDevice {
    protected String manufacturer;
    protected String model;

    public CommunicationDevice(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    protected void connect() {
        System.out.println("you are connected to the network");
    }

    protected String displayInfo() {
        return "This device's manufacturer is " + manufacturer + " and is of model type " + model + ".";
    }
}
