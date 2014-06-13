
public class BanqueMain {

	public static void main(String[] args) throws InterruptedException {
		Banque sync = new Banque();
		Thread t = new Thread(sync);
		t.start();	
	}

}
