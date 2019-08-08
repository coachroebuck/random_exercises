import java.util.*;

//Put all non-zeros to the left, while all the zeros to the right of the list.
//https://careercup.com/question?id=5182821194792960
public class SwapBitsRequired {
	
	public static void main(String[] args) {
        final int a = args.length >= 1 ? Integer.parseInt(args[0]) : 31;
		final int b = args.length >= 2 ? Integer.parseInt(args[1]) : 14;
		System.out.println("bitsRequiredForConversion=" + bitsRequiredForConversion(a, b));
    }

    public static int bitsRequiredForConversion(final int a, final int b) {
    	int total = 0;

    	for(int c = a ^ b; c != 0; c >>= 1) {
    		total += c & 1;
    	}
    	return total;
    }
}