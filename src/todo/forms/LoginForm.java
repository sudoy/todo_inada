package todo.forms;

public class LoginForm {

	private boolean login;
	private String name;

	private String mail;
	private String pass;
	public LoginForm(String mail, String pass) {
		super();
		this.mail = mail;
		this.pass = pass;
	}

	public LoginForm(boolean login, String name) {
		super();
		this.login = login;
		this.name = name;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



}
