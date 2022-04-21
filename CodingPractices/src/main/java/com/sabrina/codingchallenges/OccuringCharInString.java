package com.sabrina.codingchallenges;

import java.util.HashMap;
import java.util.Map;

public class OccuringCharInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();// Creating HashMap
		m = countOccuringOfChar("sabrinadjeddi");

		System.out.println("Iterating Hashmap...");
		for (Map.Entry e : m.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
	
	public static HashMap<Character, Integer> countOccuringOfChar(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // Converting given string to char array
		char [] str = s.toCharArray();		
		for (char c : str) {
			if (map.containsKey(c)) {
				// If char is present in a map incrementing it's count by 1
				map.put(c, map.get(c)+1);
				
			}else {
				// If char is not present in charCountMap a map putting this char to map with 1 as value
                map.put(c, 1);
			}
		}
		return map;
		
	}

}
