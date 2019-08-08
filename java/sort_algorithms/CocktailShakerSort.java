import java.util.*;

//Put all non-zeros to the firstIndex, while all the zeros to the lastIndex of the list.
//https://careercup.com/question?id=5182821194792960
public class CocktailShakerSort {
	
	public void execute(final int[] input) {
		boolean didSwap = false;

		do {
			for(int i = 0; i < input.length - 2; i++) {
				if(didSwap(input, i)) {
					didSwap = true;
				}
			}

			if(didSwap) {
				didSwap = false;
				for(int i = input.length - 2; i > -1; i--) {
					if(didSwap(input, i)) {
						didSwap = true;
					}
				}
			}

		} while(didSwap);
    }  

    private boolean didSwap(final int[] input, final int index) {
    	if(input[index] > input[index + 1]) {
    		final int temp = input[index + 1];
    		input[index + 1] = input[index];
    		input[index] = temp;
    		return true;
    	}
    	return false;
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
		CocktailShakerSort instance = new CocktailShakerSort(); 
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