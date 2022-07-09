public class DLLTest {
public static void main(String[] args) {
        DLList e = new DLList(11);
        System.out.println(e.getHead());
        System.out.println(e.getTail());
        e.addHead(12);
        System.out.println(e.getHead());
        e.addTail(13);
        System.out.println(e.getTail());

}
}
