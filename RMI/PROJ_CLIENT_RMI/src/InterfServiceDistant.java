import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface InterfServiceDistant extends Remote {
    Date getServerDate() throws RemoteException;

    double convertEuroToDH(double montant) throws RemoteException;
}
