import java.util.*;

//Binary trees: Least Common Ancestor; NP-Completness check
public class InterpolationSearch {

	//returns the position
	public int execute(final List<Integer> list, final int x) {
		// Find indexes of two corners
        int lo = 0, hi = (list.size() - 1);
      
        // Since array is sorted, an element present
        // in array must be in range defined by corner
        while (lo <= hi && x >= list.get(lo) && x <= list.get(hi))
        {
        	// Probing the position with keeping
            // uniform distribution in mind.
            int pos = lo + (((hi-lo) /
                  (list.get(hi)-list.get(lo)))*(x - list.get(lo)));
      
            log("lo=" + lo + "; hi=" + hi + "; pos=" + pos);
            
            // Condition of target found
            if (list.get(pos) == x)
                return pos;
      
            // If x is larger, x is in upper part
            if (list.get(pos) < x)
                lo = pos + 1;
      
            // If x is smaller, x is in lower part
            else
                hi = pos - 1;
        }
        return -1;
	}

	public void print(final List list) {
		StringBuilder sb = new StringBuilder();
		for (Object s : list)
		{
			sb.append(s.toString());
		    sb.append("\t");
		}

		log(sb.toString());
	}

	public void log(final String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
        InterpolationSearch instance = new InterpolationSearch(); 
        final List<Integer> list = new ArrayList<Integer>();

        //the maximum value
		final int maximum = args.length >= 1 ? Integer.parseInt(args[0]) : 100;

		//the target number
		final int n1 = args.length >= 2 ? Integer.parseInt(args[1]) : 12;

		//the amount to increment in the list
		final int n2 = args.length >= 3 ? Integer.parseInt(args[2]) : 1;
		
    	for(int i = 1; i <= maximum; i += n2) {
    		list.add(i);
    	}
    	
    	System.out.println(instance.execute(list, n1));
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