package tree;

public class BinaryTree {

	public static void main(String[] args) {
		BinNode bin = new BinNode();
		bin = init();
		int i = TreeDeep(bin);
		System.out.println(i);
	}

	/**
	 * 这个函数是为了初始化一个根节点为0的二叉树
	 */
	public static BinNode init() {
		BinNode bin = new BinNode(5);
		bin.lchild = null;
		bin.rchild = null;
		return bin;
	}

	/**
	 * 这个函数是为了实现记录和更新二叉数节点
	 */
	public static int TreeDeep(BinNode bin) {
		int BinHigh = 0;
		if (bin != null) {
			int leftH = TreeDeep(bin.lchild);
			int rightH = TreeDeep(bin.rchild);
			BinHigh = (leftH > rightH) ? leftH + 1 : rightH + 1;
		}
		return BinHigh;
	}
}
