package Grap;
import java.util.Stack;

public class CheckBst {
    private Node root;

    class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
        public Node(){
            left = null;
            right = null;
        }
    }

    public CheckBst(){
        root = new Node();
    }

    public void put(int key){
        root = put(root, key);
   }

   public Node put(Node node,int key){
       if(node == null){
           return new Node(key);
       }
       if(key < node.key){
            node.left = put(node.left, key);
       }
       else if(key > node.key){
           node.right = put(node.right, key);
       }
       return node;
   }

    public boolean isBst(Node node) {
        if(node == null){
            return false;
        }
        int key = node.key;
        if(node.left != null){
            Node left = node.left;
            if(!isBstLeft(left,key)){
                return false;
            }
            else return isBst(node.left);
        }
        if(node.right != null){
            Node right = node.right;
            if(!isBstRight(right, key)){
                return false;
            }
            else return isBst(node.right);
        }
        
        return true;
    }
    public boolean isBstLeft(Node node, int key){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node temp = stack.pop();

            if(temp == null){
                break;
            }
            if(key < temp.key){
                return false;
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
        
        }
        return true;
    }

    public boolean isBstRight(Node node , int key){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
       
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            if(key > temp.key){
                return false;
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
        
        }
        return true;
    }

   

    public static void main(String[] args) {
        CheckBst check = new CheckBst();
       check.root = check.new Node(10);
       check.root.left = check.new Node(1);
       check.root.right = check.new Node(11);
       check.root.left.left = check.new Node(4);
       check.root.left.right = check.new Node(5);


       System.out.println(check.isBst(check.root));

    }
}
