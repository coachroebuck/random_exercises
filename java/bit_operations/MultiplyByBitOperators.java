import java.util.*;

//Put all non-zeros to the left, while all the zeros to the right of the list.
//https://careercup.com/question?id=5182821194792960
public class MultiplyByBitOperators {
	
	public static void main(String[] args) {
        final int a = args.length >= 1 ? Integer.parseInt(args[0]) : 1;
        final int b = args.length >= 2 ? Integer.parseInt(args[1]) : 1;
        final int c = Multiply(a, b);
		System.out.println(a + " - " + b + " = " + c);

		/*
		7 - 5 = 2
		0101
		0101
		----
	   11001	

		65 - 44 = 21
		01000001
		00101100
		--------
		00010101

		*/
    //     for(int a = 0; a < 100; a++) {
    //     	for(int b = 0; b < 100; b++) {
		  //       final int c = Multiply(a, b);
				// System.out.println(a + " + " + b + " = " + c);
    //     	}
    //     }
    }

    public static int Multiply(int x, int y)
	{
	   /* 0  multiplied with anything gives 0 */
	   if(y == 0)
	     return 0;

	   /* Add x one by one */ 
	   else if(y > 0 )
	     return Add(x, Multiply(x, y-1));
	 
	  /* the case where y is negative */ 
	   else
	     return -Multiply(x, -y);
	}

    public static int Add(int x, int y)
	{
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	    	System.out.println(x + " && " + y);
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
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