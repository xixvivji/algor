import java.util.*;

class Node {
    char data;
    Node left;
    Node right;
    Node(char data){
        this.data = data;
    }
}

public class Main {
    public Node root;

    public void createNode(char data, char leftData, char rightData){
        if (root == null) {
            root = new Node(data);

            if(leftData != '.'){
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public void searchNode(Node node, char data, char leftData, char rightData){
        if(node == null) { 
            return;
        } else if(node.data == data) {
            if(leftData != '.') {
                node.left = new Node(leftData);
            }
            if(rightData != '.') {
                node.right = new Node(rightData);
            }
        } else { 
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main t = new Main();

        for (int i = 0; i < n; i++) {
            char a = sc.next().charAt(0);
            char b = sc.next().charAt(0);
            char c = sc.next().charAt(0);

            t.createNode(a, b, c);
        }

        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
        System.out.println();
    }
}