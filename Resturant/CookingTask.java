package Resturant;

public class CookingTask extends Thread {
	String dish;
	String cname;
	
	public void addDish(String dish,String cname) {
		this.dish = dish;
		this.cname = cname;
	}
	
	public void run() {
		try {
			System.out.println(dish+" is preparing by "+cname);
			Thread.sleep(4000);
			System.err.println(dish+" Preparded!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
