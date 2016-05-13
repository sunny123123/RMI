
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI_Client {
	public static void main(String[] args) {
		try {
			if(args.length<2){
				System.out.println("please input destination ip and file name");
				return;
			}
			Registry registery = LocateRegistry.getRegistry(args[0],2001);
			//System.out.println(System.getProperty("user.dir"));
			ReadDataI read = (ReadDataI)registery.lookup("read");
			read.setFileName(args[1]);
			int flag = read.init();
			if(flag==-1){
				System.out.println("can not find file "+args[1]);
				return;
			}
			if(flag==-2){
				System.out.println("error encode");
				return;
			}
			String line = null;
			line = read.read();
			while(line!=null){
				 System.out.println(line);
				line = read.read();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

