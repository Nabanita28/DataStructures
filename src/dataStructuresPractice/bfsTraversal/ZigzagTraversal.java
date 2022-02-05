package dataStructuresPractice.bfsTraversal;

import dataStructuresPractice.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = zigzagLevelOrder(root);
        result.forEach(item -> item.forEach(i -> System.out.print(i + " ")));

    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
        if(root == null){
        return result;
    }

        if(root.left == null && root.right == null){
        List<Integer> rootOutput = new ArrayList<>();
            rootOutput.stream().mapToInt(i->i).max().getAsInt();
            rootOutput.stream().mapToInt(i->i).sum();
        rootOutput.add(root.key);
        result.add(rootOutput);
        return result;
    }

    Queue<TreeNode> leftToRight = new LinkedList<>();
    Queue<TreeNode> rightToLeft = new LinkedList<>();

        leftToRight.add(root);

        while(!leftToRight.isEmpty() || !rightToLeft.isEmpty()){


        while(!leftToRight.isEmpty()){
            List<Integer> leftToRightOutput = new ArrayList<>();
            int leftSize = leftToRight.size();
            for(int i=0; i<leftSize; i++){
                TreeNode curr = leftToRight.remove();
                leftToRightOutput.add(curr.key);

                if(curr.right != null){
                    rightToLeft.add(curr.right);
                }

                if(curr.left != null){
                    rightToLeft.add(curr.left);
                }
            }
            double avg = leftToRightOutput.stream().mapToDouble(num -> num).average().orElse(0.0);


            result.add(leftToRightOutput);
        }


        while(!rightToLeft.isEmpty()){
            List<Integer> rightToLeftOutput = new ArrayList<>();
            int rightSize = rightToLeft.size();
            for(int i=0; i<rightSize; i++){
                TreeNode curr = rightToLeft.remove();
                rightToLeftOutput.add(curr.key);

                if(curr.left != null){
                    leftToRight.add(curr.left);
                }

                if(curr.right != null){
                    leftToRight.add(curr.right);
                }
            }
            result.add(rightToLeftOutput);
        }

    }
        return result;
}
}
