import java.util.*;

//Put all non-zeros to the left, while all the zeros to the right of the list.
//https://careercup.com/question?id=5182821194792960
public class Exercise9 {
	
	public void find(final int[] input,
		final int firstIndex,
		final int lastIndex) {
		
		int i = 0;
		int j = lastIndex - 1;

		while(i < j) {
			if(input[i] == 0 && input[j] != 0) {
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
			}
			if(input[i] != 0) {
				i++;
			}
			if(input[j] == 0) {
				j--;
			}
		}
	}

	public void print(final int[] input) {
    	
    	StringBuilder sb = new StringBuilder();

    	for(int i = 0; i < input.length; i++) {
    		sb.append(input[i]);
    		sb.append(" ");
    	}
    	
    	System.out.println(sb.toString());
	}

    public static void main(String[] args) {
        final int[] input = args.length == 1 ? getNumericArray(args[0]) :
		 	new int[]{1, 0, 2, 0, 0, 3, 4};
		Exercise9 instance = new Exercise9(); 
    	instance.print(input);
    	instance.find(input, 0, input.length);
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