package todo.utils;

public class HTMLUtils {

	public static String juyodoFormat(String juyodoval) {
		if(juyodoval.equals("option1")) {
			String juyodo = "★★★";
			return juyodo;
		}else if(juyodoval.equals("option2")) {
			String juyodo = "★★";
			return juyodo;
		}else {
			String juyodo = "★";
			return juyodo;
		}
	}

	public static String kigenFormat(String kigen) {

		String formatKigen = kigen.replace("-", "/");
		return formatKigen;
	}

	public static String radio1(String juyodoval) {
		if(juyodoval.equals("option1")) {
			return "checked";
		}else {
			return "";
		}
	}
	public static String radio2(String juyodoval) {
		if(juyodoval.equals("option2")) {
			return "checked";
		}else {
			return "";
		}
	}
	public static String radio3(String juyodoval) {
		if(juyodoval.equals("option3")) {
			return "checked";
		}else {
			return "";
		}
	}

	public static String status1(String status) {
		if(status.equals("1")) {
			return "checked";
		}else {
			return "";
		}
	}
	public static String status0(String status) {
		if(status.equals("0")) {
			return "checked";
		}else {
			return "";
		}
	}

}
