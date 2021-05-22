package dataStructuresPractice.tree;

import java.util.HashMap;
import java.util.Map;

import static dataStructuresPractice.tree.mustDo.CreateMirror.inOrder;

public class ConstructBinaryTree {
    public static void main(String[] args) {
      TreeNode root =  buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        inOrder(root);
    }

    static Map<Integer, Integer> inOrderMap = new HashMap<>();
    static int preOrderIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return recur(preorder, inorder, 0, inorder.length-1);

    }

   static TreeNode recur(int[] preorder, int[] inorder, int left, int right){

        if(left > right){
            return null;
        }

        int nodeData = preorder[preOrderIndex++];
        TreeNode node = new TreeNode(nodeData);

        int nodeData_inorderIndex = inOrderMap.get(nodeData);

        node.left = recur(preorder, inorder, left, nodeData_inorderIndex-1);
        node.right = recur(preorder, inorder, nodeData_inorderIndex+1, right);

        return node;
    }
}
