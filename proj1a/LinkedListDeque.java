public class LinkedListDeque<T> {

    class IntNode {
        public T item;
        public IntNode next;
        public IntNode prev;

        IntNode(T f, IntNode r, IntNode x) {
            item = f;
            next = r;
            prev = x;
        }

        IntNode(T f) {
            item = f;
        }

        public T getNode() {
            return item;
        }

        public void setItem(T x) {
            item = x;
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

    LinkedListDeque(T x) {
        head = new IntNode(x, null, tail);
        tail = new IntNode(null, head, null);
        size = 1;
    }

    LinkedListDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T x) {
        if (isEmpty()) {
            new LinkedListDeque(x);
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

    public void addLast(T x) {
        if (isEmpty()) {
            new LinkedListDeque(x);
        } else if (size == 1) {
            tail = new IntNode(x, head, null);
        } else {
            IntNode e = tail;
            tail = new IntNode(x, null, e);
        }
        size++;
    }

    public T getHead() {
        return head.item;
    }

    public T getTail() {
        return tail.item;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T r = head.item;
        head = head.next;
        size--;
        return r;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            return removeFirst();
        }
        T r = tail.item;
        tail = head.next;
        size--;
        return r;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode nihao = head;

        while (nihao != null) {
            System.out.println(nihao.item + "");
            nihao = nihao.next;
        }
    }

    public T get(int index) {
        IntNode nihao;

        if (index >= size) {
            return null;
        }

        if (index == 0) {
            return head.item;
        }

        if (index == (size - 1)) {
            return tail.item;
        }

        if ((size - index) < (size / 2)) {
            int i = 0;
            nihao = head;
            while (i < index) {
                nihao = nihao.next;
                i++;
            }
            return nihao.item;
        }

        int i = size - 1;
        nihao = tail;
        while (i > index) {
            nihao = nihao.prev;
            i--;
        }
        return nihao.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }

        return getRecursive(0, index, head);
    }

    private T getRecursive(int i, int index, IntNode node) {
        if (i == index) {
            return node.item;
        }
        return getRecursive(i + 1, index, node.next);
    }

//public static void main(String[] args) {
//        LinkedListDeque<String> e = new LinkedListDeque<>();
//        e.addFirst("woqu");
//
//        System.out.println(e.getHead());
//        e.addLast("nitm");
//        System.out.println(e.getTail());
//
//        System.out.println(e.getTail());
//}
}
