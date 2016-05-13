
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Server{
	public static void main(String[] args) {
		ReadDataI read = new ReadDataImpl();
		try {
			ReadDataI stub = (ReadDataI)UnicastRemoteObject.exportObject(read, 0);
			//Registry registery = LocateRegistry.getRegistry();
			Registry registery = LocateRegistry.createRegistry(2001);
			registery.rebind("read", stub);
			System.out.println("object bound");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}

