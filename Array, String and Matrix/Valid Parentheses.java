/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" 
are all valid but "(]" and "([)]" are not.
*/
import java.util.LinkedList;

// implements stack
public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false; 
                }
                stack.pop();
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false; 
                }
                stack.pop(); 
            } 
        }
        return stack.isEmpty();
    }
}


// implements hashmap and stack
public class Solution {
	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	 
		Stack<Character> stack = new Stack<Character>();
	 
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
	 
		return stack.empty();
	}

}

