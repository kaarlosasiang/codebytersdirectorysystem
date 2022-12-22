package codebytersdirectorysystem;

import java.util.Scanner;

public class CodebytersDirectorySystem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String loop = "yes";
        do {
            //Shows the system menu
            System.out.println("""
                                *----Codebyters Officers and Members Directory System----*
                            
                                System Menu
                                *--------------------------------------*  
                                a. Register
                                b. View Members
                                c. Exit
                                """);
            System.out.print("Enter option: ");
            char operator = scan.next().charAt(0);

            switch (operator) {
                case 'a' ->
                    System.out.println("Register Position");
                case 'b' ->
                    System.out.println("View Member");
                case 'c' -> {
                    loop = "no";
                    System.out.println("Program Terminated");
                }
                default ->
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
        } while ("yes".equals(loop));
    }

}
