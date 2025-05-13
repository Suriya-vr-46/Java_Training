package database;

import model.Employee;
import model.Admin;
import java.util.*;

public interface Database {
	HashMap<Integer,Employee> employees = new HashMap<>();
	HashMap<Integer,Employee> managers = new HashMap<>();
	HashMap<Integer,Employee> supervisors = new HashMap<>();
	HashMap<Integer,Employee> technicians = new HashMap<>();
	HashMap<Integer,Employee> interns = new HashMap<>();
	HashMap<Integer,String> roles = new HashMap<>();
	static Admin admin = new Admin(1, "admin", "admin@123");
}