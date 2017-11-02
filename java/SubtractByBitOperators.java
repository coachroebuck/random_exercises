import java.util.*;

//Put all non-zeros to the left, while all the zeros to the right of the list.
//https://careercup.com/question?id=5182821194792960
public class SubtractByBitOperators {
	
	public static void main(String[] args) {
        final int a = args.length >= 1 ? Integer.parseInt(args[0]) : 1;
        final int b = args.length >= 2 ? Integer.parseInt(args[1]) : 1;
        final int c = Subtract(a, b);
		System.out.println(a + " - " + b + " = " + c);

		/*
		7 - 5 = 2
		0111
		0101
		----
		0010

		65 - 44 = 21
		01000001
		00101100
		--------
		00010101

		*/
    //     for(int a = 0; a < 100; a++) {
    //     	for(int b = 0; b < 100; b++) {
		  //       final int c = Subtract(a, b);
				// System.out.println(a + " + " + b + " = " + c);
    //     	}
    //     }
    }

    public static int Subtract(int x, int y)
	{
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	    	System.out.println(x + " && " + y);
	        // carry now contains common set bits of x and y
	        int carry = (~x) & y;  
	 
	 		System.out.println("carry=" + carry + "; bits=" + Integer.toBinaryString(carry));
	        
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	 		System.out.println("x=" + x + "; bits=" + Integer.toBinaryString(x));
	        
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;

	 		System.out.println("y=" + y + "; bits=" + Integer.toBinaryString(y));	        
	    }
	    
	    return x;
	}
}