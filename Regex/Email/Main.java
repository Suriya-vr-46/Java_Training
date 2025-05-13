package Email;
import java.util.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Gmail : ");
		String gmail = sc.nextLine();
		String gmailRegex = "^(?!\\.)(?!.*\\.\\.)[A-Za-z0-9.]+(?<!\\.)+@gmail.com+$";
		if(gmail.matches(gmailRegex)) {
			System.out.println("Valid Gmail");
		} else {
			System.err.println("Invalid Gamil!");
		}
	}

}
