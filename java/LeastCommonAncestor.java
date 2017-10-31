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
  
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.value > n1 && node.value > n2)
            return lca(node.left, n1, n2);
  
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.value < n1 && node.value < n2) 
            return lca(node.right, n1, n2);
  
        return node.value;
    }

    public static void main(String[] args) {
        final int[] input = /*args.length >= 1 ? getNumericArray(args[0]) :*/
		 	new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
		LeastCommonAncestor instance = new LeastCommonAncestor(); 
		List<Node> nodes = new ArrayList<Node>();
		Node currentNode = null;
		final int n1 = args.length >= 1 ? Integer.parseInt(args[0]) : 8;
		final int n2 = args.length >= 2 ? Integer.parseInt(args[1]) : 16;
    	// instance.add(input);
    	// System.out.println(instance.lca(input));

    	for(int i = 0; i < input.length; i++) {
    		if(currentNode == null) {
    			instance.root = new LeastCommonAncestor.Node(input[i]);
    			currentNode = instance.root;
    		}
    		else if(currentNode.left == null) {
    			currentNode.left = new LeastCommonAncestor.Node(input[i]);
    			nodes.add(currentNode.left);
    		}
    		else if(currentNode.right == null) {
    			currentNode.right = new LeastCommonAncestor.Node(input[i]);	
    			nodes.add(currentNode.right);
    		}
    		else {
    			currentNode = nodes.get(0);
    			nodes.remove(0);
    			currentNode.left = new LeastCommonAncestor.Node(input[i]);
    		}
    	}
    	
    	System.out.println(instance.total());
    	System.out.println(instance.isComplete());
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