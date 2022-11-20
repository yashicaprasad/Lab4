import java.io.FileWriter;
import java.io.IOException;

public class BST {

	private static BSTNode root;

	public BSTNode getRoot() {
		return root;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}

	/**
	 * BST constructors
	 */
	BST() {
		this.root = null;
	}

	BST(double value) {
		this.root = new BSTNode(new Dollar(value));
	}

	/**
	 * breadth-first traversal
	 * 
	 * @purpose process tree using breadth-first traversal
	 * @pre root is node to be processed
	 * @post tree is processed
	 * @return N/A
	 * @pseudocode BSTNode currentNode = root queueObj = new Queue() while
	 *             (currentNode != null) queueObj.enQueue(currentNode.getData());
	 *             if(currentNode.getLeft() != null)
	 *             queueObj.enQueue(currentNode.getLeft().getData());
	 *             if(currentNode.getRight() != null)
	 *             queueObj.enQueue((currentNode.getRight().getData())); while
	 *             (!queueObj.isListEmpty()) Currency tempNode = queueObj.dequeue();
	 *             currentNode = null;
	 */

	void breadthFirst(FileWriter f) throws IOException{
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printCurrentLevel(root, i, f);
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
	 */
	int height(BSTNode root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.getLeft());
			int rheight = height(root.getRight());

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the current level */
	public void printCurrentLevel(BSTNode root, int level, FileWriter f) throws IOException{
		String currentLevel;
		if (root == null)
			return ;
		if (level == 1) {
			currentLevel = root.getData().print() + " ";
			f.write(currentLevel);
		}			
		else if (level > 1) {
			printCurrentLevel(root.getLeft(), level - 1, f);
			printCurrentLevel(root.getRight(), level - 1, f);
		}
	}

	/**
	 * pre order traversal
	 * 
	 * @purpose process tree in node-left-right sequence
	 * @pre root is the entry node of a tree/subtree
	 * @post each node is processed in order
	 * @return N/A
	 * @pseudocode while(root != null) root.getData().print();
	 *             preOrder(root.getLeft()); preOrder(root.getRight());
	 */
	public void preOrder(FileWriter f) throws IOException {
		preOrder(root, f);
	}

	private void preOrder(BSTNode node, FileWriter f) throws IOException {
		if (node == null)
			return;
		f.write(node.getData().print() + " ");		
		preOrder(node.getLeft(), f);
		preOrder(node.getRight(), f);
	}

	/**
	 * in order traversal
	 * 
	 * @purpose traverse a binary tree in left-node-right sequence
	 * @pre root is entry node of a tree/subtree
	 * @post each node is prcoessed in order
	 * @return N/A
	 * @throws IOException 
	 * @pseudocode if(root != null) inOrder(root.getLeft()); root.getData().print();
	 *             inOrder(root.getRight());
	 */
	public void inOrder(FileWriter f) throws IOException {
		 inOrder(root, f);
	}

	private void inOrder(BSTNode node, FileWriter f) throws IOException {
		if (node == null)
			return ;

		inOrder(node.getLeft(),f) ;
		f.write(node.getData().print() + " ");
		inOrder(node.getRight(),f);
	}

	/**
	 * post order traversal
	 * 
	 * @purpose traverse a binary tree in left-right-node sequence
	 * @pre root is entry node of a tree/subtree
	 * @post each node is processed in order
	 * @return N/A
	 * @pseudocode if(root != null) postOrder(root.getLeft());
	 *             postOrder(root.getRight()); root.getData().print();
	 */
	public void postOrder(FileWriter f) throws IOException {
		postOrder(root, f);
	}

	private void postOrder(BSTNode node, FileWriter f) throws IOException {
		if (node == null)
			return;

		postOrder(node.getLeft(), f);
		postOrder(node.getRight(), f);
		f.write(node.getData().print() + " ");
	}
	/**
	 * search for a Dollar object
	 * 
	 * @purpose recursively search for a Dollar object in a binary tree
	 * @pre root is entry node of a tree/subtree and key is the Dollar object being
	 *      searched for
	 * @post search is called until root == null or root.getData() == key
	 * @return true/false
	 * @pseudocode if (root == null || root.getData() == key) return root; if
	 *             (root.getData().isGreater(key)) return search(root.getRight(),
	 *             key); if (!root.getData().isGreater(key)) return
	 *             search(root.getLeft(), key);
	 */
	public static boolean search(Double value) {
		return search(root, new Dollar(value));
	}

	public static boolean search(BSTNode root, Dollar value) {

		if (root == null)
			return false;

		if (root.getData().isEqual(value))
			return true;

		if (root.getData().isGreater(value))
			return search(root.getLeft(), value);

		else if (!root.getData().isGreater(value))
			return search(root.getRight(), value);

		return false;
	}
	
	public static BSTNode searchNode(BSTNode root, Dollar value) {

		if (root == null)
			return null;

		if (root.getData().isEqual(value))
			return root;

		if (root.getData().isGreater(value))
			return searchNode(root.getLeft(), value);

		else if (!root.getData().isGreater(value))
			return searchNode(root.getRight(), value);

		return root;
	}

	/**
	 * countNode
	 * 
	 * @purpose count the number of nodes in the BST
	 * @pre
	 * @post number of nodes is counted
	 * @return number of nodes in the BST pseudocode if root == null return 0 else
	 *         return 1 + countNode(root.getRight()) + countNode(rootgetLeft())
	 */
	public int countNode(BSTNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + countNode(root.getRight()) + countNode(root.getLeft());
		}
	}

