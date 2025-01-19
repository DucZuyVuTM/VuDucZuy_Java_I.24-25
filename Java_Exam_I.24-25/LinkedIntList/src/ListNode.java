public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public ListNode getNextNode() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setNextNode(ListNode next) {
        this.next = next;
    }
}
