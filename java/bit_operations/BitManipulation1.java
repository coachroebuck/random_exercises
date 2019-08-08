import java.util.*;

//Put all non-zeros to the left, while all the zeros to the right of the list.
//https://careercup.com/question?id=5182821194792960
public class BitManipulation1 {
	
	public static void main(String[] args) {
        final int input = args.length == 1 ? Integer.parseInt(args[0]) : 45;
		final String inputBinary = Integer.toBinaryString(input);
		int inputTotalBytesSet = getTotalBytesSet(input);
		
		int smallerNumber = findSmallerNumberAnswer(input);
		final String smallerBinary = Integer.toBinaryString(smallerNumber);
		int smallerTotalBytesSet = getTotalBytesSet(smallerNumber);
		
		int largerNumber = findLargerNumberAnswer(input);
		final String largerBinary = Integer.toBinaryString(largerNumber);
		int largerTotalBytesSet = getTotalBytesSet(largerNumber);
		
    	System.out.println("input=" + input 
    		+ "; binary=" + inputBinary
    		+ "; totalBytesSet=" + inputTotalBytesSet);

    	System.out.println("smallerNumber=" + smallerNumber 
    		+ "; binary=" + smallerBinary
    		+ "; totalBytesSet=" + smallerTotalBytesSet);

    	System.out.println("largerNumber=" + largerNumber 
    		+ "; binary=" + largerBinary
    		+ "; totalBytesSet=" + largerTotalBytesSet);
    }

    public static int getTotalBytesSet(final int input) {
    	final String binaryString = Integer.toBinaryString(input);
		int totalBytesSet = 0;
		
		for(int i = 0; i < binaryString.length(); i++) {
			Character c = binaryString.charAt(i);
			final int nextBit = Integer.parseInt(c.toString());
			if(nextBit == 1) {
				totalBytesSet++;
			}
		}

		return totalBytesSet;
    }

    public static boolean GetBit(int n, int index) {
    	return ((n & (1 << index)) > 0);
	}

	public static int SetBit(int n, int index, boolean b) {
		if(b) {
			return n | (1 << index);
		}
		else {
			int mask = ~(1 << index);
			return n & mask;
		}
	}

    public static int findLargerNumberAnswer(int input) {
    	if(input < 0) {
    		return 0;
    	}
    	if(input == 0) {
    		return 1;
    	}
    	
    	int index = 0;
    	int countOnes = 0;
    	
    	//Find the first byte that's been set
    	while (!GetBit(input, index)) index++; 

    	//Set the next bit that's been cleared
    	while (GetBit(input, index)) {
    		index++;
    		countOnes++;
    	}

    	input = SetBit(input, index, true);

    	//Clear the previous bit that's been set
    	index--;
    	input = SetBit(input, index, false);
    	countOnes--;

    	//Clear the remaining leading zeros
    	for (int i = index - 1; i >= countOnes; i--) {
    		input = SetBit(input, i, false);
    	}

    	for(int i = countOnes - 1; i >= 0; i--) {
    		input = SetBit(input, i, true);
    	}

    	return input;
    }

    public static int findSmallerNumberAnswer(int input) {
    	if(input < 1) {
    		return 0;
    	}
    	if(input == 1) {
    		return 0;
    	}
    	
    	int index = 0;
    	int countOnes = 0;
    	
    	//Find the first byte that's been cleared
    	while (GetBit(input, index)) index++; 

    	//Clear the next bit that's been set
    	while (!GetBit(input, index)) {
    		index++;
    		countOnes++;
    	}

    	input = SetBit(input, index, false);

    	//Clear the previous bit that's been set
    	index--;
    	input = SetBit(input, index, true);
    	countOnes--;

    	//Clear the remaining leading zeros
    	for (int i = index - 1; i >= countOnes; i--) {
    		input = SetBit(input, i, true);
    	}

    	for(int i = countOnes - 1; i >= 0; i--) {
    		input = SetBit(input, i, false);
    	}

    	return input;
    }
}