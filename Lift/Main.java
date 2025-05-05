package Lift;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> lift = new ArrayList<>();
		
		System.out.println("Enter the no.of lift : ");
		int li = sc.nextInt();
		for(int i=1;i<=li;i++) {
			lift.add(0);
		}
	
		System.out.println("Enter the no.of Floor : ");
		int fl = sc.nextInt();
		
		System.out.println("Floor and Lift Createded!");
		System.out.println();
		
		while(true) {
			System.err.println("Welcome Lift Automation!");
			System.out.println("1.Use Lift.");
			System.out.println("2.Exit");
			System.out.println("Enter your choice : ");
			int c = sc.nextInt();
			
			switch(c) {
				case 1:
					System.out.println("Enter the lift number : ");
					int l = sc.nextInt();
					if(l<1 || l>li) {
						System.out.println("Lift Dosen`t Exists!");
					}
					System.out.println("Enter the Current Floor : ");
					int cf = sc.nextInt();
					if(cf<1 || cf>fl) {
						System.out.println("Floor Dosen`t Exists!");
					}
					System.out.println("Enter the Destination Floor : ");
					int df = sc.nextInt();
					if(df<1 || df>fl) {
						System.out.println("Floor Dosen`t Exists!");
					}
					if(lift.get(l-1)==cf) {
						System.out.println("Lift in same floor!");
					}else {
						System.out.println("Lift moving from "+lift.get(l-1)+" to "+cf+" floor");
					}
					lift.set(l-1,df); 
					System.out.println("Destination Reached! floor : "+df);
					System.out.println();
					break;
					
				case 2:
					System.out.println("Thank you");
					break;
					
				default:
					System.out.println("Invalid Choice!");
			}	
			if(c == 2) {
				break;
			}
		}
	}

}
