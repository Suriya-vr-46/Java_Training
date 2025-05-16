package database;

import java.util.*;
import model.Part;
import model.Shipping;

public interface Database {
	HashMap<String, Part> parts = new HashMap<>();
	ArrayList<Shipping> shipings = new ArrayList<>();
}
