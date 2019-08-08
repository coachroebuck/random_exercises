import java.util.*;

public class InsertionSort {

	public void execute(final int[] input,
		final int firstIndex,
		final int lastIndex) {

    if (input == null || input.length == 0) {
      return;
    }

    for(int i = firstIndex; i < lastIndex; i++) {
      final int x = input[i];
      int j = i - 1;
      while(j >= 0 && input[j] > x) {
        input[j + 1] = input[j];
        j = j - 1;
      }

      input[j + 1] = x;
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
		InsertionSort instance = new InsertionSort();
    	instance.print(input);
    	instance.execute(input, 0, input.length);
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
