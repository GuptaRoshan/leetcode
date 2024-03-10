package tree;

public class MinDepthOfBinaryTree {

    public static int minDepth0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth0(root.left);
        int right = minDepth0(root.right);
        // this is the case when there is no either left child or right child, so just return the depth of right or left tree.
        if (left == 0 || right == 0) {
            return left + right + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        // this is the case when there is no either left child or right child, so just return the depth of right or left tree.
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        } else {
            return Math.min(left, right) + 1;
        }

    }

    public static int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth2(root.right) + 1;
        if (root.right == null) return minDepth2(root.left) + 1;
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNodeLevel1Root = new TreeNode(3);
        treeNodeLevel1Root.left = new TreeNode(9);
        treeNodeLevel1Root.right = new TreeNode(20);

        TreeNode treeNodeLevel2Right = treeNodeLevel1Root.right;
        treeNodeLevel2Right.left = new TreeNode(15);
        treeNodeLevel2Right.right = new TreeNode(7);

        System.out.println(minDepth0(treeNodeLevel1Root));
        System.out.println(minDepth1(treeNodeLevel1Root));

    }


}
