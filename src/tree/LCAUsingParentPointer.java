package tree;

public class LCAUsingParentPointer {
    public static void main(String[] args) {
        //TODO - revisit
        LCAUsingParentPointer tree = new LCAUsingParentPointer();
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);

        n1 = tree.root.left.right.left;
        n2 = tree.root.right;
        lca = tree.LCA(n1, n2);

        System.out.println("LCA of " + n1.key + " and " + n2.key
                + " is " + lca.key);
    }

    static NodeTree root, n1, n2, lca;

    static class NodeTree{
        int key;
        NodeTree left, right, parent;

        NodeTree(int key){
            this.key = key;
            this.left = null;
            this.parent = null;
            this.right = null;
        }
    }

    private static NodeTree insert(NodeTree node, int key){
        if (node == null)
            node = new NodeTree(key);

        else if(key<node.key){
            node.left = insert(node.left, key);
            node.left.parent = node;
        } else if(key > node.key){
            node.right = insert(node.right, key);
            node.right.parent = node;
        }
        return node;

    }

    private static int depth(NodeTree node){
        int d = -1;
        while(node != null){
            d++;
            node = node.parent;
        }
        return d;
    }

    private static NodeTree LCA(NodeTree n1, NodeTree n2) {

        int depthOfN1 = depth(n1);
        int depthOfN2 = depth(n2);

        int diff = depthOfN1 - depthOfN2;

        if (diff < 0){
            NodeTree temp = n1;
            n1 = n2;
            n2 = temp;
            diff = -diff;
        }

        while(diff-- != 0){
            n1 = n1.parent;
        }

        while(n1 != null && n2 != null){
            if (n1 == n2)
                return n1;
            n1 = n1.parent;
            n2 = n2.parent;

        }
        return null;
    }
}
