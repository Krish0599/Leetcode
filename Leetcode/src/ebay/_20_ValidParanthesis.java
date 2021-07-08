package ebay;

import java.util.Stack;

public class _20_ValidParanthesis {
	
	public static boolean isValid(String s) {
        Stack<Character> stacks = new Stack<>();
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stacks.add(ch);
            }else{
                if(stacks.isEmpty()){
                    return false;
                }
                if((ch == ')' && (stacks.pop() != '('))){
                    return false;
                }else if((ch == '}' && (stacks.pop() != '{') )){
                    return false;
                }else if((ch == ']' && (stacks.pop() != '['))){
                    return false;
                }
            }
        }
        if(!stacks.isEmpty()){
            return false;
        }
        return true;
    }

	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(isValid(s));
	}

}
