package codebytersdirectorysystem;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Methods {

    static ArrayList<Member> list = new ArrayList<>();
    static String fileName =  "src/codebytersdirectorysystem/Database/users.txt";
    static Path pathToFile = Paths.get(fileName);
    static Path path = pathToFile.toAbsolutePath();
    static File files = new File(path.toString());
    //file in which the data will be stored
    static  ObjectInputStream ois;//will store the user inputted data into the file
    static ListIterator li;//will list the data stored in the text file

    public static void register() {//method for entering data into a file
        
        String memberId, firstName, lastName, middleName, gender, dateOfBirth, cellphoneNumber, email;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter id: ");
        memberId = scan.nextLine();

        System.out.print("Enter first name: ");
        firstName = scan.nextLine();

        System.out.print("Enter last name: ");
        lastName = scan.nextLine();

        System.out.print("Enter middle inititial: ");
        middleName = scan.nextLine();

        System.out.print("Enter gender: ");
        gender = scan.nextLine();

        System.out.print("Enter date of birth: ");
        dateOfBirth = scan.nextLine();

        System.out.print("Enter cellphone number: ");
        cellphoneNumber = scan.nextLine();

        System.out.print("Enter email: ");
        email = scan.nextLine();
        //Stores the data from user input to a file
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(files));
            list.add(new Member(memberId, firstName, lastName, middleName, gender, dateOfBirth, cellphoneNumber, email));
            // studentList();
            oos.writeObject(list);
            oos.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void displayList(){
        if(files.isFile()){//if the file exists will continue to gather its data
            try {
                ois = new ObjectInputStream(new FileInputStream(files));
                list = (ArrayList<Member>) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("*-----STUDENT LISTS-----*");
            //gather the object from the list and display its id, name and grade
            for(Member ob : list){

                System.out.println("Member:");
                System.out.println("Id: " + ob.getMemberId());
                System.out.println("First Name: " + ob.getFirstName());
                System.out.println("Last Name: " + ob.getLastName());
                System.out.println("Middle Initial: " + ob.getMiddleInitial());
                System.out.println("Gender: " + ob.getGender());
                System.out.println("Birthdate: " + ob.getDateOfBirth());
                System.out.println("Cellphone: " + ob.getCellphoneNumber());
                System.out.println("Email: " + ob.getEmail());
                System.out.println("*----------------------*");
            }
        }
        else//file not found exemption
            System.out.println("File not found!");
    }
}
