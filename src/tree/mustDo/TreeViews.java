package tree.mustDo;

import tree.TreeNode;

import java.util.*;

public class TreeViews {

    //          1
    //      2       3
    //  4       5

    static int max_level = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        System.out.println("Left view tree : ");
        printLeftViewTree(root, 1);
        System.out.println();
        System.out.println("Left view tree iterative way: ");
        printLeftViewIterative(root);

        //resetting max level for right view
        max_level = 0;

        System.out.println();
        System.out.println("Right view tree : ");
        printRightViewTree(root, 1);

        //resetting max level for right view
        max_level = 0;

        System.out.println();
        System.out.println("Bottom View Tree : ");
        printBottomViewTree(root, 0);

    }

    private static void printLeftViewTree(TreeNode root, int level) {
        TreeNode node = root;
        if (node == null)
            return;

        if(max_level < level) {
            System.out.print(node.key + " ");
            max_level = level;
        }
        printLeftViewTree(node.left, level+1);
        printLeftViewTree(node.right, level+1);

    }


    private static void printLeftViewIterative(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        root.vd = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            int vd = current.vd;

            if (!map.containsKey(vd)) {
                map.put(vd, current.key);
            }
            if (current.left != null) {
                current.left.vd = vd + 1;
                queue.add(current.left);
            }
            if (current.right != null) {
                current.right.vd = vd + 1;
                queue.add(current.right);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

    }

    private static void printRightViewTree(TreeNode root, int level) {
        TreeNode node = root;
        if (node == null)
            return;

        if (max_level < level){
            System.out.print(node.key + " ");
            max_level = level;
        }

        printRightViewTree(node.right, level+1);
        printRightViewTree(node.left, level+1);

    }

    private static void printBottomViewTree(TreeNode root, int level) {


        Map<Integer, Integer> map = new TreeMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        root.hd = level;
        queue.add(root);

        while(!queue.isEmpty()){

            TreeNode current = queue.remove();
            int hd = current.hd;

            map.put(hd, current.key);

            if (current.left != null){
                current.left.hd = hd - 1;
                queue.add(current.left);
            }

            if (current.right != null){
                current.right.hd = hd + 1;
                queue.add(current.right);
            }
        }

        for(Map.Entry entry : map.entrySet()){

            System.out.print(entry.getValue() + " ");


        }

    }
}
