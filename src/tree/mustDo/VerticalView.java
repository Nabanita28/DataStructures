package tree.mustDo;

import tree.TreeNode;

import java.util.*;

public class VerticalView {
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

        System.out.println("Vertical view tree : ");

        printVerticalView(root);
    }

    private static void printVerticalView(TreeNode root) {

        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        root.hd = 0;
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.remove();
            int hd = current.hd;
            ArrayList<Integer> nodes = map.get(hd);

            if (nodes == null) {
                nodes = new ArrayList<>();
                nodes.add(current.key);
            } else {
                nodes.add(current.key);
            }

            map.put(hd, nodes);

            if (current.left != null) {
                current.left.hd = hd - 1;
                queue.add(current.left);
            }

            if (current.right != null) {
                current.right.hd = hd + 1;
                queue.add(current.right);
            }

        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
