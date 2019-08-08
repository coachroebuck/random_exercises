import java.util.*;

//Input: nums = [10, 5, 2, 6], k = 100
// Output: 8
// Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
// Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
public class Exercise10 {
	
	private class DataStructure {
		private int firstIndex = 0;
		private int lastIndex = 0;

		DataStructure(final int firstIndex, final int lastIndex) {
			this.firstIndex = firstIndex;
			this.lastIndex = lastIndex;
		}

		public int getFirstIndex() {
			return this.firstIndex;
		}

		public int getLastIndex() {
			return this.lastIndex;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (!DataStructure.class.isAssignableFrom(obj.getClass())) {
				return false;
			}
			final DataStructure other = (DataStructure) obj;
			// if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
			// 	return false;
			// }
			if (this.getFirstIndex() != other.getFirstIndex()) {
				return false;
			}
			if (this.getLastIndex() != other.getLastIndex()) {
				return false;
			}
			return true;
		}

	}

	private List<DataStructure> subarrays = new ArrayList<DataStructure>();

	public int find(final int[] input,
		final int k,
		final int firstIndex,
		final int lastIndex) {
		
		int totalSubArrays = 0;

		if(firstIndex < lastIndex) {
			int total = 1;
			for(int i = firstIndex; i < lastIndex; i++) {
				total *= input[i];
			}

			if(total < k) {
				DataStructure ds = new DataStructure(firstIndex, lastIndex);
				if(!subarrays.contains(ds)) {
					subarrays.add(ds);
					totalSubArrays++;
				}
			}

			totalSubArrays += find(input, k, firstIndex + 1, lastIndex);
			totalSubArrays += find(input, k, firstIndex, lastIndex - 1);
		}

		return totalSubArrays;
	}

	public String printValidSubArrays(final int[] input) {
		final StringBuilder sb = new StringBuilder();

		for(final DataStructure ds : subarrays) {
			sb.append("[");
    		for(int i = ds.getFirstIndex(); i < ds.getLastIndex(); i++) {
				sb.append(input[i]);
    			sb.append(" ");
			}
			sb.append("]\n");
   		}

		return sb.toString();
	}

    public static void main(String[] args) {
        final int[] input = args.length == 1 ? getNumericArray(args[0]) :
		 	new int[]{10, 5, 2, 6};
		Exercise10 instance = new Exercise10(); 
    	final int totalSubArrays = instance.find(input, 100, 0, input.length);    	
    	System.out.println("totalSubArrays=" + totalSubArrays);
    	System.out.println(instance.printValidSubArrays(input));
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