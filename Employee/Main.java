package Employee;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Department> ob = new HashMap<>();
		
		while(true) {
			System.out.println("Employee Detials!");
			System.out.println("1.Enter Employee Details.");
			System.out.println("2.Show Departments.");
			System.out.println("3.Show Employees.");
			System.out.println("4.Exit.");
			System.out.println("Employee Your Choice : ");
			int c = sc.nextInt();
			sc.nextLine();
			
			switch(c) {
				case 1:
					System.out.println("Enter Department : ");
					String dep = sc.nextLine();
					System.out.println("Enter Employee id : ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Employee Name : ");
					String name = sc.nextLine();
					if(!ob.containsKey(dep)) {
						ob.put(dep, new Department(dep));
					}
					ob.get(dep).addEmployee(id, name);
					break;
					
				case 2:
					 if (ob.isEmpty()) {
	                        System.out.println("No departments added yet.");
	                    } else {
	                        System.out.println("Departments:");
	                        for (String key : ob.keySet()) {
	                            System.out.println(key);
	                        }
	                    }
					break;
					
				case 3:
					System.out.println("Enter the Deparment : ");
					String depart = sc.nextLine();
					if(ob.containsKey(depart)) {
						ob.get(depart).display();
						System.out.println();
					}else {
						System.out.println(depart+" doesn`t Exists!");
					}
					break;
					
				case 4:
					System.out.println("Thank You!");
					break;
					
				default:
					System.out.println("Invalid Choice!");
			}
			if(c == 4) {
				break;
			}
		}
	}
}
