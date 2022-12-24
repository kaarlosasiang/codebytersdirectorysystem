package codebytersdirectorysystem;

import java.util.Scanner;

public class Methods {

    public static void addList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                        Enter:
                        a. Members
                        b. Officers

                        """);
        String option = sc.nextLine().toLowerCase();

        switch (option) {
            case "a" ->
                Member.addMember();
            case "b" ->
                Officer.addOfficer();
        }
    }

    public static void displayList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                            Enter:
                            a. Members
                            b. Female Members
                            c. Male Members
                            d. Officers
                            """);
        String option = sc.nextLine().toLowerCase();

        switch (option) {
            case "a" ->
                Member.displayMembers();
            case "b" ->
                Member.displayFemaleMembers();
            case "c" ->
                Member.displayMaleMembers();
            case "d" ->
                Officer.displayOfficers();
        }
    }

    public static void searchList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                            Enter:
                            a. Member
                            b. Officer
                            """);
        String option = sc.nextLine().toLowerCase();

        switch (option) {
            case "a" ->
                Member.searchMember();
            case "b" ->
                Officer.searchOfficer();
        }
    }
    public static void updateList() {
        //Instantiate objects to access abstract methods
        Member member = new Member();
        Officer officer = new Officer();
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                            Enter:
                            a. Member
                            b. Officer
                            """);
        String option = sc.nextLine().toLowerCase();

        switch (option) {
            case "a" ->
                member.updateList();
            case "b" ->
                officer.updateList();
        }
    }
}
