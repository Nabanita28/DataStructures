package dataStructuresPractice.bfsTraversal;

import dataStructuresPractice.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPathsForTargetSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(2);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(5);
        root.right.left.right.right = new TreeNode(6);
        System.out.println("Paths = " + pathSum(root, 5));
    }

   /* static int pathSum(TreeNode root, int targetSum){
        List<Integer> path = new ArrayList<>();

        System.out.println(pathSum(root, targetSum, path));

    }
    static void pathSumRecur(TreeNode root, int targetSum, List<Integer> path){

        if(root == null){
            return;
        }

        path.add(root.key);

        pathSumRecur(root.left, targetSum, path);
        pathSumRecur(root.right, targetSum, path);

        int sum = 0;
        for(int i=path.size()-1; i>=0; i--){
            sum = sum + path.get(i);
            if(sum == targetSum){
                count++;
            }
        }

        path.remove(path.size()-1);

    }*/

    public static int pathSum(TreeNode root, int targetSum) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        return pathSumRecur(root, targetSum, 0, freqMap);

    }

    static int pathSumRecur(TreeNode root, int targetSum, int currSum, Map<Integer, Integer> freqMap){
        if(root == null){
            return 0;
        }

        currSum = currSum + root.key;
        int numOfPath = freqMap.getOrDefault(currSum - targetSum, 0);

        freqMap.put(currSum, freqMap.getOrDefault(currSum, 0) + 1);
        numOfPath = numOfPath + pathSumRecur(root.left, targetSum, currSum, freqMap)
                +  pathSumRecur(root.right, targetSum, currSum, freqMap);

        freqMap.put(currSum, freqMap.get(currSum)-1);
        return numOfPath;
    }
}
