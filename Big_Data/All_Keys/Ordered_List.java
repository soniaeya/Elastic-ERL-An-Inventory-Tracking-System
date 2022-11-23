package Big_Data.All_Keys;
import Big_Data.*;
public class Ordered_List{
    public static Node head;
    public static Node tail;

    public static class Node {
        public String element;
        public Node next;
        public Node prev;

        public Node() {
        }

        public Node(String e) {
            this.element = e;
        }
        public String getElement() {

            return element;
        }
    }

    public String toString(){

        //while next is not empty
        Node t = head;
        while(tail!=null){

            System.out.println(t.element);
            t = t.next;
        }
        return null;
    }

}
