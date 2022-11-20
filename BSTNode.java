
public class BSTNode {
	private Dollar data;
	private BSTNode right;
	private BSTNode left;
	
	public Dollar getData() {
		return data;
	}

	public void setData(Dollar data) {
		this.data = data;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

    // Constructor
	public BSTNode(Dollar d)
    {
        data = d;
        right = null;
        left = null;
    }

	public BSTNode() {
		// TODO Auto-generated constructor stub
	}
}

