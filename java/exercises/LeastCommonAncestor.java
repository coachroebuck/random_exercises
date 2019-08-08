import java.util.*;

//Binary trees: Least Common Ancestor; NP-Completness check
public class LeastCommonAncestor {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(final int value) {
			this.value = value;
		}
	}
	
	public Node root;

	public int total() {
		return total(root);
	}

	public int total(final Node node) {
		if(node == null) {
			return 0;
		}
		else {
			return (1 + total(node.left) + total(node.right));
		}
	}

	public boolean isComplete() {
		return root != null && isComplete(root);
	}

	public boolean isComplete(Node parent) {
		if(parent == null
				|| (parent.left == null && parent.right == null)) {
			return true;
		}
		else if((parent.left != null && parent.right == null)
				|| (parent.left == null && parent.right != null)) {
			return false;
		}
		else {
			return isComplete(parent.left) && isComplete(parent.right);
		}
	}

	public int lca(Node node, int n1, int n2) 
    {
        if (node == null)
            return -1;
  
  		List<Integer> n1Stack = new ArrayList<Integer>();
  		List<Integer> n2Stack = new ArrayList<Integer>();

  		final boolean didFindN1 = depthFirstSearch(node, n1, n1Stack);
        final boolean didFindN2 = depthFirstSearch(node, n2, n2Stack);

        for(Integer i : n1Stack) {
        	if(n2Stack.contains(i)) {
        		return i;
        	}
        }
        // // If both n1 and n2 are smaller than root, then LCA lies in left
        // if (node.value > n1 && node.value > n2)
        //     return lca(node.left, n1, n2);
  
        // // If both n1 and n2 are greater than root, then LCA lies in right
        // if (node.value < n1 && node.value < n2) 
        //     return lca(node.right, n1, n2);
  
        return -1;
    }

    public boolean depthFirstSearch(final Node node, 
    	final int n,
    	final List<Integer> stack) {
    	boolean result = false;

    	if(node != null) {
	    	if(node.value == n) {
	    		stack.add(node.value);
	    		result = true;
	    	}
	    	else if(depthFirstSearch(node.left, n, stack)) {
	    		stack.add(node.value);
	    		result = true;
	    	}
	    	else if(depthFirstSearch(node.right, n, stack)) {
	    		stack.add(node.value);
	    		result = true;
	    	}
    	}

    	return result;
    }

	public void print(final List list) {
		StringBuilder sb = new StringBuilder();
		for (Object s : list)
		{
			if(s instanceof Node) {
				final Node node = (Node)s;
				sb.append(node.value);
			}
			else {
				sb.append(s.toString());
		    }
		    sb.append("\t");
		}

		log(sb.toString());
	}

	public void log(final String message) {
		System.out.println(message);
	}

    public static void main(String[] args) {
        LeastCommonAncestor instance = new LeastCommonAncestor(); 
		List<Node> nodes = new ArrayList<Node>();
		Node currentNode = null;
		final int total = args.length >= 1 ? Integer.parseInt(args[0]) : 100;
		final int n1 = args.length >= 2 ? Integer.parseInt(args[1]) : 12;
		final int n2 = args.length >= 3 ? Integer.parseInt(args[2]) : 15;
    	
    	for(int i = 1; i <= total; i++) {
    		if(currentNode == null) {
    			instance.root = new LeastCommonAncestor.Node(i);
    			currentNode = instance.root;
    		}
    		else if(currentNode.left == null) {
    			currentNode.left = new LeastCommonAncestor.Node(i);
    			nodes.add(currentNode.left);
    		}
    		else if(currentNode.right == null) {
    			currentNode.right = new LeastCommonAncestor.Node(i);	
    			nodes.add(currentNode.right);
    		}
    		else {
    			currentNode = nodes.get(0);
    			nodes.remove(0);
    			currentNode.left = new LeastCommonAncestor.Node(i);
    			nodes.add(currentNode.left);
    		}
    	}
    	
    	System.out.println("total=" + instance.total());
    	System.out.println("isComplete=" + instance.isComplete());
    	System.out.println(instance.lca(instance.root, n1, n2));
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