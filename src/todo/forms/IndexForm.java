package todo.forms;

public class IndexForm {
	private String number;
	private String daimei;
	private String juyodoval;
	private String kigen;
	public IndexForm(String number, String daimei, String juyodoval, String kigen) {
		super();
		this.number = number;
		this.daimei = daimei;
		this.juyodoval = juyodoval;
		this.kigen = kigen;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDaimei() {
		return daimei;
	}
	public void setDaimei(String daimei) {
		this.daimei = daimei;
	}
	public String getJuyodoval() {
		return juyodoval;
	}
	public void setJuyodoval(String juyodoval) {
		this.juyodoval = juyodoval;
	}
	public String getKigen() {
		return kigen;
	}
	public void setKigen(String kigen) {
		this.kigen = kigen;
	}

}