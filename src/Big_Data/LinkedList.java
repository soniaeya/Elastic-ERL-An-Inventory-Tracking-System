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
        int height = 1;
        int real_height;


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
            tail.next = null;

            //method recurse through the avl tree to insert
        }
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
            newNode.height++;
        }

        if (compare(newNode.getElement(),root.getElement(),0) < 0){ //Compares the new node < the root values -> if the root's left node is empty, insert at that node
            if(root.left == null){
                newNode.height++;
                newNode.real_height= tail.height - newNode.height;

                root.left = newNode;
                tail.next = newNode;
                newNode.parent = root;
                newNode.prev = tail;
                tail = newNode;
                tail.next = null;
            }
            else{
                insert_AVL(newNode, root.left);
                newNode.height++;

            }
        }
        else if (root.getElement() == newNode.getElement()){
            //Impossible to have double elements, use to verify code
            //System.out.println("Double elements not allowed!");
        }
        else
        {
            if(root.right == null){
                newNode.height++;
                newNode.real_height= tail.height - newNode.height;
                root.right = newNode;
                newNode.parent = root;
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                tail.next = null;
            }
            else{
                insert_AVL(newNode, root.right);
                newNode.height++;
            }
        }

    }

    public static void set_height(){
        Node n = head;
        while(n!= null && n.next!=null){
            n.real_height = tail.height - n.height;
            n = n.next;
        }
    }

    public static void insert_height(){
        Node temp = tail;
        while(temp.parent!=null){
            temp.parent.real_height++;
            temp = temp.parent;
        }
    }


    public static void trinode_restructuring(Node n){
        /*
        System.out.println("Entered Trinode Restructuring ");
        System.out.println("N value = "+n.element);
        System.out.println("N parent = "+n.parent.element);
        System.out.println("Real height = "+n.real_height);

        System.out.println(n.parent!= null);


         */

        boolean tri_res = false;
        //int real_height = tail.height - n.height;
        boolean cont;
        while(n.parent!= null){

            cont = false;

/*
            System.out.println("n"+n.element);
            System.out.println("height"+n.real_height);
            try{
                System.out.println("left"+n.left.element);
                System.out.println("left height"+n.left.real_height);

            }
            catch(Exception e){
                System.out.println("No left");

            }
            try{
                System.out.println("right"+n.right.element);
                System.out.println("right height"+n.right.real_height);

            }
            catch(Exception e){
                System.out.println("No right");

            }

*/
            //R null, L null
            if(!(n.left == null && n.right == null)){
                cont = true;
            }

            //R null, L 1
            try{
                if(n.left == null && n.right.real_height == 1){
                    cont = true;
                }

            }
            catch (Exception e){

            }
            //R 1, L null
            try{
                if(n.left == null && n.right.real_height == 1){
                    System.out.println(n.element+"r1 l0");
                    cont = true;
                }
            }
            catch (Exception e){
            }

            try{
                if (n.parent.left.real_height == n.parent.right.real_height-1){
                    cont = true;
                }
            }
            catch(Exception e){

            }
            try{
                if (n.parent.left.real_height == n.parent.right.real_height){
                    cont = true;
                }
            }
            catch(Exception e){

            }

            try{
                if (n.parent.right.real_height ==n.parent.left.real_height-1){
                    cont = true;
                }
            }
            catch(Exception e){

            }


            if(cont){



                    System.out.println("Element: "+ n.element);
                    System.out.println("Height Element: "+ n.real_height);
                    try{
                        System.out.println("Parent: "+ n.parent.element);
                        System.out.println("Height parent: "+ n.parent.real_height);
                    }
                    catch(Exception e){
                        System.out.println("No parent");
                    }
                    try{
                        System.out.println("Left: "+ n.left.element);
                        System.out.println("Height left: "+ n.left.real_height);
                    }
                    catch(Exception e){
                        System.out.println("No left");
                    }
                    try{
                        System.out.println("Right: "+ n.right.element);
                        System.out.println("Height Right: "+ n.right.real_height);
                    }
                    catch(Exception e){
                        System.out.println("No right");

                    }
                    try{
                        System.out.println("Next: "+ n.next.element);
                        System.out.println("Height next: "+ n.next.real_height);
                    }
                    catch(Exception e){
                        System.out.println("Next: Next is null");

                    }

                    System.out.println();







                n = n.parent;
            }
            else{
                System.out.println("Trinode Restructuring needed at" + n.element);


                //needs restructuring at Node n
                Node z = n;
                Node y = null;
                Node x = null;
                System.out.println("Z is " + n.element);
                n = n.parent;


                //choose larger element of Z

                /*

                if(n.left == null){
                    y = n.right;
                }
                else if(n.right == null){
                    y = n.left;
                }


                //88888888
                else if(n.left.real_height > n.right.real_height){
                    y = n.left;
                }
                else if(n.left.real_height < n.right.real_height){
                    y = n.right;
                }




                if(y.left.real_height > y.right.real_height){
                    x = n.left;
                }
                else{

                    x = n.right;
                }

            System.out.println("Single Rotation");

                //Single Rotation
                //1
                if(y!= null && z.right == y && y.right == x){
                    y.parent = z.parent;
                    y.left = z;
                }
                //2
                else if(y!= null && z.left == y && y.left == x){
                    y.parent = z.parent;
                    y.right = z;
                }
                //Double Rotation
                else if(y!= null &&  z.right == y && y.left == x){
                    x.parent = z.parent;
                    x.right = y;
                    x.left = z;
                }
                else if(y!= null && z.left == y && y.right == x){
                    x.parent = z.parent;
                    x.right = z;
                    x.left = y;
                }
                System.out.println("Y is " + y.element);
                System.out.println("Z is " + z.element);
*/






                System.out.println(n.element);
                n = n.parent;
                continue;
            }


        }


    }


}