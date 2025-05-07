package Message;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(3); 
		
		for(int i=1;i<=5;i++) {
			e.submit(new MessagePrinter());
		}
		
		e.shutdown();
	}
}
