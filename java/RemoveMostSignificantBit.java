import java.util.*;

//Put all non-zeros to the left, while all the zeros to the right of the list.
//https://careercup.com/question?id=5182821194792960
public class RemoveMostSignificantBit {
	
	public static void main(String[] args) {
        final int input = args.length >= 1 ? Integer.parseInt(args[0]) : 31;
        final String inputBytes = Integer.toBinaryString(input);
        final String bytes = Integer.toBinaryString(Integer.MAX_VALUE);
        
        int mask = Integer.MAX_VALUE ^ (Integer.MAX_VALUE >> 1);
		final String maskBytes = Integer.toBinaryString(mask);
		
        int output = input ^ mask; 
        while(output > input) {
        	mask >>= 1;
        	output = input ^ mask;
        }
        
        final String outputBytes = Integer.toBinaryString(output);
		System.out.println("input=" + input);
		System.out.println(inputBytes);
        System.out.println("output=" + output);
		System.out.println("bytes=" + outputBytes);
    }
}