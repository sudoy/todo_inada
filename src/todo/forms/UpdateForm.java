package todo.forms;

public class UpdateForm {

	String daimei;
	String syosai;
	String juyodoval;
	String kigen;

	public UpdateForm(String daimei, String syosai, String juyodoval, String kigen) {
		super();
		this.daimei = daimei;
		this.syosai = syosai;
		this.juyodoval = juyodoval;
		this.kigen = kigen;
	}
	public String getDaimei() {
		return daimei;
	}
	public void setDaimei(String daimei) {
		this.daimei = daimei;
	}
	public String getSyosai() {
		return syosai;
	}
	public void setSyosai(String syosai) {
		this.syosai = syosai;
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
