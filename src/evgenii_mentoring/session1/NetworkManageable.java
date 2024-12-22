package evgenii_mentoring.session1;

public interface NetworkManageable {
    void changeNetworkType(String newType);
    void adjustSignalStrength(int strength);
    default void resetConnection() {
        System.out.println("Network settings are reset");
    }
}
