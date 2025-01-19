public class Main {
    public static void main(String[] args) {
        LinkedIntList list1 = new LinkedIntList();
        LinkedIntList list2 = new LinkedIntList();

        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        list2.removeAll(list1);

        list1.print();
        list2.print();
    }
}
