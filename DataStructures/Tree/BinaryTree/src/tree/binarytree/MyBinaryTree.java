package tree.binarytree;

public class MyBinaryTree {

    private Node root;

    public MyBinaryTree() {

    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node x, int data) {
        if(x == null) {
            x = new Node(data);
        } else if(x.key > data) {
            x.LNode = insert(x.LNode, data);
        } else {
            x.RNode = insert(x.RNode, data);
        }
        return x;
    }

    public void printTree() {
        printTree(root, 0, "root");
    }

    private void printTree(Node x, int depth, String name) {
        if(x != null) {
            for(int i = 0; i < depth; i++) {
                System.out.print(" ");
            }
            System.out.printf("<%s> data: %d\n", name, x.key);
            printTree(x.LNode, depth + 1, "left");
            printTree(x.RNode, depth + 1, "right");
        }
    }

    public Node search(int data) {
        return search(root, data);
    }

    private Node search(Node x, int data) {
        while(x != null) {
            if(x.key > data) {
                x = x.LNode;
            } else if(x.key < data) {
                x = x.RNode;
            } else {
                return x;
            }
        }
        return null;

        // Recursive soulve
        /*if(x != null) {
            if(x.key > data) {
                x = search(x.LNode, data);
            } else if(x.key < data) {
                x = search(x.RNode, data);
            }
        }
        return x;*/
    }

    public int delete(int data) {
        Node h = searchForDelete(root, data);
        if(h == null) {
            return -1;
        }
        Node x = directionCheck(h, data);
        Node temp;
        int ret = x.key;
        if(x.RNode == null && x.LNode == null) {
            noChildRemove(h, data);
        } else if(x.RNode == null) {
            temp = largeNodeSearch(x.LNode);
            if(temp == x.LNode) {
                x.key = temp.key;
                x.LNode = temp.LNode;
            } else {
                x.key = temp.RNode.key;
                temp.RNode = null;
            }
        } else {
            temp = smallNodeSearch(x.RNode);
            if(temp == x.RNode) {
                x.key = temp.key;
                x.RNode = temp.RNode;
            } else {
                x.key = temp.LNode.key;
                temp.LNode = null;
            }
        }
        return ret;
    }

    private Node directionCheck(Node x, int data) {
        if(x.LNode != null && x.LNode.key == data) {
            return x.LNode;
        } else if (x.RNode != null && x.RNode.key == data) {
            return x.RNode;
        }
        return null;
    }

    private void noChildRemove(Node x, int data) {
        if(x.LNode != null && x.LNode.key == data) {
            x.LNode = null;
        } else if (x.RNode != null && x.RNode.key == data) {
            x.RNode = null;
        }
    }

    private Node smallNodeSearch(Node x) {
        while(x.LNode != null) {
            x = x.LNode;
        }
        return x;
    }

    private Node largeNodeSearch(Node x) {
        while(x.RNode != null) {
            x = x.RNode;
        }
        return x;
    }

    private Node searchForDelete(Node x, int data) {
        Node temp = null;
        while(x != null) {
            if (x.key > data) {
                temp = x;
                x = x.LNode;
            } else if (x.key < data) {
                temp = x;
                x = x.RNode;
            } else {
                return temp;
            }
        }
        return null;
    }

}