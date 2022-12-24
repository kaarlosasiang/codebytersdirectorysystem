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
                case 'a' ->
                    Member.addMember();
                case 'b' ->
                    Officer.addOfficer();
                case 'c' ->
                    Member.displayMembers();
                case 'd' ->
                    Officer.displayOfficers();
                case 'e' ->
                    Member.searchMember();
                case 'f' ->
                    Officer.searchOfficer();
                case 'g' -> {
                    isContinue = false;
                    System.out.println("Program Terminated");
                }
                default ->
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
        } while (isContinue);
    }
    
}
