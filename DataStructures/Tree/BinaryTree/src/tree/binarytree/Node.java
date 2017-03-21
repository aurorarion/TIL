package tree.binarytree;

public class Node {

    int key;
    Node LNode;
    Node RNode;

    Node(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "[" + key + "]";
    }

}
