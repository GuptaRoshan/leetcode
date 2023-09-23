package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {

    public static void DFS_Stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode x = stack.pop();
            if(x.right!=null) stack.add(x.right);
            if(x.left!=null) stack.add(x.left);
            System.out.print(" " + x.val);
        }

    }

    public static void BFS_Queue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            if(x.right!=null) queue.add(x.right);
            if(x.left!=null) queue.add(x.left);
            System.out.print(" " + x.val);
        }
    }


    public static void main(String[] args) {

        TreeNode treeNodeLevel1Root = new TreeNode(3);
        treeNodeLevel1Root.left = new TreeNode(9);
        treeNodeLevel1Root.right = new TreeNode(20);

        TreeNode treeNodeLevel2Right = treeNodeLevel1Root.right;
        treeNodeLevel2Right.left = new TreeNode(15);
        treeNodeLevel2Right.right = new TreeNode(7);
        DFS_Stack(treeNodeLevel1Root);
        BFS_Queue(treeNodeLevel1Root);

        /*********************************
                   3
                 /   \
                9    20
                   /   \
                  15    7
        **********************************/


    }

}
