package javaPratice;

import java.util.ArrayList;
import java.util.List;

public class TreeProblem {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        traverse(root, output, result);
        for(List<Integer> op : result){
            op.stream().forEach(item -> System.out.print(item + " "));
            System.out.println();
        }
    }

    private static void traverse(TreeNode root, List<Integer> output , List<List<Integer>> result) {

       if(root == null){
           return ;
       }

       output.add(root.key);

       if(root.left == null && root.right == null){
           result.add(new ArrayList<>(output));
       }

       traverse(root.left, output, result);
       traverse(root.right, output, result);
       output.remove(output.size()-1);
    }

    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int key;
        public TreeNode(int key){
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }
}


