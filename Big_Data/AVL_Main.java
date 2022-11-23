package Big_Data;

import Big_Data.All_Keys.Ordered_List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Big_Data.Big_Data_Methods.add;
import static Big_Data.Big_Data_Methods.allKeys;

public class AVL_Main {
    public static int intro_message(){

        System.out.println("Welcome! Please choose the option you want: \n"+
                "1. generate()\n" +
                "2. allKeys(ElasticERL)\n" +
                "3. add(ElasticERL,key,value)\n" +
                "4. remove(ElasticERL,key)\n" +
                "5. getValues(ElasticERL,key)\n" +
                "6. nextKey(ElasticERL,key)\n" +
                "7. prevKey(ElasticERL,key)\n" +
                "8. rangeKey(key1, key2)\n"+
                "9. Exit\n");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        return choice;
    }


    public static void AVL_Main(int size) {
        Scanner in = new Scanner (System.in);

        LinkedList big = new LinkedList();

        try {
            File myObj = new File("src/5.txt");
            //File myObj = new File("src/500000.txt");

            Scanner myReader = new Scanner(myObj);

            for (int i = 0; i < size; i++) {
                String key = myReader.nextLine();
                String value = "None";
                AVL_Entry new_entry = new AVL_Entry(key, value);
                big.addNode(new_entry);
            }
            myReader.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            //insert elements
        }
        while (true) {
            int choice = intro_message();

            if (choice == 1) {
                //generate();
            }

            else if (choice == 2) {
                //All_Keys.Ordered_List.allKeys(ElasticERL);
                //Ordered_List od = new Ordered_List();

                if(Ordered_List.head == null){
                    big.inOrder(LinkedList.head);
                    allKeys(big);
                }
                else{
                    allKeys(big);
                    big.toString();
                    System.out.println();
                }



            }
            else if (choice == 3) {
                System.out.println("Please enter the key you want to add: ");
                String key = in.next();
                System.out.println("Please enter the value you want to add to "+key+" : ");
                String value = in.next();
                AVL_Entry new_entry = new AVL_Entry(key, value);
                add(big,new_entry);
            }
            else if (choice == 4) {
                // remove(ElasticERL,key)

            } else if (choice == 5) {
                //getValues(ElasticERL,key)

            } else if (choice == 6) {//nextKey(ElasticERL,key)

                System.out.println("Please enter the key you want to look up: ");

                String s = in.next();
                //String s = "05716101";
                Big_Data_Methods.nextKey(big, s);

            }
            else if (choice == 7) {
                //prevKey(ElasticERL,key)

                System.out.println("Please enter the key you want to look up: ");

                String s = in.next();
                //String s = "05716101";
                Big_Data_Methods.prevKey(big, s);
            }
            else if (choice == 8) {
                System.out.println("Please enter the lower range (key1): ");
                String key1 = in.next();

                System.out.println("Please enter the upper range (key2): ");
                String key2 = in.next();

                Big_Data_Methods.rangeKey(key1, key2, big);
            }
        }



        }

            /*Test that the prev and next nodes work

            System.out.println("Head: "+ LinkedList.head.getElement());
            System.out.println("Head next2 prev: "+ (LinkedList.head.next).prev.getElement());
            System.out.println("Head next2: "+ LinkedList.head.next.getElement());
            System.out.println("Head next3: "+ LinkedList.head.next.next.getElement());
            System.out.println("Head next4: "+ LinkedList.head.next.next.next.getElement());
            System.out.println("Head next5: "+ LinkedList.head.next.next.next.next.getElement());

            System.out.println();

            System.out.println("Tail: "+ LinkedList.tail.getElement());
            System.out.println("Tail Prev: "+ LinkedList.tail.prev.getElement());
            System.out.println("Tail Prev2: "+ LinkedList.tail.prev.prev.getElement());
            System.out.println("Tail Prev3: "+ LinkedList.tail.prev.prev.prev.getElement());
            System.out.println("Tail Prev4: "+ LinkedList.tail.prev.prev.prev.prev.getElement());

            System.out.println();
*/

    }







