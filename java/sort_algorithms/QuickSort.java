import java.util.*;

//Put all non-zeros to the left, while all the zeros to the right of the list.
//https://careercup.com/question?id=5182821194792960
public class QuickSort {
	
	public void execute(final int[] input,
		final int firstIndex,
		final int lastIndex) {
		
		if (input == null || input.length == 0) {
            return;
        }
         
        int left = firstIndex;
        int right = lastIndex;
        
        // calculate pivot number, I am taking pivot as middle index number
        final int pivotIndex = (int)Math.floor(firstIndex+(lastIndex-firstIndex)/2);
        int pivot = input[pivotIndex];
        
        // Divide into two arrays
        while (left <= right) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (left < lastIndex && input[left] < pivot) {
            	System.out.println("left=" + left + "; value=" + input[left] 
            		+ "; pivotIndex=" + pivotIndex + "; pivot=" + pivot);
                left++;
            }
        	System.out.println("left=" + left + "; value=" + input[left] 
        		+ "; pivotIndex=" + pivotIndex + "; pivot=" + pivot);

            while (right > -1 && input[right] > pivot) {
            	System.out.println("right=" + right + "; value=" + input[right] 
            		+ "; pivotIndex=" + pivotIndex + "; pivot=" + pivot);
                right--;
            }
        	System.out.println("right=" + right + "; value=" + input[right] 
        		+ "; pivotIndex=" + pivotIndex + "; pivot=" + pivot);

        	System.out.println("left=" + left + "; right=" + right);
            
            if (left <= right) {
                int temp = input[left];
		        input[left] = input[right];
		        input[right] = temp;

            	System.out.println("SWITCHED left=" + left + "; value=" + input[left] 
            		+ "; right=" + right + "; value=" + input[right]);

                //move index to next position on both sides
                left++;
                right--;

            }
        }

        System.out.println("Iteration Complete... left=" + left + "; right=" + right);
        print(input);

        // call quickSort() method recursively
        if (firstIndex < right) {
        	System.out.println("Execute left sub array... firstIndex=" + firstIndex 
        		+ "; right=" + right);
            execute(input, firstIndex, right);
        }
        if (left < lastIndex) {
        	System.out.println("Execute right sub array... left=" + left 
        		+ "; lastIndex=" + lastIndex);
            execute(input, left, lastIndex);
        }
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
		QuickSort instance = new QuickSort(); 
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