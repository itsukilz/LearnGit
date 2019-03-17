public class DLList {

    public class IntNode {
        public IntNode prev;
        public int item;
        public IntNode next;
        public IntNode(IntNode p, int i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel = new IntNode(null,0, null);
    private int count;

    public DLList() {
        count = 0;
    }

    public DLList(int x) {
        sentinel.next = new IntNode(sentinel,x, null);
        sentinel.prev = sentinel.next;
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