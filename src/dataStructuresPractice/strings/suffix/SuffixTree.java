package dataStructuresPractice.strings.suffix;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SuffixTree {

    private Node root;
    private static final int UNDEFINED = -1;
    private static final String WORD_TERMINATION = "$";
    private String text;

    public SuffixTree(String text) {
        root = new Node("", UNDEFINED);
        this.text = text;
        for(int i=0; i<text.length(); i++){
            addSuffix(text.substring(i) + WORD_TERMINATION, i);
        }
    }

    public void addChild(Node parentNode, String word, int position) {
        parentNode.getChildren().add(new Node(word, position));
    }

    public String findLongestCommonPrefix(String str1, String str2) {
        int compareString = Math.min(str1.length(), str2.length());

        for (int i = 0; i < compareString; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, compareString);
    }

    public List<Node> findAllNodesInTraversePath(Node startNode, String pattern, boolean isPartialMatchAllowed) {

        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < startNode.getChildren().size(); i++) {
            Node currentNode = startNode.getChildren().get(i);
            String currentText = currentNode.getText();
            //check for first character
            if (pattern.charAt(0) == currentText.charAt(0)) {
                if (isPartialMatchAllowed && pattern.length() <= currentText.length()) {
                    nodes.add(currentNode);
                    return nodes;
                }
                //check for rest of the characters
                int compareString = Math.min(pattern.length(), currentText.length());
                for (int j = 1; j < compareString; j++) {
                    if (pattern.charAt(j) != currentText.charAt(j)) {
                        if (isPartialMatchAllowed) {
                            nodes.add(currentNode);
                        }
                        return nodes;
                    }
                }
                //if all characters match
                nodes.add(currentNode);
                // if the pattern has more characters than the node text, we need to check the child nodes
                if (pattern.length() > compareString) {
                    List<Node> nodeList = findAllNodesInTraversePath(currentNode, pattern.substring(compareString), isPartialMatchAllowed);

                    if (nodeList.size() > 0) {
                        nodes.addAll(nodeList);
                    } else if (!isPartialMatchAllowed) {
                        //In case it's empty for a full match scenario, it means there was a mismatch, so to indicate this, we add a null item.
                        nodes.add(null);
                    }
                }
                    return nodes;
                }

            }
        return nodes;


    }


    public void splitNodeIntoParentAndChild(Node parentNode, String parentText, String childText) {

        Node child = new Node(childText, parentNode.getPosition());

        if (parentNode.getChildren().size() > 0) {
            while (parentNode.getChildren().size() > 0) {
                child.getChildren().add(parentNode.getChildren().remove(0));
            }
        }
        parentNode.getChildren().add(child);
        parentNode.setText(parentText);
        parentNode.setPosition(UNDEFINED);
    }

    public void addSuffix(String suffix, int position) {

        List<Node> nodes = findAllNodesInTraversePath(root, suffix, true);

        if (nodes.size() == 0) {
            addChild(root, suffix, position);
        } else {
            Node lastNode = nodes.remove(nodes.size() - 1);
            String newText = suffix;
            if (nodes.size() > 0) {
                String prefixTillLastNode = nodes.stream().map(aNode -> aNode.getText()).reduce("", String::concat);
                newText = newText.substring(prefixTillLastNode.length());
            }
            extendNode(lastNode, newText, position);
        }
    }

    private void extendNode(Node lastNode, String newText, int position) {
        String lastNodeText = lastNode.getText();
        String commonPrefix = findLongestCommonPrefix(lastNodeText, newText);

        if(commonPrefix != lastNodeText){
            String parentText = lastNodeText.substring(0, commonPrefix.length());
            String childText = lastNodeText.substring(commonPrefix.length());
            splitNodeIntoParentAndChild(lastNode, parentText, childText);
        }
        String remainingText = newText.substring(commonPrefix.length());
        addChild(lastNode, remainingText, position);
    }


    public List<String> searchPattern(String pattern){

        List<String> result = new ArrayList<>();
        List<Node> nodes = findAllNodesInTraversePath(root, pattern, false);

        if(nodes.size() > 0){
            Node lastNode = nodes.remove(nodes.size()-1);
            List<Integer> positions = getPositions(lastNode);
            positions = positions.stream().sorted().collect(Collectors.toList());
            positions.stream().forEach(position -> result.add(markPattern(position, pattern)));
        }
        return result;
    }

    private String markPattern(Integer position, String pattern) {
        String LHS = text.substring(0, position);
        String midText = text.substring(position, position+pattern.length());
        String RHS = text.substring(position+pattern.length());
        return LHS + "[" + midText + "]" + RHS;

    }

    private List<Integer> getPositions(Node lastNode) {
        List<Integer> positions = new ArrayList<>();
        if(lastNode.getText().endsWith(WORD_TERMINATION)){
            positions.add(lastNode.getPosition());
        }
        for(int i=0; i<lastNode.getChildren().size(); i++){
            positions.addAll(getPositions(lastNode.getChildren().get(i)));
        }
        return positions;
    }

    public static void main(String[] args) {
        SuffixTree suffixTree = new SuffixTree("havanabanana");

        List<String> matches = suffixTree.searchPattern("nab");
        matches.stream().forEach(m -> System.out.println(m));
    }

}

