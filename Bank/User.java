package Bank;
import java.util.*;

class User {
    private String name;
    private int account_no;
    private int balance = 0;
    Scanner s = new Scanner(System.in);

    public void account_creation() {
        System.out.print("Enter your name: ");
        name = s.nextLine();
        System.out.print("Enter your Account Number: ");
        account_no = s.nextInt();
    }

    public void deposit() throws Account_Not_Exists {
        if(account_no == 0){
            throw new Account_Not_Exists("Account Not Found!");
        }else{
            System.out.print("Enter your Amount to Deposit: ");
            balance += s.nextInt();
        }
    }

    public void withdraw() throws Balance_Error, Account_Not_Exists, Minimum_Balance {
        if(account_no == 0){
            throw new Account_Not_Exists("Account Not Found!");
        }
        
        System.out.print("Enter your Amount to Withdraw: ");
        int amount = s.nextInt();

        if (amount > balance) {
            throw new Balance_Error("Insufficient Balance!");
        } else if (balance-amount < 500){
            throw new Minimum_Balance("Low Minimum Balance!");
        } else {
            balance -= amount;
        }
    }

    public void check_balance() {
        System.out.println("Current Balance: " + balance);
    }
    
    public void account_details(){
        System.out.println("Name :" + name);
        System.out.println("Account Number : ******" + account_no%10000);
    }
}