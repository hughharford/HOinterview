package posco;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupedAnagram {

	private List<String> wordsIn;
	private Analyser a1;
	private int noAnagramGroups;
	
	public GroupedAnagram(String apiVersion) {
		AnalyserFactory aFactory = new AnalyserFactory();
		a1 = aFactory.getAnalyser(apiVersion);
	}
	
	public void input(List<String> w) {
		wordsIn = w;
		a1.processInput(wordsIn);
	}
	
	public int getNumberOfGroupedAnagrams() {
        return noAnagramGroups;
	}
	    
    public class AnalyserFactory {
    	
    	public Analyser getAnalyser(String analyseSpec) {
    		switch (analyseSpec) {
    		case "0.0.1":
    			return new InitialAnalyser();
    		case "0.0.2":
        		return new BetterAnalyser();
        	default:
        		return null;
    		}
    	}
    
    }
    
    public class InitialAnalyser implements Analyser {

		public void processInput(List<String> words) {

	        Set<String> groupA = new HashSet<String>();
        
	        for (String s : words) {
	            char[] cs = s.toCharArray();
	            Arrays.sort(cs);       
	            groupA.add(new String(cs));
	        }
	        noAnagramGroups = groupA.size();
		}
    	
	    public int countAnagramGroups() {
	        return noAnagramGroups;
	    }
    }
    
    public class BetterAnalyser implements Analyser {

		public void processInput(List<String> words) {

	        Set<HashMap<Character,Integer>> groupAbyInteger = new HashSet<>();
	        
	        for (String s : words) {
		        HashMap<Character,Integer> asciiPerWord = new HashMap<>();
	            
	            for (char c : s.toCharArray()) {
	            	if (!asciiPerWord.containsKey(c)) asciiPerWord.put(c, 1);
	            	else	asciiPerWord.put(c,asciiPerWord.get(c) + 1);

	            }
	            groupAbyInteger.add(asciiPerWord);
	        }
	        noAnagramGroups = groupAbyInteger.size();
		}
    	
	    public int countAnagramGroups() {
	        return noAnagramGroups;
	    }
    }
    
}


