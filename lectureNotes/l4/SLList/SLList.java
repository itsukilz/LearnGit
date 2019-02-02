public class SLList {

    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode last;
    private IntNode sentinel = new IntNode(0, null);
    private int count;

    public SLList() {
        last = sentinel;
        count = 0;
    }

    public SLList(int x) {
        sentinel.next = new IntNode(x, null);
        last = sentinel.next;
        count = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        count += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast (int x) {
        last.next = new IntNode(x,null);
        last = last.next;
        count += 1;
    }

    public int getLast() {
        return last.item;
    }

    public int size() {
        return count;
    }

    public void print() {
        IntNode p = sentinel.next;
        while (p.next != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }
}