import java.util.*;

public class Exercise3 {

    public static void main(String[] args) {

    	final String input = args.length == 1 ? args[0] : "abcd";
		final double permutations = Math.pow((double)input.length(), 2);
		final int iterations = (int)(permutations%2 == 0 ? permutations : permutations - 1);
		
		for(int i = 0; i < iterations; i++) {
			String str = Integer.toBinaryString(i);

			//I've chosen to pad with leading zeros for simplicity.
			for(int j = str.length(); j < input.length(); j++) {
				str = "0" + str;
			} 
			
			String nextCombo = "";
			for(int j = str.length() - 1; j > -1; j--) {
				Character c = str.charAt(j);
				final int nextBit = Character.getNumericValue(c);
				if(nextBit == 1) {
					Character nextCharacter = input.charAt(j);
					nextCombo = nextCharacter + nextCombo;
				}
			}

			System.out.println(nextCombo);
		}
	}
}