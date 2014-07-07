package leetcode;

import java.util.Stack;

public class SimplifyPath {

	public static String simplifyPath(String path){
		String[] paths = path.split("/");
		Stack<String> s = new Stack<String>();
		for(String temp : paths){
			if(temp.equals("..")){
				if(!s.isEmpty())
					s.pop();
			}else if(!temp.equals("") && !temp.equals(".")){
				s.push(temp);
			}
		}
		if(s.isEmpty()) return "/";
		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty())
			sb.insert(0, s.pop()).insert(0, "/");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String path = "/home/";
//		String path = "/a/./b/../../c/";
		System.out.println(simplifyPath(path));
	}

}
