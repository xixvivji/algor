import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static void insert(Node root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new Node(val);
            } else {
                insert(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(val);
            } else {
                insert(root.right, val);
            }
        }
    }

    static void postorder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        postorder(node.left, sb);
        postorder(node.right, sb);
        sb.append(node.val).append('\n');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Node root = null;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int val = Integer.parseInt(line);
            if (root == null) {
                root = new Node(val);
            } else {
                insert(root, val);
            }
        }
        StringBuilder sb = new StringBuilder();
        postorder(root, sb);
        System.out.print(sb);
    }
}