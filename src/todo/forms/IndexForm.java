package todo.forms;

public class IndexForm {
	private String number;
	private String daimei;
	private String juyodoval;
	private String kigen;
	private String status;

	private String[] kanryoNumArray;


	public IndexForm(String[] kanryoNumArray) {
		super();
		this.kanryoNumArray = kanryoNumArray;
	}
	public IndexForm(String number, String daimei, String juyodoval, String kigen, String status) {
		super();
		this.number = number;
		this.daimei = daimei;
		this.juyodoval = juyodoval;
		this.kigen = kigen;
		this.status = status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String[] getKanryoNumArray() {
		return kanryoNumArray;
	}
	public void setKanryoNumArray(String[] kanryoNumArray) {
		this.kanryoNumArray = kanryoNumArray;
	}

}