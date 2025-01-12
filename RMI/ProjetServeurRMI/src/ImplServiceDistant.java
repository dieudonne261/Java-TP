import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class ImplServiceDistant extends UnicastRemoteObject implements InterfServiceDistant {
    public ImplServiceDistant() throws RemoteException {
        super();
    }

    @Override
    public Date getServerDate() throws RemoteException {
        return new Date();
    }

    @Override
    public double convertEuroToDH(double montant) throws RemoteException {
        return montant * 11.3;
    }
}