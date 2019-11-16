package bvrit;
public class Admin {
	private int id;
	private String password;
	
	public Admin() {
	}
	public Admin(int id, String password) {
		this.id = id;
		this.password = password;
		
		}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
			
	}








