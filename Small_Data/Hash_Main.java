package Small_Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Hash_Main {

    public static Hash_Linked_List [] hash_arr = new Hash_Linked_List[5];

    public static void compression_function(String hash_function_value, Hash_Entry new_entry){
        int idx = Integer.parseInt(hash_function_value)-1;


        if(hash_arr[idx] ==null){

            Hash_Linked_List hash_list = new Hash_Linked_List();
            Hash_Linked_List.Node new_node = new Hash_Linked_List.Node(new_entry);
            hash_list.head = new_node;
            hash_list.tail = new_node;
            hash_arr[idx] = hash_list;
        }
        else{
            Hash_Linked_List.Node new_node = new Hash_Linked_List.Node(new_entry);
            new_node.prev = hash_arr[idx].tail;
            hash_arr[idx].tail.next = new_node;
            hash_arr[idx].tail = new_node;

        }


    }

    public static void hash_function(Hash_Entry new_entry){
        String hash_function_value = new_entry.key.substring(0, 4);
        //System.out.println(hash_function_value);
        compression_function(hash_function_value, new_entry);

    }

    public static void hash_main(int size){
        System.out.println("This is a hash table implementation!");

        //Hash function for 1st 4 digits

        try {
            File myObj = new File("src/5.txt");
            //File myObj = new File("src/500000.txt");
            Scanner myReader = new Scanner(myObj);

            for (int i = 0; i< size; i++){
                String key = myReader.nextLine();
                String value = "";
                Hash_Entry new_entry = new Hash_Entry(key, value);
                hash_function(new_entry);
            }

            for(int i = 0;i<hash_arr.length;i++){
                System.out.println(i+" "+hash_arr[i].toString());
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            //insert elements
        }



    }
}
