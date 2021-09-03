package dataStructuresPractice.tree;

public class ConstructSpecialTreeFromPreOrder {
    public static void main(String[] args) {
        int preOrderVal[] = new int[]{10, 30, 20, 5, 15};
        char preOrderArray[] = new char[]{'N', 'N', 'L', 'L', 'L'};
       TreeNode node =  constructBinaryTree(preOrderVal, preOrderArray, preOrderArray.length);
       BasicTreeFunctions.inorder(node);
    }

    static class Index{
        int index = 0;
    }
    static TreeNode root;
    static TreeNode constructBinaryTree(int preOrderVal[], char preOrderArray[], int len){
        Index startIndex = new Index();
        startIndex.index = 0;
        return constructBinaryTreeUtil(preOrderVal, preOrderArray, len, startIndex, root);
    }

    private static TreeNode constructBinaryTreeUtil(int[] preOrderVal, char[] preOrderArray, int len, Index indexPointer, TreeNode node) {

        int index = indexPointer.index;

        if(index == len){
            return null;
        }
        node = new TreeNode(preOrderVal[index]);
        indexPointer.index++;

        if(preOrderArray[index] == 'N'){
            node.left = constructBinaryTreeUtil(preOrderVal, preOrderArray, len, indexPointer, node.left);
            node.right = constructBinaryTreeUtil(preOrderVal, preOrderArray, len, indexPointer, node.right);
        }

        return node;

    }
}
