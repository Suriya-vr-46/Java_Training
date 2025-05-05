package Calculator;
import java.util.*;
import java.util.InputMismatchException;

class Main extends Calculator{
	public static void main(String[] args) {
		operation();
	}
	
    public static int operation(){
    	Scanner in = new Scanner(System.in);
    	Calculator cal = new Calculator();
        
        int c=0;
    do{
        System.out.println(" 1 - Addition\n 2- Subraction\n 3 - Multipilcation\n 4 - Division\n 5 - Exit");
        try{
            System.out.print("Enter Your Choice : ");
            c = in.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("InputMismatchException: Please enter a valid integer.");
        }
        switch(c){
            case 0:
                return 0;
            case 1:
                cal.addition();
                break;
            case 2:
                cal.subtraction();
                break;
            case 3:
                cal.muliplication();
                break;
            case 4:
                cal.division();
                break;
            case 5:
            	System.out.println("Thank you!");
            	break;
            default:
                System.out.println("Invalid Choice!");
         }
        if(c==5)
        	break;
        System.out.println("--------------------");
        }while(c!=5);
        return 0;
        
    }	
    
}