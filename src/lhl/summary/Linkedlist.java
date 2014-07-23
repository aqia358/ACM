package lhl.summary;

public interface Linkedlist {

	public ListNode reverse(ListNode head);

	public ListNode reverse(ListNode head, int group);
	
	public ListNode reverse(ListNode head, int start, int end);

	public ListNode merge(ListNode list1, ListNode list2);
	
	public ListNode mergeSoft(ListNode head);
	
	public ListNode quickSort(ListNode head);

	public ListNode detectCycle(ListNode head);
	
	public boolean hasCycle(ListNode head);
	
	public ListNode findCross(ListNode head1, ListNode head2);

}
