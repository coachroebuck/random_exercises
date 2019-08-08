import java.util.*;

public class Exercise6 {

    public static void main(String[] args) {

    	final int min = 'A';
    	final int range = 'Z' - min + 1;
    	final String input = args.length == 1 ? args[0].toUpperCase() 
    		: "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	int value = 0;

    	for(int i = input.length() - 1, j = 0; i > -1; i--, j++) {
    		final Character c = input.charAt(i);
    		final int nextValue = c - min + 1;
    		final int power = (int)Math.pow(range, j);
			final int total = nextValue * power;
			value += total;
    	}

    	System.out.println("value=" + value);
	}
}