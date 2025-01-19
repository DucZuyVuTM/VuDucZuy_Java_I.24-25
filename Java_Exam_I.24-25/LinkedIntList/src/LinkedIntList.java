public class LinkedIntList {
    public ListNode front;

    public ListNode getFront() {
        return front;
    }

    public void add(int data) {
        if (front == null) {
            front = new ListNode(data);
        } else {
            ListNode current = front;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            ListNode newNode = new ListNode(data);
            current.setNextNode(newNode);
        }
    }

    public ListNode removeHead() {
        front = front.getNextNode();
        return front;
    }

    public ListNode removeTail() {
        ListNode tail = front;
        while (tail.getNextNode().getNextNode() != null) {
            tail = tail.getNextNode();
        }
        tail.setNextNode(null);
        return tail;
    }

    public ListNode remove(ListNode node) {
        ListNode prev = front;
        ListNode current = front.getNextNode();
        while (current.getNextNode() != null) {
            if (current == node) {
                prev.setNextNode(current.getNextNode());
                return prev;
            }
            prev = current;
            current = current.getNextNode();
        }
        System.out.println("Cannot find the node to remove.");
        return node;
    }

    public void removeAll(LinkedIntList list2) {
        ListNode front2 = list2.getFront();
        ListNode i = front;
        ListNode j = front2;
        while (i != null && j != null) {
            if (i.getData() == j.getData()) {
                if (i == front) {
                    i = removeHead();
                } else if (i.getNextNode() == null) {
                    i = removeTail();
                } else {
                    i = remove(i);
                }
            } else if (i.getData() < j.getData()) {
                i = i.getNextNode();
            } else {
                j = j.getNextNode();
            }
        }
    }

    public void print() {
        ListNode current = front;
        while (current != null) {
            if (current.getNextNode() != null) {
                System.out.print(current.getData() + " ");
            } else {
                System.out.print(current.getData());
            }
            current = current.getNextNode();
        }
        System.out.println();
    }
}
