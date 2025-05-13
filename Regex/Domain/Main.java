package Domain;
import java.util.*;
import java.util.regex.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z_.]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		System.out.println("Enter your Email : ");
		String email = sc.nextLine();
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches()) {
			System.out.println("Valid Domain!");
		} else {
			System.err.println("Invalid Domain!");
		}
		sc.close();
	}

}
