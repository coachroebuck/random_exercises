import java.util.*;

public class Exercise7 {

    public static void main(String[] args) {

    	final String input = args.length == 1 ? args[0].toUpperCase() 
    		: "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	int currentFoo = 0;
		int maxFoo = 0;
		Character currentChar = 0x00;

    	for(int i = 0; i < input.length(); i++) {
    		final Character c = input.charAt(i);

    		if(c == currentChar) {
    			currentFoo++;
    		}
    		else {
    			if(currentFoo > maxFoo) {
    				maxFoo = currentFoo;
    			}
    			currentFoo = 0;
    			currentChar = c;
    		}
    	}

		if(currentFoo > maxFoo) {
			maxFoo = currentFoo;
		}

    	System.out.println("maxFoo=" + maxFoo);
	}
}