public class DLList {

    class IntNode {
        public int item;
        public IntNode next;
        public IntNode prev;

        public IntNode(int f, IntNode r, IntNode x) {
            item = f;
            next = r;
            prev = x;
        }

        public IntNode(int f) {
            item = f;
        }

        public int get() {
            return item;
        }

        public void setNext(IntNode x) {
            next = x;
        }

        public void setPrev(IntNode x) {
            prev = x;
        }
    }

    private IntNode head;
    private IntNode tail;
    private int size;

    public DLList(int x) {
        head = new IntNode(x, null, tail);
        tail = new IntNode(0, head, null);
        size = 1;
    }

    public DLList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addHead(int x) {
        if (isEmpty()) {
            new DLList(x);
        }
        if (size == 1) {
            tail = head;
            IntNode e = head;
            head = new IntNode(x, null, e);
        } else {
            IntNode e = head;
            head = new IntNode(x, null, e);
        }
        size++;
    }

    public void addTail(int x) {
        if (isEmpty()) {
            new DLList(x);
        } else if (size == 1) {
            tail.item = x;
        } else {
            IntNode e = tail;
            tail = new IntNode(x, null, e);
        }
        size++;
    }

    public int getHead() {
        return head.item;
    }

    public int getTail() {
        return tail.item;
    }

    public int removeHead() {
        if (isEmpty()) {
            return 0;
        }
        int r = head.item;
        head = head.next;
        size--;
        return r;
    }

    public int removeTail() {
        if (isEmpty()) {
            return 0;
        }
        if (size == 1) {
            return removeHead();
        }
        int r = tail.item;
        tail = head.next;
        size--;
        return r;
    }

    public int size() {
        return size;
    }
}
