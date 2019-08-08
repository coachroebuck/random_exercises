import java.util.*;

//Put all non-zeros to the firstIndex, while all the zeros to the lastIndex of the list.
//https://careercup.com/question?id=5182821194792960
public class GnomeSort {
	public void execute(final int[] input) {
		int position = 0;
		while(position < input.length - 1) {
			if(position == 0 || input[position] >= input[position - 1]) {
				position++;
			}
			else {
				final int temp = input[position - 1];
				input[position - 1] = input[position];
				input[position] = temp;
				position--;
			}
		}
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
		GnomeSort instance = new GnomeSort(); 
		instance.execute(input);
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