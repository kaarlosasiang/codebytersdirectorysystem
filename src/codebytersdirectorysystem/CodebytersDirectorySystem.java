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
                                a. Register member
                                b. Add officer
                                c. Display members
                                d. Display officers
                                e. Search Members 
                                f. Search Officer
                                g. Exit
                                """);
            System.out.print("Enter option: ");
            char operator = scan.next().charAt(0);

            switch (operator) {
                case 'a' -> Methods.registerMember();
                case 'b' -> Methods.addOfficer();
                case 'c' -> Methods.displayMembers();
                case 'd' -> Methods.displayOfficer();
                // case 'e' -> Methods.searchMembers();
                case 'f' -> System.out.println("Sample");
                case 'g' -> {
                    loop = "no";
                    System.out.println("Program Terminated");
                }
                default ->
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
        } while ("yes".equals(loop));
    }  

}
