
import Small_Data.*;
import Big_Data.*;

import java.util.Scanner;


public class Main {
    public static void quickSort(int pivot){
    }



    public static void SetEINThreshold(int size) {

        System.out.println("Which ADT do you want to test out?\n1. AVL Tree\n2. Hash Table\n");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        if(choice == 1){
            AVL_Main.AVL_Main(size);
        }
        else if(choice == 2){
            Hash_Main.hash_main(size);
        }


        // determine what data types or data
        //structures will be used (i.e. a Tree, Hash Table, AVL tree, binary tree, sequence, etc.);
        /*
        if (size < 1000) {
            AVL_Main.AVL_Main(size);
        }
        else if (size > 1000 && size < 1000000) {
            //state list

            AVL_Main.AVL_Main(size);
        }
        else if (size >= 1000000) {
            //country list
        }*/
    }


    public static void main(String args[]) {

        //System.out.println("Please enter the total number of Equipment Identification Number: ");
        //Scanner in = new Scanner(System.in);
        //int size = in.nextInt();
        int size = 5;
        SetEINThreshold(size);

        //System.out.println("Please enter the total number of Equipment Identification Number: ");


    }
}
