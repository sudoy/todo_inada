package todo.forms;

public class LoginForm {

	private String mail;
	private String pass;
	public LoginForm(String mail, String pass) {
		super();
		this.mail = mail;
		this.pass = pass;
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



}
