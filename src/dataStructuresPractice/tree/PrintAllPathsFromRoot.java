package dataStructuresPractice.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathsFromRoot {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        List<String> paths = binaryTreePaths(root);
        paths.stream().forEach(path -> System.out.println(path));

        System.out.println(checkIfSumIsPresent(root, 3));
    }

    static  public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        generatePaths(root, paths, "");
        return paths;
    }

  static void generatePaths(TreeNode root, List<String> paths, String path){

        if(root == null){
            return;
        }

        path = path + "->" + root.key;

        if(root.left == null && root.right == null){
            paths.add(path.substring(2));
        }else{
            generatePaths(root.left, paths, path);
            generatePaths(root.right, paths, path);
        }

    }

    static private boolean checkIfSumIsPresent(TreeNode root, int sum) {

        if (sum == 0) {
            return true;
        } else {

            int remainingSum = sum - root.key;

            if ((root.left != null && root.right != null) || (root.left == null && root.right == null)) {
                return checkIfSumIsPresent(root.left, remainingSum) || checkIfSumIsPresent(root.right, remainingSum);
            }
            else if(root.left != null){
                return checkIfSumIsPresent(root.left, remainingSum);
            }else{
                return checkIfSumIsPresent(root.right, remainingSum);
            }
        }
    }
}
