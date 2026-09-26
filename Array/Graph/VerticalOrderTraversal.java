


public class VerticalOrderTraversal {
    public static List<List<Integer>> verticalOrderTraversal(Tree node){
        List<List<Integer>> ans = new ArrayList<>();
        if(node == null){
            return ans;
        }


        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Tree> q = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();

        q.offer(node);
        q1.offer(0);

        while(!q.isEmpty()){
            Tree currNode = q.poll();
            int  currVertical = q1.poll();


            map.putIfAbsent(currVertical, new ArrayList<>());
            map.get(currVertical).add(currNode.data);


            if(currNode.left != null){
                q.offer(currNode.left);
                q1.offer(currVertical -1);
            }

            if(currNode.right != null){
                q.offer(currNode.right);
                q1.offer(currVertical + 1);
            }


        }
        for(List<Integer> list : map.values()){
            ans.add(list);
        }
        return ans;
    }


    public static List<List<Integer>> practice(Tree node){
        List<List<Integer>> ans = new ArrayList<>();
        if(node == null){
            return ans;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Tree> q = new LinkedList<>();
        Queue<Integer> vertical = new LinkedList<>();

        q.offer(node);
        vertical.offer(0);

        while(!q.isEmpty()){
            Tree currNode = q.poll();
            int currVer = vertical.poll();

            map.putIfAbsent(currVer, new ArrayList<>());
            map.get(currVer).add(currNode.data);

            if(currNode.left != null){
                q.offer(currNode.left);
                vertical.offer(currVer -1);
            }
            if(currNode.right != null){
                q.offer(currNode.right);
                vertical.offer(currVer + 1);
            }

        }

        for(List<Integer> list : map.values()){
            ans.add(list);
        }
        return ans;

    }

    public static void main(String[] args){
        Tree root = new Tree(1);

        root.left = new Tree(2);
        root.right = new Tree(3);

        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        root.right.right = new Tree(6);

        System.out.println(verticalOrderTraversal(root));
    }
}
