package Bank;

public class Transaction extends Thread{
	public void run() {
		try {
			Thread.sleep(500);			
			System.err.println("Transaction is being Processing...");
			Thread.sleep(4000);
			System.err.println("Transaction Completed Sucessfully!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
