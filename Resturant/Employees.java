
package Resturant;

import java.util.*;

public class Employees {
	List<Chef> chefs;
	
	public Employees() {
		this.chefs = new ArrayList<>();
	}
	
	public void addChef(String name) {
		Chef c = new Chef();
		c.setName(name);
		chefs.add(c);
	}
	
	public int numberOfChefs() {
		return chefs.size();
	}
	
	public Chef getChef(int index) {
		if(index >= chefs.size()) {
			index -= chefs.size();
			return chefs.get(index);
		}
		return chefs.get(index);
	}
}
