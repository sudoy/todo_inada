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

//	public static String checked(String radio1,String radio2, String radio3) {
//		if(radio1.equals("") && radio2.equals("") && radio3.equals("")) {
//			return "checked";
//		}else {
//			return "";
//		}
//	}


}
