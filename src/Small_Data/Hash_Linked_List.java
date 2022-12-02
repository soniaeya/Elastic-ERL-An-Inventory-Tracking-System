package Small_Data;

public class Hash_Linked_List {
    Node head;
    Node tail;

    public static class Node{
        Node prev;
        Node next;
        Hash_Entry entry;
        Node(Hash_Entry entry){
            this.entry = entry;

        }
    }


    public String toString(){
        Node t = head;
        String str = "";
        while(t.next!=null){
            str = str +" "+ t.entry.key;


            t = t.next;
        }
        return str;
    }
}
