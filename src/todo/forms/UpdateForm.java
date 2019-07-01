package todo.forms;

public class UpdateForm {

	String daimei;
	String syosai;
	String kigen;

	String radio1;
	String radio2;
	String radio3;

	String juyodoval;
	String number;
	public UpdateForm(String number, String daimei, String syosai, String kigen, String radio1, String radio2, String radio3) {
		super();
		this.number = number;
		this.daimei = daimei;
		this.syosai = syosai;
		this.kigen = kigen;
		this.radio1 = radio1;
		this.radio2 = radio2;
		this.radio3 = radio3;
	}

	public UpdateForm(String number, String daimei, String syosai, String juyodoval, String kigen,
			String radio1, String radio2, String radio3) {
		super();
		this.number = number;
		this.daimei = daimei;
		this.syosai = syosai;
		this.juyodoval = juyodoval;
		this.kigen = kigen;
		this.radio1 = radio1;
		this.radio2 = radio2;
		this.radio3 = radio3;
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
	public String getKigen() {
		return kigen;
	}
	public void setKigen(String kigen) {
		this.kigen = kigen;
	}
	public String getRadio1() {
		return radio1;
	}
	public void setRadio1(String radio1) {
		this.radio1 = radio1;
	}
	public String getRadio2() {
		return radio2;
	}
	public void setRadio2(String radio2) {
		this.radio2 = radio2;
	}
	public String getRadio3() {
		return radio3;
	}
	public void setRadio3(String radio3) {
		this.radio3 = radio3;
	}
	public String getJuyodoval() {
		return juyodoval;
	}
	public void setJuyodoval(String juyodoval) {
		this.juyodoval = juyodoval;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}




}
