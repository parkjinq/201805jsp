package kr.or.ddit.util;

public class StringUtil {
	public static String stringUtil(String contentDisposition) {
		String[] fileNameList  = contentDisposition.split(";");
		String condition = "filename=\"";
		String profile = "";
		for(String str : fileNameList){
			if(str.contains(condition)){
				//샘 방식
				int beginIndex = str.lastIndexOf(condition)+condition.length();
				int endIndex = str.lastIndexOf("\"");
				profile = str.substring(beginIndex, endIndex);
				//내 방식
//				profile = str.substring(condition.length()+1, str.length()-1);
			}
		}
		return profile;
	}
}
