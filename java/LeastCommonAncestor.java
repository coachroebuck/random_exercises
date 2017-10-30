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

    public static void main(String[] args) {
        final int[] input = args.length == 1 ? getNumericArray(args[0]) :
		 	new int[]{1, 0, 2, 0, 0, 3, 4};
		LeastCommonAncestor instance = new LeastCommonAncestor(); 
		List<Node> nodes = new ArrayList<Node>();
		Node currentNode = null;
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