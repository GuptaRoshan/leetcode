package tree;

import java.util.*;

public class ReverseLevelOrder {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                temp.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            stack.push(temp);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode treeNodeLevel1Root = new TreeNode(3);
        treeNodeLevel1Root.left = new TreeNode(9);
        treeNodeLevel1Root.right = new TreeNode(20);
        TreeNode treeNodeLevel2Right = treeNodeLevel1Root.right;
        treeNodeLevel2Right.left = new TreeNode(15);
        treeNodeLevel2Right.right = new TreeNode(7);
        levelOrderBottom(treeNodeLevel1Root);
    }

}
