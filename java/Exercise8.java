import java.util.*;

public class Exercise8 {
	public int firstIndex;
	public int lastIndex;
	public int total;

	public int find(final int[] input,
		final int firstIndex,
		final int lastIndex) {
		
		int a = 0;
		int b = 0;
		int total = 0;

		this.total = Integer.MIN_VALUE;
		this.firstIndex = 0;
		this.lastIndex = 0;

		for(int next: input) {
			total += next;
			if(total > this.total) {
				this.firstIndex = a;
				this.lastIndex = b;
				this.total = total;
			}
			else {
				total -= input[a];
				a++;
			}
			b++;
		}

		return this.total;
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
		 	new int[]{1, -3, 2, 1, -1}; //{-2,11,-4,13,-5,-2};
		Exercise8 instance = new Exercise8(); 
    	instance.print(input);
    	int total = instance.find(input, 0, input.length);
    	
    	StringBuilder sb = new StringBuilder();

    	sb.append("MAX: ");
    	for(int i = instance.firstIndex; i <= instance.lastIndex; i++) {
    		sb.append(input[i]);
    		sb.append(" ");
    	}
    	sb.append("; from=" + instance.firstIndex + " to " + instance.lastIndex + " = " + instance.total);

    	System.out.println(sb.toString());
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