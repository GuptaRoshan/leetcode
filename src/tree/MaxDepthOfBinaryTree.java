package tree;

public class MaxDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (left == 0 && right == 0) {
            return 1;
        } else {
            return Math.max(left, right) + 1;
        }

    }

    public static void main(String[] args) {
        TreeNode treeNodeLevel1Root = new TreeNode(3);
        treeNodeLevel1Root.left = new TreeNode(9);
        treeNodeLevel1Root.right = new TreeNode(20);

        TreeNode treeNodeLevel2Right = treeNodeLevel1Root.right;
        treeNodeLevel2Right.left = new TreeNode(15);
        treeNodeLevel2Right.right = new TreeNode(7);

        System.out.println(maxDepth(treeNodeLevel1Root));

    }

}
