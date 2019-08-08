import java.util.*;

//Put all non-zeros to the firstIndex, while all the zeros to the lastIndex of the list.
//https://careercup.com/question?id=5182821194792960
public class CountingSort {
	
	public void execute(final int[] input) {
		int n = input.length;
 
        // The output character array that will have sorted input
        int output[] = new int[n];
 
        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;
 
 		log("Input:");
 		print(input);
    	
        // store count of each character
        for (int i=0; i<n; ++i)
            ++count[input[i]];

        log("Totals:");
 		print(count);

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];
 
        log("positions:");
 		print(count);

        // Build the output character array
        for (int i = 0; i<n; ++i)
        {
            output[count[input[i]]-1] = input[i];
            --count[input[i]];
        }
 
        // Copy the output array to input, so that input now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            input[i] = output[i];
    }  

    public void print(final int[] input) {
		StringBuilder sb = new StringBuilder();

    	for(int i = 0; i < input.length; i++) {
    		sb.append(input[i]);
    		sb.append("\t");
    	}
    	
    	log(sb.toString());
    }

    public void log(final String message) {
    	System.out.println(message);
    }

    public static void main(String[] args) {
        final int[] input = args.length == 1 ? getNumericArray(args[0]) :
		 	new int[]{1, 0, 2, 0, 0, 3, 4};
		CountingSort instance = new CountingSort(); 
		instance.execute(input);
    	instance.log("Output:");
    	instance.print(input);
    }

	private static int[] getNumericArray(final String str) {
		String[] stringArray = str.split(",");
		int[] intArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			String numberAsString = stringArray[i];
			intArray[i] = Integer.parseInt(numberAsString);
		}
        
        return intArray;
	}
}