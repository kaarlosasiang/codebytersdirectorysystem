/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codebytersdirectorysystem;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.nio.file.StandardOpenOption.APPEND;

public class Officer extends User {

    private String schoolYear;
    private String position;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static Scanner x;
    //Initialize and array list for storing members
    private static ArrayList<Officer> list = new ArrayList<Officer>();

    public Officer(int memberId, String firstName, String lastName, String middleInitial, String schoolYear, String position) {
        super(memberId, firstName, lastName, middleInitial);
        this.schoolYear = schoolYear;
        this.position = position;
    }

    // Getter and setter methods for the fields of the officer
    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public String getPosition() {
        return position;
    }

//    @Override
    public static void updateList() {
        Scanner sc = new Scanner(System.in);
        String tempFile = "src/codebytersdirectorysystem/Database/temp.txt";
        String filePath = "src/codebytersdirectorysystem/Database/officers.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);

        String editTerm, newFirstName, newLastName, newMiddleInitial, newSchoolYear, newPosition;
        System.out.print("Enter ID: ");
        editTerm = sc.nextLine();
        System.out.print("Enter New First Name: ");
        newFirstName = sc.nextLine();
        System.out.print("Enter New Last Name: ");
        newLastName = sc.nextLine();
        System.out.print("Enter New Middle Initial: ");
        newMiddleInitial = sc.nextLine();
        System.out.print("Enter New School Year: ");
        newSchoolYear = sc.nextLine();
        System.out.print("Enter New Position: ");
        newPosition = sc.nextLine();

        String id = "";
        String firstName = "";
        String lastName = "";
        String middleInitial = "";
        String schoolYear = "";
        String position = "";

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                id = x.next();
                firstName = x.next();
                lastName = x.next();
                middleInitial = x.next();
                schoolYear = x.next();
                position = x.next();

                if (id.equals(editTerm)) {
                    pw.println(id + "," + newFirstName + "," + newLastName + "," + newMiddleInitial + "," + newSchoolYear + "," + newPosition);
                } else {
                    pw.println(id + "," + firstName + "," + lastName + "," + middleInitial + "," + schoolYear + "," + position);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);
            System.out.println("Officer Successfully Edited!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public String toString() {
        return getMemberId() + "," + getFirstName() + "," + getMiddleInitial() + "," + getLastName() + "," + schoolYear + "," + position;
    }

    //Add officer method
    public static void addOfficer() {
        String firstName, middleInitial, lastName, schoolYear, position;
        int id;

        Scanner sc = new Scanner(System.in);
        System.out.print("First Name: ");
        firstName = sc.nextLine();

        System.out.print("Last Name: ");
        lastName = sc.nextLine();

        System.out.print("Middle Initial: ");
        middleInitial = sc.nextLine();

        System.out.print("Schoolyear: ");
        schoolYear = sc.nextLine();

        System.out.print("Position: ");
        position = sc.nextLine();

        try {
            Path path = Paths.get("src/codebytersdirectorysystem/Database/officers.txt").toAbsolutePath();
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            InputStream inputs = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputs));

            String line;
            id = 1;
            while ((line = reader.readLine()) != null) {
                StringTokenizer stn = new StringTokenizer(line, ",");
                String[] members = line.split(","); // returns an array of user data from the text file

                id = Integer.parseInt(members[0]);
                id++;

            }

            writer.write(id + "," + firstName + "," + lastName + ","
                    + middleInitial + "," + schoolYear + "," + position);
            writer.newLine();
            System.out.println(ANSI_GREEN + "Member Added!" + ANSI_RESET);
            writer.close();
            output.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //display officer
    public static void displayOfficers() {

        String firstName, middleInitial, lastName, schoolYear, position;
        int id;

        try {
            Path path = Paths.get("src/codebytersdirectorysystem/Database/officers.txt").toAbsolutePath();
            Scanner sc = new Scanner(path);
            StringTokenizer token = null;

            while (sc.hasNextLine()) {
                token = new StringTokenizer(sc.nextLine(), ",");
                id = Integer.parseInt(token.nextToken());
                firstName = token.nextToken();
                lastName = token.nextToken();
                middleInitial = token.nextToken();
                schoolYear = token.nextToken();
                position = token.nextToken();

                Officer officer = new Officer(id, firstName, lastName, middleInitial, schoolYear, position);
                list.add(officer);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //will iterate all objects in the array
        System.out.println("*-----OFFICERS-----*");
        for (Officer officer : list) {
            System.out.println("");
            System.out.println("ID: " + officer.getMemberId());
            System.out.println("Name: " + officer.getFirstName() + " " + officer.getMiddleInitial() + " " + officer.getLastName());
            System.out.println("School Year: " + officer.getSchoolYear());
            System.out.println("Position: " + officer.getPosition());
        }
    }

    //Search method
    public static void searchOfficer() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        int searchId = sc.nextInt();

        // Flag to track if the ID was found
        boolean idFound = false;

        try {
            //File directory
            Path path = Paths.get("src/codebytersdirectorysystem/Database/officers.txt").toAbsolutePath();
            InputStream inputs = Files.newInputStream(path);
            // Open the file for reading
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputs));

            // Read each line of the file
            String line = reader.readLine();
            while (line != null) {
                // Split the line into fields separated by a comma
                String[] fields = line.split(",");

                // Check if the first field (the ID) matches the search ID
                if (fields[0].equals(Integer.toString(searchId))) {
                    // ID was found, set the flag and print the line
                    idFound = true;
                    System.out.println("*-----OFFICER INFO-----*");
                    System.out.println("");
                    System.out.println("ID: " + fields[0]);
                    System.out.println("Name: " + fields[1] + " " + fields[3] + ". " + fields[2]);
                    System.out.println("School Year: " + fields[4]);
                    System.out.println("Position: " + fields[5]);

                }

                // Read the next line
                line = reader.readLine();
            }

            // Close the file
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // If the ID was not found, print a message
        if (!idFound) {
            System.out.println("ID not found in file.");
        }

    }

    @Override
    public void deleteList() {
        // TODO Auto-generated method stub

    }
}
