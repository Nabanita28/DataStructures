package dataStructuresPractice.tree.mock.interviews;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBSTFromLevelOrder {
    public static void main(String[] args) {
        int[] levelOrderTraversal = new int[]{8,5,11,10,12,7};
        System.out.println(levelOrderIsOfBST(levelOrderTraversal, levelOrderTraversal.length));
    }

    static class NodeDetails{
        int data;
        int min;
        int max;
    }

    private static boolean levelOrderIsOfBST(int[] arr, int n) {

        if(n == 0){
            return true;
        }
        int i = 0;
        NodeDetails newNode = new NodeDetails();
        newNode.data = arr[i++];
        newNode.min = Integer.MIN_VALUE;
        newNode.max = Integer.MAX_VALUE;

        Queue<NodeDetails> queue = new LinkedList<>();
        queue.add(newNode);

        while(i != n && queue.size() > 0){
            NodeDetails temp = queue.remove();

            //arr[i] can be a left child
            if(i<n && (arr[i] < temp.data && arr[i] > temp.min)){
                newNode = new NodeDetails();
                newNode.data = arr[i++];
                newNode.min = temp.min;
                newNode.max = temp.max;
                queue.add(newNode);
            }

            //arr[i] can be a right child
            if(i<n && (arr[i] > temp.data && arr[i] < temp.max)){
                newNode = new NodeDetails();
                newNode.data = arr[i++];
                newNode.min = temp.min;
                newNode.max = temp.max;
                queue.add(newNode);
            }
        }
        if(i == n)
            return true;

      return false;
    }
}
