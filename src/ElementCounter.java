import java.util.HashMap;
import java.util.Stack;

public class ElementCounter {
	
	private String word = ""; 
	private String num = "";

	Stack<Integer> multipliers;
	
	HashMap<String, Integer> countElements(String input){
		HashMap<String, Integer> ret = new HashMap<String, Integer>();
		multipliers = new Stack<Integer>();
		
		System.out.println("Evaluating string " + input);
		startWord();

		char c;
		
		for(int l=0; l<input.length(); l++){
			
			c = input.charAt(l);
			
			if(c == '('){
				endWord(ret);
				startWord();
				multipliers.push(findClosingBracket(input, l));
			}
			
			if(c == ')'){
				endWord(ret);
				startWord();
				multipliers.pop();
			}
			
			if(isUpperCase(c)){
				endWord(ret);
				startWord();
				word += c;
			}
			
			if(isLowerCase(c)){
				word += c;
			}
			
			if(isNumeric(c)){
				num += c;
			}

		}
		endWord(ret);
		
		return ret;
	}
	
	void startWord(){
		word = "";
		num = "";
	}
	
	void endWord(HashMap<String, Integer> ret){
		
		if(word == "")
			return;
		
		String output = word;
		
		int reps = 1;
		
		if(num != "")
			reps = Integer.parseInt(num);
		
		for(int multiplier : multipliers){
			reps *= multiplier;
		}

		if(word.length() > 0){
			if(ret.containsKey(word)){
				reps += ret.get(word);
			}
			ret.put(word, reps);
		}
		
	}
	
	boolean isUpperCase(char c){
		if(c >= 'A' && c <= 'Z')
			return true;
		return false;
	}
	
	boolean isLowerCase(char c){
		if(c >= 'a' && c <= 'z')
			return true;
		return false;
	}
	
	boolean isNumeric(char c){
		if(c >= '0' && c <= '9')
			return true;
		return false;
	}
	
	
	// Finds the closing bracket of the opening bracket at "start".
	// Returns the trailing number, if any.
	int findClosingBracket(String input, int start){
		int depth = 0; // If we hit a closing bracket, depth--. if 0, we're done!
		String num = "";
		
		for(int l=start; l<input.length(); l++){
			char c = input.charAt(l);
			
			if(c == '(')
				depth++;
			if(c == ')'){
				depth--;
				if(depth == 0){
					
					for(int n=l+1; n<input.length(); n++){
					
						c = input.charAt(n);
						
						if(isNumeric(c)){
							num += c;
						}
						else{
							break;
						}
					}
				}
			}
		}

		if(num != "")
			return Integer.parseInt(num);
		else
			return 1;
	}
}
