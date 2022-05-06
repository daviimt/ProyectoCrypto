package AAMain;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import Entities.Crypto;
import Windows.Login;

public class Test {

	private static File f = new File("files/Cryptos");
	private static ObjectInputStream is;
	static List<Crypto> listC = new ArrayList<>();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		try {
			is = new ObjectInputStream(new FileInputStream(f));
			Crypto c = (Crypto) is.readObject();
			while (c != null) {
				listC.add(c);
				c = (Crypto) is.readObject();
			}
			is.close();
		} catch (Exception e) {
		}
		
		Login login = new Login();
		
	}

	public static List<Crypto> getListC() {
		return listC;
	}

	public static void setListC(List<Crypto> listC) {
		Test.listC = listC;
	}

}
