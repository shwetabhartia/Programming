import java.util.Stack;

public class ParenthesesMatch {

	public boolean parenthesesMatching (String s) {
		Stack<Character> stack = new Stack<Character>();
		char temp;
		for (int i=0; i<s.length(); i++) {
			switch(s.charAt(i)) {
			case '{' :
			case '[' :
			case '(' :
				stack.push(s.charAt(i));
				break;
			case '}' :
				if (stack.size() == 0) return false;
				temp = stack.pop();
				if (temp != '{') return false;
				break;
			case ']' :
				if (stack.size() == 0) return false;
				temp = stack.pop();
				if (temp != '[') return false;
				break;
			case ')' :
				if (stack.size() == 0) return false;
				temp = stack.pop();
				if (temp != '(') return false;
				break;
			}
		}
		if (stack.size() != 0) return false;
		else return true;
	}
	
	public static void main (String args[]) {
		ParenthesesMatch pm = new ParenthesesMatch();
		System.out.println(pm.parenthesesMatching("{}[()"));
	}
			
}