	/**
	 * insert a Dollar object
	 * 
	 * @purpose recursively go through the BST to insert the Dollar obj in the
	 *          correct location
	 * @pre root is entry node of a tree/subtree and key is the Dollar object to be
	 *      inserted
	 * @post search is called until root == null or root.getData() == key
	 * @return root
	 * @pseudocode If the tree is empty, return a new node Otherwise, recur down the
	 *             tree
	 */
	public BSTNode insert(BSTNode root, Dollar key) {

		if (root == null) {
			root = new BSTNode(key);
			return root;
		}

		else if (root.getData().isGreater(key)) {
			root.setLeft(insert(root.getLeft(), key));
		} else if (!root.getData().isGreater(key)) {
			root.setRight(insert(root.getRight(), key));
		}

		return root;
	}

	/**
	 * delete a Dollar object
	 * 
	 * @purpose delete a Dollar object
	 * @pre root is entry node of a tree/subtree and key is the Dollar object to be
	 * @post
	 * @return root
	 * @pseudocode Base Case: If the tree is empty
	 * 			   Otherwise, recur down the tree
	 * 					if key is same as root's key, then this is the node to be deleted
	 */
	void delete(double key) {
		delete(root, new Dollar(key));
	}

	public BSTNode delete(BSTNode root, Dollar key) {
		BSTNode parent = null;
	      
	        // start with the root node
		BSTNode curr = root;
	 
	        // search key in the BST and set its parent pointer
	        while (curr != null && !curr.getData().isEqual(key))
	        {
	            // update the parent to the current node
	            parent = curr;
	 
	            // if the given key is less than the current node, go to the left subtree;
	            // otherwise, go to the right subtree
	            if (key.isLess(curr.getData()) ) {
	                curr =curr.getLeft();
	            }
	            else {
	                curr = curr.getRight();
	            }
	        }
	 
	        // return if the key is not found in the tree
	        if (curr == null) {
	            return root;
	        }
	 
	        // Case 1: node to be deleted has no children, i.e., it is a leaf node
	        if (curr.getLeft() == null && curr.getRight() == null)
	        {
	            // if the node to be deleted is not a root node, then set its
	            // parent left/right child to null
	            if (curr != root)
	            {
	                if (parent.getLeft().getData().isEqual(curr.getData())) {
	                    parent.setLeft(null);
	                }
	                else {
	                    parent.setRight(null);
	                }
	            }
	            // if the tree has only a root node, set it to null
	            else {
	                root = null;
	            }
	        }
	 
	        // Case 2: node to be deleted has two children
	        else if (curr.getLeft() != null && curr.getRight() != null)
	        {
	            // find its inorder successor node
	            BSTNode successor = minValue(curr.getRight());
	 
	            // store successor value
	            Dollar val = successor.getData();
	 
	            // recursively delete the successor. Note that the successor
	            // will have at most one child (right child)
	            delete(root, successor.getData());
	 
	            // copy value of the successor to the current node
	            curr.setData(val);
	        }
	 
	        // Case 3: node to be deleted has only one child
	        else {
	            // choose a child node
	        	BSTNode child = (curr.getLeft() != null)? curr.getLeft(): curr.getRight();
	 
	            // if the node to be deleted is not a root node, set its parent
	            // to its child
	            if (curr != root)
	            {
	                if (curr == parent.getLeft()) {
	                    parent.setLeft(child);
	                }
	                else {
	                    parent.setRight(child);
	                }
	            }
	 
	            // if the node to be deleted is a root node, then set the root to the child
	            else {
	                root = child;
	            }
	        }
	 
	        return root;
//		if (root == null)
//			return root;

//		if (root.getData().isLess(key)) {
//			//System.out.println("found the Node Less: " + root.getData().print());
//			root.setLeft(delete(root.getRight(), key));
//
//		}
//		else if (root.getData().isGreater(key)) {
//			//System.out.println("found the Node More: " + root.getData().print());
//
//			root.setRight(delete(root.getLeft(), key));
//
//		}
		
//		else {
//			
//			//System.out.println("found the Node to be deleted: " + root.getData().print());
//			if (root.getLeft() == null)
//				return root.getRight();
//			else if (root.getRight() == null)
//				return root.getLeft();
//			
//			//System.out.println(minValue(root.getRight()) + " data " );
//			root=root.getLeft();
//
//		}
//		return root;
	}

	BSTNode minValue(BSTNode root) {
        while (root.getLeft() != null) {
        	root = root.getLeft();
        }
        return root;
	}

	/**
	 * printTree
	 * 
	 * @purpose print the contents of the BST
	 * @pre takes BST node as input
	 * @post contents of BST is printed
	 * @return N/A
	 * 
	 *         pseudocode
	 * 
	 *         if(root != null) print(root.getData()) printTree(root.getLeft())
	 *         printTree(root.getRight())
	 */
	public void printTree(BSTNode root, FileWriter f) {
		try {
			f.write("breadthFirst: \n");
			this.breadthFirst(f);
			f.write("inOrder: \n");
			this.inOrder(root, f);
			f.write("preOrder: \n");
			this.preOrder(root, f);
			f.write("postOrder: \n");
			this.postOrder(root, f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * check if the BST is empty
	 * 
	 * @purpose check if the BST is empty
	 * @pre
	 * @post search is called until root == null or root.getData() == key
	 * @return true/false
	 * @pseudocode If this.root == null return true Else return false;
	 */

	Boolean isEmpty() {
		if (this.root == null)
			return true;
		return false;
	}

	/**
	 * empty a BST
	 * 
	 * @purpose empty BST
	 * @pre
	 * @post
	 * @return root
	 * @pseudocode set root to null
	 */
	BSTNode empty() {
		this.root = null;
		return root;
	}
}
