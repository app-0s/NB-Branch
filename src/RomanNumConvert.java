import java.util.Stack;

public class RomanNumConvert {
	// Self
    public static int romanToInt(String s) {

        int convertedRomans = 0;
        /*
            DS: Stack
            Steps:
            1. Read each character from string, pushing each character on stack
            2. Read the stack, 2 characters/digits at a time (to account for subtraction rule)
                a. If next character is a V, X, L, C, D, or M, subtract the necessary numbers. (This may also be achieved by viewing if the current character is an I,X, or C)
                b. If not, then just perform necessary operations
        */
        Stack<Character> romanStack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            romanStack.push(s.charAt(i));
        }
        
        //"MCMXCIV"
        
        while(!romanStack.empty() && Character.isLetter(romanStack.peek()) ){
            char c = Character.toUpperCase(romanStack.pop());
            
            // Decrement where necessary. For decrement, two characters are used
            if(!romanStack.empty() && (c == 'V' || c == 'X' ||
            		c == 'L' || c == 'C' || c == 'D' || 
            		c == 'M' )){
                if(romanStack.peek() == 'I' && (c == 'V' || c == 'X')) {
                    convertedRomans -= 1;
                    romanStack.pop();
                }
                else if(romanStack.peek()  == 'X' && (c == 'L' || c == 'C')) {
                    convertedRomans -= 10;
                    romanStack.pop();
                }
                else if(romanStack.peek()  == 'C' && (c == 'D' || c == 'M')) {
                    convertedRomans -= 100;
                    romanStack.pop();
                }
            }
            
            // Add to converted numeral integer
            // could be a switch statement
            if (c == 'I')
                convertedRomans += 1;
            else if(c == 'V')
                convertedRomans += 5;
            else if(c == 'X')
                convertedRomans += 10;
            else if(c == 'L')
        		convertedRomans += 50;
            else if(c == 'C')
                convertedRomans += 100;
            else if(c == 'D')
                convertedRomans += 500;
            else if(c == 'M')
                convertedRomans += 1000;
            
        }
        if(!romanStack.isEmpty())
        	return -1;	// For invalid character input
        	
        return convertedRomans;
	}
    
    // Solution found. Recreated for learning purposes
    public static int romanToIntHash(String s) {
    	/*	DS: Hashmap
    	 * 	Steps:
    	 *  1. Add each character to a hash map
    	 *  2.  
    	 * 
    	 */
    	return 0;
    }
}
