package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSameTreeBFS(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode temp_p = queue.poll();
            TreeNode temp_q = queue.poll();

            if (temp_p == null && temp_q == null) {
                continue;
            }

            if (temp_p == null || temp_q == null) {
                return false;
            }

            if (temp_p.val == temp_q.val) {
                queue.add(temp_p.left);
                queue.add(temp_q.left);
                queue.add(temp_p.right);
                queue.add(temp_q.right);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(9);
        tree1.right = new TreeNode(20);

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(20);

        System.out.println(isSameTree(tree1, tree2));
        System.out.println(isSameTreeBFS(tree1, tree2));
    }


}
