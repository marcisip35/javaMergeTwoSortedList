class Main{
    public static void main(String[] args){
        /* Leet Code Question #21
         * Easy Question #6
         */

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = mergeTwoLists(list1, list2);

        // Print the merged list
        System.out.println(printList(mergedList));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);  //create a empty list
        ListNode curr = dummy; //curr is dummy

        while(list1 != null && list2 != null){ //Make sure the list is not null
            //Merge List
            if(list1.val <= list2.val){ //Take the head / current node and compare
                curr.next = list1; //append the current node if the first list is less than or equal
                list1 = list1.next; //traverse the first list
            } else {
                curr.next = list2; //append the current node of the second list
                list2 = list2.next; //traverse the second list
            }
            curr = curr.next; //traverse the current list
        }

        curr.next = list1 != null ? list1 : list2; //this terminates at the last nodes, put l1 or l2 

        return dummy.next;
    }

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static String printList(ListNode head){
        String str = "";
        ListNode curr = head;

        while(curr != null){
            str += curr.val + " -> ";
            curr = curr.next;
        }

        return str;
    }
}