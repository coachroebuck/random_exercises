  import java.util.*;

  public class RadixSort {

    public void execute(
      final int[] input) {

        if (input == null || input.length == 0) {
          return;
        }

        final int max = maximum(input);

      // Do counting sort for every digit. Note that instead
      // of passing digit number, exp is passed. exp is 10^i
      // where i is current digit number
      for (int exp = 1; max/exp > 0; exp *= 10) {
        countSort(input, max, exp);
      }
    }

    private int maximum(final int[] input) {
      int max = Integer.MIN_VALUE;
      for(int i = 0; i < input.length; i++) {
        if(input[i] > max) {
          max = input[i];
        }
      }

      return max;
    }

    private void countSort(
      final int[] input,
      final int max,
      final int exp) {

        int i = -1;
        int[] output = new int[input.length];
        int[] count = new int[10];

      // Store count of occurrences in count
      for (i = 0; i < input.length; i++)
          count[ (input[i]/exp)%10 ]++;

      // Change count[i] so that count[i] now contains actual
      //  position of this digit in output[]
      for (i = 1; i < 10; i++)
          count[i] += count[i - 1];

      // Build the output array
      for (i = input.length - 1; i >= 0; i--)
      {
          output[count[ (input[i]/exp)%10 ] - 1] = input[i];
          count[ (input[i]/exp)%10 ]--;
      }

      // Copy the output array to the input, so that input now
      // contains sorted numbers according to current digit
      for (i = 0; i < input.length; i++) {
        input[i] = output[i];
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
      new int[]{1, 2, 0, 3, 4, 10, 29, 11, 18, 39, 103, 382, 13, 93, 84, 759};
      RadixSort instance = new RadixSort();
      instance.print(input);
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
