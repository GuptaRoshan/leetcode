package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsOfBinaryTree {



    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> average = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            average.add((sum / n));
        }

        return average;
    }



    public static List<String> paths(TreeNode root, String path, List<String> list) {

        if (root.left == null && root.right == null) {
            list.add(path + root.val);
        }

        if (root.left != null) paths(root.left, path + root.val + "->" , list);
        if (root.right != null) paths(root.right,path +  root.val + "->", list);

        return list;
    }


    public static void main(String[] args) {
        TreeNode treeNodeLevel1Root = new TreeNode(3);
        treeNodeLevel1Root.left = new TreeNode(9);
        treeNodeLevel1Root.right = new TreeNode(20);

        TreeNode treeNodeLevel2Right = treeNodeLevel1Root.right;
        treeNodeLevel2Right.left = new TreeNode(15);
        treeNodeLevel2Right.right = new TreeNode(7);

        //averageOfLevels(treeNodeLevel1Root);
        List<String> list = new ArrayList<>();
        paths(treeNodeLevel1Root, "", list);
        averageOfLevels(treeNodeLevel1Root);


        /*********************************
         3
         /   \
         9    20
         /  \
         15   7
         **********************************/


    }
}
