package Big_Data;

import Big_Data.All_Keys.Ordered_List;

import static Big_Data.All_Keys.Ordered_List.head;


public class Big_Data_Methods {
    public static int generate() {
        // O(n)
        // Generate a random 8-digit number
        // Quick sort to see if it already exists in the list

        return 0;
    }

    public static void allKeys(LinkedList ElasticERL) {
        //return all keys in ElasticERL as a sorted sequence
        Ordered_List.Node t = Ordered_List.head;
        int counter = 0;
        while(Ordered_List.tail!=null && t !=null){
            System.out.print(counter + ": ");
            System.out.println(t.element);
            t = t.next;
            counter++;
        }
    }
    //Methods for adding nodes (Trinode restructuring)

    public static void getValues(LinkedList ElasticERL, LinkedList.Node key) {
        // return the values of the given key
    }

    public static void nextKey(LinkedList ElasticERL, String key) {
        boolean exists = false;
        LinkedList.Node t = ElasticERL.head;
        while(t.next!=null && t.element!=null){
            if(t.element.equals(key)){
                System.out.println("The key after "+key+" is: "+t.next.element);
                exists = true;
                t = ElasticERL.tail.prev;
            }
            t = t.next;
        }
        if (exists == false){
            if(key == ElasticERL.tail.element){
                System.out.println("The here is no key after "+key);
                System.out.println();
            }
            else{
                System.out.println("The key you have inserted is not in the database!");
                System.out.println();
            }
        }

    }

    public static void prevKey(LinkedList ElasticERL, String key) {
        //  return the key for the predecessor of key;
        boolean exists = false;
        LinkedList.Node temp = ElasticERL.head;

        while(temp.next!=null && temp.element!=null){
            if(temp.element.equals(key)){
                System.out.println("The key before "+key+" is: "+temp.prev.element);
                System.out.println();
                exists = true;
                temp = ElasticERL.tail.prev;
            }
            temp = temp.next;
        }
        if (exists == false){
            if(temp == ElasticERL.head){
                System.out.println("The here is no key before "+temp.element);
            }
            else{
                System.out.println("The key you have inserted is not in the database!");
            }
        }


    }

    public static void rangeKey(String key1, String key2, LinkedList big) {
        // returns the number of keys that are within the specified range of
        //the two keys key1 and key2
        //key1 = "51281754";
        //key2 = "70162601";

        LinkedList.Node t = big.head;

        boolean b = false;
        while(t!=null&&!b){
            if(t.element.equals(key1)){
                while(t!=null&&!t.prev.element.equals(key2)){
                    System.out.println(t.element);
                    t = t.next;
                }
                t = big.tail;
                System.out.println();
            }

            t = t.next;

        }


    }
}
