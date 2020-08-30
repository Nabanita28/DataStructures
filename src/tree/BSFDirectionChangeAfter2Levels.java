package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSFDirectionChangeAfter2Levels {

    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("BFS traversal");
        bfsLevelChangeAfterTwoLevels(root);
    }

    private static void bfsLevelChangeAfterTwoLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        queue.add(root);
        int size;
        int count = 0;
        boolean rightToLeft = false;

        while(!queue.isEmpty()){
            count++;
            size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode temp = queue.remove();

                if(rightToLeft == false)
                    System.out.print(temp.key + " ");
                else
                    stack.push(temp);

                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);

            }

            if(rightToLeft == true){
                while(!stack.isEmpty()){
                    TreeNode tempStack = stack.pop();
                    System.out.print(tempStack.key + " ");
                }
            }

            if(count == 2){
                rightToLeft = !rightToLeft;
                count =0;
            }

            System.out.println();
        }


    }


}
