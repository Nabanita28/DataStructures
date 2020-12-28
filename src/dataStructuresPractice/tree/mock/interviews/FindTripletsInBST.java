package dataStructuresPractice.tree.mock.interviews;

import dataStructuresPractice.tree.TreeNode;

import java.util.ArrayList;

public class FindTripletsInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(19);
        root.left = new TreeNode(7);
        root.right = new TreeNode(21);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(11);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        findTripletsInBST(root, 21);
    }

    private static void findTripletsInBST(TreeNode root, int sum) {
        ArrayList<Integer> list = new ArrayList<>();

        inOrder(root, list);

        for (int i=0; i<list.size(); i++){
            int l = i+1;
            int r = list.size()-1;

            while(l<r){

                if (list.get(i) + list.get(l) + list.get(r) == sum) {
                    System.out.println(list.get(i) + ", " + list.get(l) + ", " + list.get(r));
                    break;
                }
                if (list.get(i) + list.get(l) + list.get(r) < sum)
                    l++;
                else
                    r--;
            }
        }
    }

    private static void inOrder(TreeNode node, ArrayList<Integer> list){
        if (node == null)
            return;

        inOrder(node.left, list);
        list.add(node.key);
        inOrder(node.right, list);

    }
}
