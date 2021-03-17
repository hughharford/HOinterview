package com.posco.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HomeOffice {

	public static void main(String[] args) {
		checkMathsAnagramApproach();
	}
	
	private static void checkMathsAnagramApproach() {
		String[] these = {	"catcatcatcat", 
							"catcatcatcat", 
							"actactactact", 
							"tactactactac"};
		
		/*
		 * {	"catcatcatcattryhardtryhardtryhard", 
							"catcotcatcattryharardtrdyhyhtrard", 
							"actactryhardtrdyhyraactactartrhtd", 
							"tatryhardcyhardardtrtatryhctacact"};
		 */
		int[] those = {0,0,0,0};
		int multi = 1;
		int check = 0;
		for (int i = 0; i < these.length; i++) {
			multi = 1;
			System.out.println("word: " + these[i]);
			for (char c : these[i].toCharArray()) {
				System.out.println((int) c);
				multi = multi * ((int) c - 96);
				System.out.println("Multiply: " + multi);
				if (multi > 1000000) multi = multi / 100000;
			}
			
			those[i] = multi;
		}
		for (double x : those) {
			check += x;
		}
		System.out.println(Arrays.toString(those));
		System.out.println(check/those.length);
		
		
	}

	private static void stringListsEtc() {
		String[] here = {"c","d","a","b","e"};
		List<String> here2 = new ArrayList<String>();
		here2.add("d");
		here2.add("f");
		here2.add("e");
		here2.add("a");
		here2.add("c");
		here2.add("b");

		Arrays.parallelSort(here);
		Collections.sort(here2);
		
		System.out.println("here, sorted: " + Arrays.toString(here));
		System.out.println("here2, sorted: " + here2.toString());
		
		List<String> thisString = new ArrayList<String>();
		List<String> nextString = new ArrayList<String>();

		String s = "wordathon";
		for (int sInd = 0; sInd < s.length(); sInd++){
            thisString.add(Character.toString(s.charAt(sInd)));
        }
		for (int sInd = 0; sInd < s.length(); sInd++){
			nextString.add(Arrays.toString(new String[] {s}));
        }

		System.out.println("thisString: " + thisString.toString());
		System.out.println("nextString: " + nextString.toString());

        List<String> now = new ArrayList<String>();

		now = Arrays.asList(s);
		Collections.sort(now);
		System.out.println("now: " + now.toString());
	}

}
