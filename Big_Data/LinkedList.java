package Big_Data;

import Big_Data.All_Keys.Ordered_List;

import java.util.Objects;

public class LinkedList {
    public static Node head;
    public static Node tail;

    public static class Node {

        String value = "";
        String element;


        Node parent;
        Node left;
        Node right;
        Node prev;
        Node next;


        public Node(AVL_Entry new_entry) {
            this.element = new_entry.key;
            this.value = new_entry.value;
        }

        public String getElement() {

            return element;
        }
    }

    public static int compare(String s1, String s2, int counter){
        if(Objects.equals(s1, s2)){
            return 0;
        }
        while (counter<8){

            if(s1.charAt(counter)< s2.charAt(counter)){
                //Returns -1 if the first object is smaller than the second object
                return -1;

            }
            else if(s1.charAt(counter) > s2.charAt(counter)){

                return 1;

            }
            else if(s1.charAt(counter) == s2.charAt(counter)){
                ++counter;
                compare(s1, s2, counter);

            }
        }
        return 100;
    }



    public static void addNode(AVL_Entry new_entry) {
        //Create new node
        Node newNode = new Node(new_entry);

        //If list is empty set head and tail to new node
        if (head == null) {
            head = tail = newNode;

        }
        else {
            insert_AVL(newNode, head);


            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;


            //method recurse through the avl tree to insert
        }


    }

    public static void add_to_end(Node newNode){
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    /*public static void Create_AVL_Tree(String insert, int idx){
        addNode(insert);
        // Checks if it is the first element
    }*/
    public static void inOrder(LinkedList.Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        //System.out.println(node.getElement());

        AVL_Entry new_entry = new AVL_Entry(node.getElement(), "");
        Ordered_List.Node new_OD_node = new Ordered_List.Node(new_entry);

        if(Ordered_List.head == null){
            Ordered_List.head = new_OD_node;
            Ordered_List.tail = new_OD_node;
        }
        else{
            Ordered_List.Node temp = Ordered_List.tail;
            new_OD_node.prev = temp;
            Ordered_List.tail.next = new_OD_node;
            Ordered_List.tail = new_OD_node;
        }
        inOrder(node.right);
    }


    public static void insert_AVL(Node newNode, Node root){

        //Setting prev and next of head and second element
        if(root == null){
            root = newNode;
            root.prev = null;
            root.next = null;

            tail = newNode;
            tail.prev = null;
            tail.next = null;
        }


        if (compare(newNode.getElement(),root.getElement(),0) < 0){
            if(root.left == null){
                root.left = newNode;

                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                tail.next = null;

            }
            else{
                insert_AVL(newNode, root.left);
            }
        }
        else if (root.getElement() == newNode.getElement()){
            //Impossible to have double elements, use to verify code
            System.out.println("Double elements not allowed!");
        }
        else
        {
            if(root.right == null){
                root.right = newNode;

                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                tail.next = null;
            }
            else{
                insert_AVL(newNode, root.right);
            }
        }


    }




}