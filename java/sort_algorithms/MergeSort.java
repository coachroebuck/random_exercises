import java.util.*;

//Put all non-zeros to the firstIndex, while all the zeros to the lastIndex of the list.
//https://careercup.com/question?id=5182821194792960
public class MergeSort {
	
	public void execute(final int[] input,
		final int firstIndex,
		final int lastIndex) {
		
        System.out.println("Iteration Start... firstIndex=" + firstIndex + "; lastIndex=" + lastIndex);

		if (!(input == null || input.length == 0 || firstIndex >= lastIndex)) {
	        final int midIndex = (int)Math.floor(firstIndex+(lastIndex-firstIndex)/2);
	        
	        execute(input, firstIndex, midIndex);
	        execute(input, midIndex + 1, lastIndex);

	        for(int i = firstIndex; i <= lastIndex && i < input.length - 1; i++) {
	            if (input[i] > input[i + 1]) {
	                int temp = input[i];
			        input[i] = input[i + 1];
			        input[i + 1] = temp;

	            	System.out.println("SWITCHED i=" + i + "; value=" + input[i] + "; next=" + input[i+1]);
	            }
	        }
        }

        System.out.println("Iteration Complete... firstIndex=" + firstIndex + "; lastIndex=" + lastIndex);
		print(input);
    }

    public void print(final int[] input) {
		StringBuilder sb = new StringBuilder();

    	for(int i = 0; i < input.length; i++) {
    		sb.append(input[i]);
    		sb.append("\t");
    	}
    	
    	System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        final int[] input = args.length == 1 ? getNumericArray(args[0]) :
		 	new int[]{1, 0, 2, 0, 0, 3, 4};
		MergeSort instance = new MergeSort(); 
    	instance.print(input);
    	instance.execute(input, 0, input.length - 1);
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