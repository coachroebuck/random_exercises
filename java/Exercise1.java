import java.util.*;

public class Exercise1 {

    public static void main(String[] args) {
        final int[] input = args.length == 1 ? getNumericArray(args[0]) :
		 	new int[]{2, 1, 2, 101, 4, 95, 3, 250, 4, 1, 2, 2, 7, 98, 123, 99};
		Map<Integer,String> map = new HashMap<Integer,String>();  
		for(int nextInput : input) {
		    final int nextKey = nextInput < 100 ? nextInput : 100;
		    String str = map.get(nextKey);
		    str = str == null ? "x" : str + "x";
		    map.put(nextKey, str);
		}

		for(int i = 0; i < 101; i++) {
			System.out.print(i < 100 ? i : "99+"); 
			System.out.print(" | "); 
			System.out.println(map.get(i) != null ? map.get(i) : "");
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