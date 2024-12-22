package evgenii_mentoring.session1;

public class MobilePhone extends CommunicationDevice implements VoiceCallable {
    public MobilePhone(String manufacturer, String model) {
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
    public void makeCall(String number) {

    }

    @Override
    public void endCall() {

    }
}
