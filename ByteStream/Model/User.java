package Model;
import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int id;
	String name;
	transient String password;

	public User(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}
