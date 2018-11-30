package dk_breeze.utility;

public class StringExt {
	private static boolean isEmpty(String str) {
		return str == null || str.equals("");
	}

	private static boolean isWhiteSpace(String str){
		return str == null || str.trim().equals("");
	}
}

