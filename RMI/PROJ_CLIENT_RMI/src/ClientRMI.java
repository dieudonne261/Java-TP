import java.rmi.Naming;

public class ClientRMI {
    public static void main(String[] args) {
        try {
            InterfServiceDistant service = (InterfServiceDistant) Naming.lookup("rmi://localhost:1099/ServiceDistant");
            System.out.println("Date du serveur : " + service.getServerDate());
            System.out.println("35 euros valent " + service.convertEuroToDH(35) + " DH");
        } catch (Exception e) {
            System.err.println("Erreur dans le client RMI : " + e.getMessage());
            e.printStackTrace();
        }
    }
}