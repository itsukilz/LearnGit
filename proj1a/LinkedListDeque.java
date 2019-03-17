public class LinkedListDeque<T>{

    public class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;
        public IntNode(IntNode p, T x, IntNode n) {
            prev = p;
            item = x;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T i) {
        sentinel = new IntNode(null, null, null);
        IntNode p = new IntNode(sentinel, i, sentinel);
        sentinel.next = p;
        sentinel.prev = p;
        size = 1;
    }

    public void addFirst(T i) {
        IntNode p = new IntNode(sentinel, i, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
        size += 1;
    }

    public void addLast(T i) {
        IntNode p = new IntNode(sentinel.prev, i, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode p = sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        IntNode first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size -= 1;
        return first.item;
    }

    public T removeLast() {
        IntNode last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size -= 1;
        return last.item;
    }

    public T get(int index) {
        int count = 0;
        IntNode p = sentinel.next;
        while (p != sentinel) {
            if (count == index) {
                return p.item;
            } else {
                p = p.next;
                count += 1;
            }
        }
        return null;
    }

}