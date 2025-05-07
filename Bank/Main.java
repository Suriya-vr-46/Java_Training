package Bank;
import java.util.*;

public class Main {
<<<<<<< HEAD
    public static void main(String[] args) {
=======
    public static void main(String[] args) throws InterruptedException {
>>>>>>> 156e75f (Updating Bank)
        Scanner sc = new Scanner(System.in);
        User obj = new User();
        int n = 0;

        while (n != 6) {
            System.out.println("\nEnter your Choice: ");
            System.out.println("1. Account Creation");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            n = sc.nextInt();

            switch (n) {
                case 1:
                    obj.account_creation();
                    break;
                case 2:
                    try{
                        obj.deposit();
<<<<<<< HEAD
=======
                        Thread t = new Thread(new Transaction());
                        t.start();
                        t.join();
>>>>>>> 156e75f (Updating Bank)
                    } catch (Account_Not_Exists e){
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
<<<<<<< HEAD
                    try {
                        obj.withdraw();
=======
                    try {              
                        obj.withdraw();
                        Thread t = new Thread(new Transaction());
                        t.start();
                        t.join();
>>>>>>> 156e75f (Updating Bank)
                    } catch (Balance_Error e) {
                        System.err.println("Error: " + e.getMessage());
                    } catch (Account_Not_Exists e) {
                        System.err.println("Error: " + e.getMessage());
                    } catch (Minimum_Balance e){
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    obj.check_balance();
                    break;
                case 5:
                    obj.account_details();
                    break;
                case 6:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
