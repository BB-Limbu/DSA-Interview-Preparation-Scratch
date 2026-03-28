


public class SearchKeyBST {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static Node inserts(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.val > val){
            root.left =  inserts(root.left, val);
        }else{
            root.right = inserts(root.right, val);
        }
        return root;
    }

    public static void inorders(Node root){
        if(root == null){
            return;
        }
        inorders(root.left);
        System.out.print(root.val+" ");
        inorders(root.right);
    }

    public static boolean searchKey(Node root, int key){ // Time Complexity O(H)
        if(root == null){
            return false;
        }
        if(root.val == key){
            return true;
        }
        if(root.val > key){
            return searchKey(root.left, key);
        }else{
            return searchKey(root.right, key);
        }
    }
    public static void main(String[] args){
        int[] values = {5,1,3,4,2,7};
        Node root = null;

        for(int i = 0; i < values.length; i++){
            root = inserts(root, values[i]);
        }
        inorders(root);
        System.out.println();

        if(searchKey(root, 5)){
            System.out.println("Key found");
        }else{
            System.out.println("Not Found");
        }
    }
}

