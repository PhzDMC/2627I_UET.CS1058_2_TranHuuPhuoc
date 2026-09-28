package Week3.BT_LapTrinh;

import java.util.Stack;

public class BalancedBrackets {
    public static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='{' || c=='[' || c=='('){
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                char p = stack.pop();
                if(c==')' && p!='(' || c=='}' && p!='{' || c==']' && p!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
