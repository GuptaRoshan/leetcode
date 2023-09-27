package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTree {


    public static TreeNode mergeTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();

        pq.add(p);
        qq.add(q);

        while (!pq.isEmpty() && !qq.isEmpty()) {
            TreeNode pCurr = pq.poll();
            TreeNode qCurr = qq.poll();

            pCurr.val = pCurr.val + qCurr.val;

            if (pCurr.left == null && qCurr.left != null) {
                pCurr.left = qCurr.left;
            } else if (pCurr.left != null && qCurr.left != null) {
                pq.add(pCurr.left);
                qq.add(qCurr.left);
            }

            if (pCurr.right == null && qCurr.left != null) {
                pCurr.right = qCurr.right;
            } else if (pCurr.right != null && qCurr.right != null) {
                pq.add(pCurr.right);
                qq.add(qCurr.right);
            }
        }

        return p;

    }


    public static TreeNode mergeTreeDFS(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;

        root1.val = root1.val + root2.val;
        root1.left = mergeTreeDFS(root1.left, root2.left);
        root1.right = mergeTreeDFS(root1.right, root2.right);

        return root1;
    }


    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(9);
        tree1.right = new TreeNode(20);

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(20);

        tree2.left.left = new TreeNode(7);
        tree2.right.right = new TreeNode(8);

        System.out.println(mergeTree(tree1, tree2));
        System.out.println(mergeTreeDFS(tree1, tree2));

    }

}
