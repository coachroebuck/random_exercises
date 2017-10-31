import java.util.*;

//Put all non-zeros to the firstIndex, while all the zeros to the lastIndex of the list.
//https://careercup.com/question?id=5182821194792960
public class HeapSort {
	
	public void execute(final int[] input) {
		int N = input.length - 1;

		log("START execute() N=" + N);

		heapify(input);
		
		for (int i = N; i > 0; i--)
        {
            swap(input,0, i);
            N = N-1;
            maxheap(input, 0, N);
        }

		log("END execute()");
    }   

    /* Function to build a heap */   
    private void heapify(int input[])
    {
        final int N = input.length-1;

		log(String.format("\tSTART heapify(): N=%d", N));

        for (int i = N/2; i >= 0; i--) {
        	maxheap(input, i, N);        
        }

		log(String.format("\tEND heapify(): N=%d", N));
    }

    /* Function to swap largest element in heap */        
    private void maxheap(int input[], 
    	final int i,
    	final int N)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;

        log(String.format("\t\tSTART maxheap(): i=%d left=%d right=%d max=%d",
       		i, left, right, max));

        if (left <= N && input[left] > input[max]) {
            max = left;
        }
        if (right <= N && input[right] > input[max]) {
            max = right;
        }
 
        log(String.format("\t\tEND maxheap(): i=%d left=%d right=%d max=%d", i, left, right, max));

        if (max != i)
        {
            swap(input, i, max);
            maxheap(input, max, N);
        }
    }  

    /* Function to swap two numbers in an array */
    private void swap(int input[], int i, int j)
    {
    	log(String.format("\t\t\tSTART swap() i=%d value=%d j=%d value=%d", i, input[i], j, input[j]));

        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp; 

    	log(String.format("\t\t\tEND swap() i=%d value=%d j=%d value=%d", i, input[i], j, input[j]));

		print(input);
    }  

    public void print(final int[] input) {
		StringBuilder sb = new StringBuilder();

    	for(int i = 0; i < input.length; i++) {
    		sb.append(input[i]);
    		sb.append("\t");
    	}
    	
    	log(sb.toString());
    }

    private void log(final String message) {
    	System.out.println(message);
    }

    public static void main(String[] args) {
        final int[] input = args.length == 1 ? getNumericArray(args[0]) :
		 	new int[]{1, 0, 2, 0, 0, 3, 4};
		HeapSort instance = new HeapSort(); 
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