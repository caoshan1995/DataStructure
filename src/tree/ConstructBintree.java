package tree;

public class ConstructBintree {
/**
 * 该类用于实现重建二叉树；输入二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * @param preorder 前序遍历序列
 * @param inorder	中序遍历序列
 * @param length	长度
 * @return	重建的二叉树根结点
 */
	public static BinNode Construct(int preorder[], int inorder[], int length) {
		if (preorder.length == 0 || inorder.length == 0 || length <= 0) {
			return null;
		}
		return ConstructCore(preorder, 0, length - 1, inorder, 0, length - 1);
	}

	public static BinNode ConstructCore(int preorder[], int startPreorder, int endPreorder, int inorder[],
			int startInorder, int endInorder) {
		int rootValue = preorder[startPreorder];
		BinNode root = new BinNode(rootValue);
		root.lchild = null;
		root.rchild = null;

		if (startPreorder == endPreorder) {
			if (startInorder == endInorder) {
				return root;
			} else
				System.out.println("Invalid input");
		}

		// 在中序遍历中找到根结点的值
		int rootInorder = startInorder;
		while (rootInorder <= endInorder && inorder[rootInorder] != rootValue)
			++rootInorder;

		if (rootInorder == endInorder && inorder[rootInorder] != rootValue) {
			System.out.println("Invalid input");
		}
		int leftLength = rootInorder - startInorder;
		int leftPreorderEnd = startPreorder + leftLength;
		if (leftLength > 0) {
			// 构建左子树
			root.lchild = ConstructCore(preorder, startPreorder + 1, leftPreorderEnd, inorder, startInorder,
					rootInorder - 1);
		}
		if (leftLength < endPreorder - startPreorder) {
			// 构建右子树
			root.rchild = ConstructCore(preorder, leftPreorderEnd + 1, endPreorder, inorder, rootInorder + 1,
					endInorder);
		}

		return root;
	}

	public static void Test1() {
		int length = 8;
		int preorder[] = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int inorder[] = { 4, 7, 2, 1, 5, 3, 8, 6 };

		System.out.println(Construct(preorder, inorder, length));
	}

	public static void Test2() {
		int length = 5;
		int preorder[] = { 1, 2, 3, 4, 5 };
		int inorder[] = { 5, 4, 3, 2, 1 };

		System.out.println(Construct(preorder, inorder, length));
	}

	public static void main(String[] args) {
		Test2();
		Test1();
	}

}
