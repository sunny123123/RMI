
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReadDataI extends Remote{
	/*
	 *  Must throw execption,else will throw below exception remote object implements illegal remote interface; nested exception is: 
	 */
	public String read()  throws RemoteException;
	public void setFileName(String fileName)  throws RemoteException;
	public int init() throws RemoteException;
}
