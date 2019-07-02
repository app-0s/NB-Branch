import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LongestCommonPrefx {
	/*
	public static String longestCommonPrefix(String[] strs) {
		StringBuilder sbLCP = new StringBuilder();
		
		if(strs.length < 1)
			return " ";
		
		//List<Integer> strIndexList = new List<Integer>();
		HashMap<String, Integer> strIndexList = new HashMap<String, Integer>();
		boolean noLCP = false;
		
		// Add each string to the map as key and its initial index = 0 as value
		for(int i = 0; i < strs.length; i++) {
			strIndexList.put(strs[i], 0);
		}
		
		// Outer loop: Look at each char for string
		for(int i = 0; i < strs[0].length() && !noLCP; i++) {
			char currChar = strs[0].charAt(i);	// Look through each char
			
			// See if char exists in other strings
			for(int j = 1; j < strs.length; j++) {
				String oString = strs[j];
				for(int jChar = strIndexList.get(oString); jChar < oString.length() && oString.length() >= strs[0].length(); jChar++) {
					if(strs[j].charAt(jChar) == currChar) {
						strIndexList.put(oString,  strIndexList.get(oString) + 1); // Update the jChar position in map with corresponding key
						noLCP = false;// Set noLCP to true
						break; // exit this loop
					} else
						noLCP = true;
					
				}	
			}
			// Verify each string's char index is pointing to currChar
			if(!noLCP)
				sbLCP.append(currChar);
		}
		
		return sbLCP.toString();
	}
	*/
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length < 1)
			return " ";
		else if (strs.length == 1)
			return strs[0];
		
		Queue<Character>[] qArr = new LinkedList[strs.length];
		StringBuilder sbLCP = new StringBuilder();
		////List<Queue> queueList = new List<Queue>();
		
		
		// For each queue, add characters for each string
		for(int i = 0; i < strs.length; i++){
			qArr[i] = new LinkedList<Character>();
			for(int charInd = 0; charInd < strs[i].length(); charInd++) {
				qArr[i].add(strs[i].charAt(charInd));
			}
		}
		
		boolean loop = true;
		// For each queue, evaluate if common prefix exists
		// Cycle through each character on string
		while(loop) {
		    if (qArr[0].peek() == null)
		    	break;
		    
		    Character c = qArr[0].poll();// Pull the character from first queue
			// 3 conditions loop will trip: A queue is emptied, a prefix is not found on first char, or a prefix ends
			for(int qInd = 1; qInd < qArr.length; qInd++) {	// for each queue after initial
				Character currQueueHead = qArr[qInd].poll();
				
				// compare the character at head with c
				if(currQueueHead != c || currQueueHead == null)
					loop = false; // If not/no longer equal, set loop to false
			}
			// Check loop. If still true, add c to sbLCP
			if(loop)
				sbLCP.append(c);
		}
		
		return sbLCP.toString();
	}
	
}
