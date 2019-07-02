import java.util.LinkedList;
import java.util.Stack;

public class ValidParenthesis {
	public static boolean isValid(String s) {
        LinkedList<Character> parenQueue = new LinkedList<Character>();
        Stack<Character> parenStack = new Stack<Character>();
        // Add paren string to linked list
        for(int i = 0; i < s.length(); i++){
            parenQueue.add(s.charAt(i));
        }
        
        // Evaluate list
        while(parenQueue.size() > 0){

            // View curr head char in list. If it is an opening, add to stack
            if(parenQueue.peek() == '(' || parenQueue.peek() == '{' || parenQueue.peek() == '['){
                parenStack.push(parenQueue.poll());
            }
            else if(parenQueue.peek() == ')'){
            	parenQueue.poll();
                // Check if head of stack is open paren
               if(parenStack.empty() || parenStack.pop() != '(' )
                   return false;
            } 
            else if(parenQueue.peek() == '}' ) {
            	parenQueue.poll();
                // Check if head of stack is open curly brace
               if(parenStack.empty() || parenStack.pop() != '{' )
                   return false;
            } else if(parenQueue.peek() == ']'){
            	parenQueue.poll();
                // Check if head of stack is open square brace
               if(parenStack.empty() || parenStack.pop() != '[' )
                   return false;
            }
        }
        
        if(!parenStack.empty())
            return false; // IF stack has atleast one element
        else 
            return true;
    }
	
	public static boolean isValidInString(String s) {
		// DS: Stack only 
		// iterate through the string, pushing openings into stack
		// If a close is encountered, check top of stack to ensure it matches paren type
		// if it does, pop, otherwise, return false
		// After string
		
		return true;
	}
}
