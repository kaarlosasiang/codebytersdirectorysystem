package codebytersdirectorysystem;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import static java.nio.file.StandardOpenOption.APPEND;

public class Member extends User {

    private String gender;
    private String dateOfBirth;
    private String cellphoneNumber;
    private String email;
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    //Initialize and array list for storing members
    private static ArrayList<Member> list = new ArrayList<Member>();
    //Member constructor
    public Member(int memberId, String firstName, String lastName, String middleInitial, String gender, String dateOfBirth, String cellphoneNumber, String email) {
        super(memberId, firstName, lastName, middleInitial);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
    }
    //getters and setters for member class
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void updateList() {
        // TODO Auto-generated method stub
        
    }
    //
    public String toString(){
        return getMemberId() + "," + getFirstName() + "," + getMiddleInitial() + "," + getLastName() + "," + gender + "," + dateOfBirth + "," + cellphoneNumber + "," + email;
    }
    //Add member method
    public static void addMember() {
        String firstName, middleInitial, lastName, gender, dateOfBirth, cellNumber, email;
        int id;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("First Name: ");
        firstName = sc.nextLine();

        System.out.print("Last Name: ");
        lastName = sc.nextLine();

        System.out.print("Middle Initial: ");
        middleInitial = sc.nextLine();

        System.out.print("Gender: ");
        gender = sc.nextLine();

        System.out.print("Date of Birth: ");
        dateOfBirth = sc.nextLine();

        System.out.print("Cellphone Number: ");
        cellNumber = sc.nextLine();

        System.out.print("Email: ");
        email = sc.nextLine();
        try {
            Path path = Paths.get("src/codebytersdirectorysystem/Database/members.txt").toAbsolutePath();
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
                    + middleInitial + "," + gender + "," + dateOfBirth + ","
                    + cellNumber + "," + email);
            writer.newLine();
            System.out.println(ANSI_GREEN + "Member Added!" + ANSI_RESET);
            writer.close();
            output.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    //display member method
    public static void displayMembers(){

        String firstName, middleInitial, lastName, gender, dateOfBirth, cellNumber, email;
        int id;
        
        try {
            Path path = Paths.get("src/codebytersdirectorysystem/Database/members.txt").toAbsolutePath();
            Scanner sc = new Scanner(path);
            StringTokenizer token = null;

            while(sc.hasNextLine()){
                token = new StringTokenizer(sc.nextLine(), ",");
                id = Integer.parseInt(token.nextToken());
                firstName = token.nextToken();
                lastName = token.nextToken();
                middleInitial = token.nextToken();
                gender = token.nextToken();
                dateOfBirth = token.nextToken();
                cellNumber = token.nextToken();
                email = token.nextToken();
                Member member = new Member(id, firstName, lastName, middleInitial, gender, dateOfBirth, cellNumber, email);
                list.add(member);
            }
          
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //will iterate all objects in the array
        System.out.println("*-----MEMBERS-----*");
        for(Member member : list){
            System.out.println("");
            System.out.println("ID: " + member.getMemberId());
            System.out.println("Name: " + member.getFirstName() + " " + member.getMiddleInitial() + " " + member.getLastName());
            System.out.println("Gender: " + member.getGender());
            System.out.println("Date of Birth: " + member.getDateOfBirth());
            System.out.println("Cellphone: " + member.getCellphoneNumber());
            System.out.println("Email: " + member.getEmail());

        }
    }
    public static void searchMember(){
      
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        int searchId = sc.nextInt();
        
      

         // Flag to track if the ID was found
         boolean idFound = false;
 
         try {
            //File directory
            Path path = Paths.get("src/codebytersdirectorysystem/Database/members.txt").toAbsolutePath();
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
                    System.out.println("*-----MEMBER INFO-----*");
                    System.out.println("");
                    System.out.println("ID: " + fields[0]);
                    System.out.println("Name: " + fields[1] + " " + fields[3] + ". " + fields[2]);
                    System.out.println("Gender: " + fields[4]);
                    System.out.println("Date of Birth: " + fields[5]);
                    System.out.println("Cellphone Number: " + fields[6]);
                    System.out.println("Email: " + fields[7]);

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
        
    }

}
