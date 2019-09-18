package tree;

public class BinNode {
	int data;
	BinNode lchild;
	BinNode rchild;

	BinNode(int data) {
		this.data = data;
	}

	BinNode() {
		this.data = 0;
	}
	
	/**
	 * 这个函数是为了实现二叉数添加节点
	 */
	public static void add(int data) {
		

	}

	@Override
	public String toString() {
		return "BinNode [data=" + data + ", lchild=" + lchild + ", rchild=" + rchild + "]";
	}
	
}
