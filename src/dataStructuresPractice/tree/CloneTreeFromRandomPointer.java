package dataStructuresPractice.tree;

import java.util.HashMap;
import java.util.Map;

public class CloneTreeFromRandomPointer {

    public TreeNode cloneTree(TreeNode root){
        Map<TreeNode, TreeNode> mappings = new HashMap<>();

        TreeNode clonedRoot = clone(root, mappings);
        copyRandom(root, clonedRoot, mappings);
        return clonedRoot;
    }

    TreeNode clone(TreeNode root, Map<TreeNode, TreeNode> mappings){
        if(root == null){
            return null;
        }

        TreeNode clonedRoot = new TreeNode(root.key);
        mappings.put(root, clonedRoot);
        clonedRoot.left = clone(root.left, mappings);
        clonedRoot.right = clone(root.right, mappings);
        return clonedRoot;
    }

    void copyRandom(TreeNode root, TreeNode clonedRoot, Map<TreeNode, TreeNode> mappings){

        if(clonedRoot == null){
            return ;
        }

        clonedRoot.random = mappings.get(root.random);
        copyRandom(root.left, clonedRoot.left, mappings);
        copyRandom(root.right, clonedRoot.right, mappings);
    }
}
