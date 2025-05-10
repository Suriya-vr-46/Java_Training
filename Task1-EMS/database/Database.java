package database;
import model.Employee;
import model.Admin;
import java.util.*;

public interface Database {
	ArrayList<Employee> employees = new ArrayList<>();
	ArrayList<Employee> managers = new ArrayList<>();
	ArrayList<Employee> supervisors = new ArrayList<>();
	ArrayList<Employee> technicians = new ArrayList<>();
	ArrayList<Employee> interns = new ArrayList<>();
	static Admin admin = new Admin(1,"admin","admin@123");
}
