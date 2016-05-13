import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ReadDataImpl implements ReadDataI {
	
	FileInputStream input = null;
	BufferedReader read = null;
	InputStreamReader inputStreamReader = null;
	String fileName = null;
	public int init(){
		 if(fileName==null)
			return -1;
		 File file = new File(fileName);
		 try {
			input = new FileInputStream(file);
			inputStreamReader = new InputStreamReader(input, "UTF-8");
			read = new BufferedReader(inputStreamReader);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			
			System.out.println("can not find file "+ fileName);
			return -1;
		} catch (UnsupportedEncodingException e) {
			//e.printStackTrace();
			System.out.println("can not encode");
			return -2;
		}
		return 1;
	
	}
	
	@Override
	public String read() {
		String buf = null;
		try {
			buf = read.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buf;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
/*	@Test
	public void test(){
		setFileName("src/DNS_6.6.6");
		init();
		String line = null;
		do{
			 line = read();
			 System.out.println(line);
		}while(line!=null);
		
	}	*/
}
