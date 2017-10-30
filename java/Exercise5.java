import java.util.*;
import java.util.Scanner;

public class Exercise5 {

	public class MyElement<T> {
		private MyElement previous;
		private T value;
		private MyElement next;

		public MyElement(final T value, 
			final MyElement<T> previous,
		 	final MyElement<T> next) {
			setPrevious(previous);
			setValue(value);
			setNext(next);
		}

		public void setValue(final T value) {
			this.value = value;
		}

		public void setPrevious(final MyElement<T> previous) {
			this.previous = previous;
		}

		public void setNext(final MyElement<T> next) {
			this.next = next;
		}

		public T getValue() {
			return this.value;
		}

		public MyElement<T> getPrevious() {
			return this.previous;
		}

		public MyElement<T> getNext() {
			return this.next;
		}
	}

	public class MyDataStructure<T> {
		
		private MyElement<T> list;

		public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean contains(Object o) {
            return false;
        }

		public Iterator<Integer> iterator() {
            return null;
        }

        public boolean add(T value) {
            return false;
        }

        public boolean remove(Object o) {
            return false;
        }

        public void clear() {

        }

		private int hash(int value) {
			final String s = String.format("%d", value);
		    int len = 30;
		    int sum = 0;
		    for(int i = 0; i < s.length(); i++) {
		        sum += ((int)s.charAt(i)) * (1<<i);
		    }
		    return sum%len;
		}
	}

    public static void main(String[] args) {
		
		// create a scanner so we can read the command-line input
		Scanner scanner = new Scanner(System.in);
		String optionReceived = "";

		do {
			System.out.print("Options to manipulate your set:\na - add\nc - containsKey\nd - delete\nl - list\nt - total\nq - quit\n\n");

			optionReceived = scanner.next().trim().toLowerCase();

			switch(optionReceived) {
				case "a":
				System.out.println("Adding...");
				break;
				case "c":
				System.out.println("ContainsKey...");
				break;
				case "d":
				System.out.println("Deleting...");
				break;
				case "l":
				System.out.println("List...");
				break;
				case "q":
				System.out.println("Quitting...");
				break;
				case "t":
				System.out.println("Total...");
				break;
				default:
				System.out.println("Unrecognized input.");
				break;
			}

			if(optionReceived.equals("q")) {
				break;
			}
		}
		while(!optionReceived.equals("q"));
	}
}