package codebytersdirectorysystem;

import java.util.Scanner;

public class CodebytersDirectorySystem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean isContinue = true;
        do {
            //Shows the system menu
            System.out.println("""

                                *----------------System Menu---------------*
                                a. Add list
                                b. Display list
                                c. Search list
                                d. Delete list
                                e. Update list
                                f. Exit
                                """);
            System.out.print("Enter option: ");
            char operator = scan.next().charAt(0);

            switch (operator) {
                case 'a' ->
                    Methods.addList();
                case 'b' ->
                    Methods.displayList();
                case 'c' ->
                    Methods.searchList();   
                case 'd' ->
                    Methods.deleteList();
                case 'e' ->
                    Methods.updateList();
                case 'f' -> {
                    isContinue = false;
                    System.out.println("Program Terminated");
                }
                default ->
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
        } while (isContinue);
    }
    
}
