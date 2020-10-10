package tree.mock.interviews;

import java.util.*;

public class DiagonalSumOfTree {
    static class TreeNode{
        int data;
        int verticalDistance;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            verticalDistance = 0;
            left = right = null;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(11);
        root.left.left.right = new TreeNode(10);

        findDiagonalSum(root);
    }

    private static void findDiagonalSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        //The TreeMap provides guaranteed log(n) time cost for the containsKey, get, put and remove operations.
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(root);

        while(!queue.isEmpty()){
               TreeNode current = queue.remove();
               int currentVD = current.verticalDistance;

               while (current != null){
                   int prevSum = map.get(currentVD) == null ? 0 : map.get(currentVD);
                   map.put(currentVD, prevSum + current.data);

                   if (current.left != null){
                       current.left.verticalDistance = currentVD + 1;
                       queue.add(current.left);
                   }
                   current = current.right;
               }
        }
        System.out.println("Sum of vertical distance in a tree is ");
        for(Map.Entry entry : map.entrySet()){
            System.out.print(entry.getValue() + " ");
        }
    }
}
