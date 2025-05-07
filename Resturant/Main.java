package Resturant;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	static Employees emp = new Employees();
	static ExecutorService es;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<CookingTask> ct = new ArrayList<>();
		
	public static void main(String[] args) throws InterruptedException {
		
		while(true) {
			System.out.println("Resturant Management System!");
			System.out.println("1. Enter Kitchen Detials.");
			System.out.println("2. Menu.");
			System.out.println("3. Exit.");
			System.out.println("Enter your Choice : ");
			int n = sc.nextInt();
			switch(n) {
				case 1:
					System.out.println("Enter no.of Chef : ");
					int nc = sc.nextInt();
					sc.nextLine();
					for(int i=1;i<=nc;i++) {
						System.out.println("Enter Chef "+i+" Name : ");
						String cn = sc.nextLine();
						emp.addChef(cn);
					}
					System.out.println("Enter no.of Stove : ");
					int ns = sc.nextInt();
					es = Executors.newFixedThreadPool(ns);
					break;
			
				case 2:
					menu();
					break;
					
				case 3:
					System.out.println("Thank You!");
					break;
			}
			if(n==3)
				break;
		}
		
		for(CookingTask c : ct) {
			Thread t = new Thread(c);
			es.submit(t);
		}
		
		es.shutdown();
		es.awaitTermination(60, TimeUnit.SECONDS);
		System.err.println("Task Completed Successfully!");
	}
	
	public static void menu() {
		int l = emp.numberOfChefs();
		int il = 0;
		while(true) {
			System.out.println("Dish Items!");
			System.out.println("1. Dosa.");
			System.out.println("2. Idly.");
			System.out.println("3. Pongal.");
			System.out.println("4. Poori.");
			System.out.println("5. Vada.");
			System.out.println("6. Exit.");
			System.out.println("Enter your choice :");
			int n = sc.nextInt();
			
			switch(n) {
				case 1:
					System.out.println("Enter the quantity : ");
					int q1 = sc.nextInt();
					CookingTask t1 = new CookingTask();
					for(int i=1;i<=q1;i++) {
						t1.addDish("Dosa",emp.getChef(il).getName());
						ct.add(t1);
					}
					il++;
					break;
					
				case 2:
					System.out.println("Enter the quantity : ");
					int q2 = sc.nextInt();
					CookingTask t2 = new CookingTask();
					t2.addDish("Idly",emp.getChef(il).getName());
					ct.add(t2);
					il++;
					break;
					
				case 3:
					System.out.println("Enter the quantity : ");
					int q3 = sc.nextInt();
					CookingTask t3 = new CookingTask();
					for(int i=1;i<=q3;i++) {
						t3.addDish("Pongal",emp.getChef(il).getName());
						ct.add(t3);
					}
					il++;
					break;
					
				case 4:
					System.out.println("Enter the quantity : ");
					int q4 = sc.nextInt();
					CookingTask t4 = new CookingTask();
					for(int i=1;i<=q4;i++) {
						t4.addDish("Poori",emp.getChef(il).getName());
						ct.add(t4);
					}
					il++;
					break;
					
				case 5:
					System.out.println("Enter the quantity : ");
					int q5 = sc.nextInt();
					CookingTask t5 = new CookingTask();
					t5.addDish("Vada",emp.getChef(il).getName());
					ct.add(t5);
					il++;
					break;
					
				case 6:
					System.out.println("Thank you!");
					break;
					
				default:
					System.out.println("Invalid Choice!");
			}
			
			if(n==6)
				break;
		}
		
	}
}
