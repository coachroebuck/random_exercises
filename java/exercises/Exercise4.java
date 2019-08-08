import java.util.*;

public class Exercise4 {

    public static void main(String[] args) {
		
		final int[] input = args.length == 2 ? getNumericArray(args[0]) :
		 	new int[]{1, 6, 3, 2, 5, 5, 7, 8, 4, 8, 2, 5, 9, 9, 1};
		 final int targetValue = args.length == 2 ? Integer.parseInt(args[1]) : 8;
		Map<Integer,List<Integer>> bucket = new HashMap<Integer,List<Integer>>();  
		boolean isValid = false;
		
		//given our list that we are grouping into buckets, 
		// as we are doing this,
		// determine whether or not there exists two elements in our list
		// whose sum is equal to some target value.
		//e.g. [5, 4, 2, 4], 8 => true
		//e.g. [5, 1, 2, 4], 8 => false
		for(int nextInput : input) {
			if(!bucket.containsKey(nextInput)) {
				bucket.put(nextInput, new ArrayList<Integer>());
			}
			List<Integer> list = bucket.get(nextInput);
			list.add(nextInput);

			final int answer = targetValue - nextInput;
			if(bucket.containsKey(answer)) {
				list = bucket.get(answer);
				if(nextInput == answer && list.size() >= 2
					|| (nextInput != answer)) {
					isValid = true;
				}
			}
		}

		System.out.println("isValid=" + isValid);
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