package tree.binarytree;

public class Run {

    public static void main(String[] args) {

        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.insert(13);
        myBinaryTree.insert(8);
        myBinaryTree.insert(17);
        myBinaryTree.insert(1);
        myBinaryTree.insert(11);
        myBinaryTree.insert(6);
        myBinaryTree.insert(15);
        myBinaryTree.insert(25);
        myBinaryTree.printTree();


        Node node = myBinaryTree.search(11);
        if(node == null) {
            System.out.println("not found");
        } else {
            System.out.println("Found Number : " + node.key);
        }

        System.out.println("deltenumber : " + myBinaryTree.delete(17));
        myBinaryTree.printTree();

    }

}
