package GenricUtility;

public class JavaLibraray {
	String email;
	String password;
	public JavaLibraray() {}
	public JavaLibraray(String email,String password)
	{
		super();
		this.email=email;
		this.password=password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
