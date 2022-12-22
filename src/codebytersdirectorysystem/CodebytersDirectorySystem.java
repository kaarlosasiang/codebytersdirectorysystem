package codebytersdirectorysystem;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.APPEND;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

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
//                    System.out.println("Register Position");
                    viewMembers();
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

    public static void viewMembers() {

        ArrayList<Member> members = new ArrayList<Member>();

        try {
            String fileName = "src/codebytersdirectorysystem/Database/users.txt";
            Path pathToFile = Paths.get(fileName);
            Path path = pathToFile.toAbsolutePath();

            OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            InputStream inputs = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputs));

            String line, id, fName, lName, contactNum, mName, gender, bbirth, emailAdd;
            while ((line = reader.readLine()) != null) {
                String[] users = line.split(",");

                StringTokenizer stn = new StringTokenizer(line);
                id = stn.nextToken();
                fName = stn.nextToken();
                lName = stn.nextToken();
                mName = stn.nextToken();
                gender = stn.nextToken();
                bbirth = stn.nextToken();

                Date birthdate = Date.valueOf(bbirth);
                contactNum = stn.nextToken();
                emailAdd = stn.nextToken();

                System.out.println(id + "," + fName + "," + lName + "," + mName + "," + gender + "," + bbirth);

//                    for(int i = 0; i < users.length; i++){
//                        System.out.println(users[i]);
//                    }
                Member member = new Member(id, fName, lName, mName, gender, birthdate, contactNum,emailAdd);

                members.add(member);
//                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
