package Message;
import java.util.*;

public class MessagePrinter implements Runnable {
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println("Task "+i+" excuted by "+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
