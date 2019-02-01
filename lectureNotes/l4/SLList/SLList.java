public class SLList {

    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    private IntNode last;
    private int count;

    public SLList() {
        first = null;
        last = null;
        count = 0;
    }

    public SLList(int x) {
        first = new IntNode(x, null);
        last = first;
        count = 1;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
        count += 1;
    }

    public int getFirst() {
        return first.item;
    }

    public void addLast (int x) {
        if(last == null) {
            first = new IntNode(x, null);
            last = first;
            count = 1;
        } else {
            last.next = new IntNode(x, null);
            last = last.next;
            count += 1;
        }
    }

    public int getLast() {
        return last.item;
    }

    public int size() {
        return count;
    }

    public void print() {
        IntNode p = first;
        while (p.next != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }
}