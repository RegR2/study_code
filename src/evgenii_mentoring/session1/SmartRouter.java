package evgenii_mentoring.session1;

public class SmartRouter extends CommunicationDevice implements DataTransferable, NetworkManageable {
    public SmartRouter(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    protected void connect() {
        super.connect();
    }

    @Override
    protected String displayInfo() {
        return super.displayInfo();
    }

    @Override
    public void sendData(byte[] data) {

    }

    @Override
    public void receiveData() {

    }

    @Override
    public void changeNetworkType(String newType) {

    }

    @Override
    public void adjustSignalStrength(int strength) {

    }

    @Override
    public void resetConnection() {
        NetworkManageable.super.resetConnection();
    }
}
