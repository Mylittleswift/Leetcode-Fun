/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/

public class Solution {
    public String simplifyPath(String path) {
         if (path == null || path.length() == 0) {
            return "";
        }
        LinkedList<String> stack = new LinkedList<String>();
        String[] dir = path.split("/");
        for (String d : dir) {
            if (d.equals("") || d.equals(".")) {
                continue;
            } else if (d.equals("..")){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(d);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        } else {
            String result = "";
            while (!stack.isEmpty()) {
                result += "/" + stack.removeLast();       
            }
            return result;
        }
    }
}

