package io.apicode.csvprocessor;

import java.util.HashMap;

public class MinData {
	
	public static void main(String[] args) {
		MinData min = new MinData();
		int data = min.lengthOfLongestSubstringTwoDistinct("abccdabcdabvefghijklabcdeabdabdabdabdabdabd", 4);
		System.out.println(data);
	}
	
	public int lengthOfLongestSubstringTwoDistinct(String s, int k) {
	    int max=0;
	    HashMap<Character,Integer> map = new HashMap<Character, Integer>();
	    int start=0;
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c,1);
	        }
	 
	        if(map.size()>k){
	            max = Math.max(max, i-start);
	 
	            while(map.size()>k){
	                char t = s.charAt(start);
	                int count = map.get(t);
	                if(count>1){
	                    map.put(t, count-1);
	                }else{
	                    map.remove(t);
	                }
	                start++;
	            }
	        }
	    }
	 
	    max = Math.max(max, s.length()-start);
	 
	    return max;
	}

}
