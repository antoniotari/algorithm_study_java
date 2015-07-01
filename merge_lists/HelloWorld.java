import java.util.ArrayList;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        ArrayList<ListNode> lists = new ArrayList<ListNode>();
        for(int i=0;i<12;i++){
            ListNode node = new ListNode(i);
            node.next = new ListNode(i+1);
            node.next.next = new ListNode(i+2);
            node.next.next.next = new ListNode(i+3);
            lists.add(node);
        }
        
        ListNode nodeMerged = new MergeLists().mergeKLists(lists);
        ListNode topNode = nodeMerged;
        while(topNode!=null){
            System.out.println(topNode.val+" ");
            topNode=topNode.next;
        }
     }
}
