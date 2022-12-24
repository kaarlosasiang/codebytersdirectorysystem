package codebytersdirectorysystem;

import java.util.Scanner;

public class Methods {
    public static void addList(){
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                        Enter:
                        a. Member
                        b. Officer
                        """);
        String option = sc.nextLine().toLowerCase();

        switch(option){
            case "a" ->
                Member.addMember();
            case "b" -> 
                Officer.addOfficer();
        }
    }
    public static void displayList(){
            Scanner sc = new Scanner(System.in);
            System.out.print("""
                            Enter:
                            a. Member
                            b. Officer
                            """);
            String option = sc.nextLine().toLowerCase();

            switch(option){
                case "a" ->
                    Member.displayMembers();
                case "b" -> 
                    Officer.displayOfficers();
            }
    }
    public static void searchList(){
        Scanner sc = new Scanner(System.in);
            System.out.print("""
                            Enter:
                            a. Member
                            b. Officer
                            """);
            String option = sc.nextLine().toLowerCase();

            switch(option){
                case "a" ->
                    Member.searchMember();
                case "b" -> 
                    Officer.searchOfficer();
            }
    }
    public static void deleteList(){
        Member member = new Member(0, null, null, null, null, null, null, null);
        Scanner sc = new Scanner(System.in);
            System.out.print("""
                            Enter:
                            a. Member
                            b. Officer
                            """);
            String option = sc.nextLine().toLowerCase();

            switch(option){
                case "a" ->
                    member.deleteList();
                case "b" -> 
                    System.out.println("Sample");
            }
        
    }
    public static void updateList(){
        Scanner sc = new Scanner(System.in);
            System.out.print("""
                            Enter:
                            a. Member
                            b. Officer
                            """);
            String option = sc.nextLine().toLowerCase();

            switch(option){
                case "a" ->
                    System.out.println("Sample");
                case "b" -> 
                    System.out.println("Sample");
            }
    }
}
