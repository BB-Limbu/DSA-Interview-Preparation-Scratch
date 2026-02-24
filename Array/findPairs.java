

public class findPairs {
    /*
    Better Approach
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public static ListNode_1 findPairOfSum(ListNode_1 head, int sum){
        ListNode_1 temp1 = head;
        ArrayList<Integer> ans = new ArrayList<>();
        while(temp1 != null){
            ListNode_1 temp2 = head.next;

            while(temp2 != null){
                if(temp1.val + temp2.val == sum){
                    ans.add(temp1.val, temp2.val);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return temp1.next;
    }

    /*
    Optimal Approach
    Time Complexity O(2n)
    Space Complexity O(n)
     */

    public static ArrayList<Integer> findPairs(ListNode_1 head, int k){
        ArrayList<Integer> ans = new ArrayList<>();

        if(head == null){
            return  ans;
        }
        ListNode_1 left = head;
        ListNode_1 right = findTail(head);

        while(left.val < right.val){
            if(left.val + right.val == k){
                ans.add(left.val, right.val);
                left =left.next;
                right = right.prev;
            }else if(left.val + right.val < k){
                left = left.next;
            }
            else{
                right = right.next;
            }

        }
        return ans;
    }


    public static void main(String[] args){

    }
}

