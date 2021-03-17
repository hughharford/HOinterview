package com.posco.interviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupedAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int getGroupedAnagrams(List<String> words) {

        Set<String> groupA = new HashSet<String>();
        // Set<Integer> multiplyKey = new HashSet<Integer>();

        // HashMap<String, String> previousAttempt = new HashMap<StringString>;
        
        //* use Streams instead of for loop, if warranted
        for (String s : words) {
            // int multiplyOverflowingIntKey = 1;
            char[] cs = s.toCharArray();
            Arrays.sort(cs);       //* this sort is the complexity issue v. N
            /*
            for (char c : cs) {
                multiplyOverflowingIntKey = multiplyOverflowingIntKey * (int) c;
            }
            multiplyKey.add(multiplyOverflowingIntKey);
            */
            groupA.add(new String(cs));
               
        }
        return groupA.size();
        // return multiplyKey.size();

    }

}


