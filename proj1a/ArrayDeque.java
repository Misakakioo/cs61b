public class ArrayDeque<T> {
    private int size;
    private int capacity;
    private Object[] items;
    private int head;
    private int tail;

    public ArrayDeque() {
        capacity = 3;
        items = new Object[capacity];
        size = 0;
        head = 0;
        tail = 0;
    }

    private void resize() {
        int tmp = capacity;
        capacity = capacity * 4;
        Object[] temp = new Object[capacity];

        if (head < tail) {
            System.arraycopy(items, head, temp, 0, tail - head + 1);
        } else {
            System.arraycopy(items, head, temp, 0, tmp - head);
            System.arraycopy(items, 0, temp, tmp - head + 1, tail);
        }
        items = temp;
    }

    public void addFirst(T item) {
        size++;
        if (size == capacity) {
            resize();
        }

        if (items[head] == null) {
            items[head] = item;
        } else if (head == 0 && items[head] != null) {
            head = capacity - 1;
            items[head] = item;
        } else {
            head--;
            items[head] = item;
        }

    }

    public void addLast(T item) {
        size++;
        if (size == capacity) {
            resize();
        }

        if (items[tail] == null) {
            items[tail] = item;
        } else if (tail == 0 && items[tail] != null) {
            tail = capacity - 1;
            items[tail] = item;
        } else {
            tail++;
            items[tail] = item;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            return;
        } else if (size == 1) {
            System.out.println(items[head]);
        } else if (head < tail) {
            for (int i = head; i < tail; i++) {
                System.out.println(items[i] + "");
            }
        } else {
            for (int i = 0; i <= tail; i++) {
                System.out.println(items[i] + "");
            }
            for (int i = head; i < capacity; i++) {
                System.out.println(items[i] + "");
            }
        }
    }

    public Object removeFirst() {
        if (size == 0) {
            return null;
        }
        Object tmp = items[head];

        if (head == capacity - 1) {
            head = 0;
        } else {
            head++;
        }
        size--;
        if (Math.floorDiv(size, capacity) > 0.25) {
            downnsize();
        }
        return tmp;
    }

    private void downnsize() {
        int tmp = capacity;
        capacity = size * 2;
        Object[] temp = new Object[capacity];

        if (head < tail) {
            System.arraycopy(items, head, temp, 0, tail - head + 1);
        } else {
            System.arraycopy(items, head, temp, 0, capacity - head);
            System.arraycopy(items, 0, temp, capacity - head, tail);
        }
        items = temp;
    }

    public Object removeLast() {
        if (size == 0) {
            return null;
        }
        Object tmp = items[tail];

        if (tail == capacity - 1) {
            tail = 0;
        } else {
            tail--;
        }
        if (Math.floorDiv(size, capacity) > 0.25) {
            downnsize();
        }
        size--;
        return tmp;
    }

    public Object get(int index) {
        return items[index];
    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> e = new ArrayDeque<>();
//
//    }
}
