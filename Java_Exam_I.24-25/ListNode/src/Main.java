public class Main {
    public static void addToEnd(ListNode list, int data) {
        ListNode current = list;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(data);
    }

    public static void print(ListNode list) {
        ListNode current = list;
        System.out.print("list -> ");
        while (current != null) {
            System.out.print("[" + current.data + "] -> ");
            current = current.next;
        }
        System.out.println("/");
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        addToEnd(list, 2);
        print(list);

        // Change from [1] -> [2] to [1] -> [2] -> [3]
        addToEnd(list, 3);
        print(list);
    }
}
