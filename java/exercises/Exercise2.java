import java.util.*;

public class Exercise2 {

    public static void main(String[] args) {
		
		final int[] input = args.length == 1 ? getNumericArray(args[0]) :
		 	new int[]{1, 6, 3, 2, 5, 5, 7, 8, 4, 8, 2, 5, 9, 9, 1};
		Map<Integer,List<Integer>> bucket = new HashMap<Integer,List<Integer>>();  
		
		for(int nextInput : input) {
			if(!bucket.containsKey(nextInput)) {
				bucket.put(nextInput, new ArrayList<Integer>());
			}
			List<Integer> list = bucket.get(nextInput);
			list.add(nextInput);
		}

		//We must deal with the number # 5 before we continue
		//or we will end up with the wrong output 
		//because an extra copy has been added to the list.
		if(bucket.containsKey(5)) {
			List<Integer> list = bucket.get(5);
			if(list.size() > 1) {
				list.remove(0);
			}
		}

		for(int nextInput : input) {
			final int answer = 10 - nextInput;
			if(bucket.containsKey(answer)) {
				List<Integer> list = bucket.get(answer);
				for(int nextInstance : list) {
					System.out.println("("+ nextInput + "," + nextInstance + ")");
				}
			}
		}
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