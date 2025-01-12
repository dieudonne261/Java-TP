import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurRMI {
    public static void main(String[] args) {
        try {
            ImplServiceDistant obj = new ImplServiceDistant();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ServiceDistant", obj);
            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            System.err.println("Erreur du serveur RMI : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
