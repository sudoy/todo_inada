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

}
