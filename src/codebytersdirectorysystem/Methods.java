package codebytersdirectorysystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Methods {

    static ArrayList<Member> mList = new ArrayList<>();
    static ArrayList<Officer> oList = new ArrayList<>();
    static String fileName =  "src/codebytersdirectorysystem/Database/users.txt";
    static Path pathToFile = Paths.get(fileName);
    static Path path = pathToFile.toAbsolutePath();
    static File files = new File(path.toString());
    // static ListIterator li;//will list the data stored in the text file

    public static void registerMember() {//method for entering data into a file
        
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
            mList.add(new Member(memberId, firstName, lastName, middleName, gender, dateOfBirth, cellphoneNumber, email));
            oos.writeObject(mList);
            oos.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void displayList(){
        if(files.isFile()){//if the file exists will continue to gather its data
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(files));
                mList = (ArrayList<Member>) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("*-----STUDENT LISTS-----*");
            //gather the object from the list and display its id, name and grade
            for(Member ob : mList){

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
    public static void addOfficer(){
        String memberId, schoolYear, position, firstName, lastName, middleInitial;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter id: ");
        memberId = scan.nextLine();
        
        System.out.print("Enter first name: ");
        firstName = scan.nextLine();

        System.out.print("Enter last name: ");
        lastName = scan.nextLine();

        System.out.println("Enter middle initial");
        middleInitial = scan.nextLine();

        System.out.print("Enter schoolyear: ");
        schoolYear = scan.nextLine();

        System.out.print("Enter position: ");
        position = scan.nextLine();
        //Stores the data from user input to a file
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(files));
            oList.add(new Officer(memberId, firstName, lastName, middleInitial, schoolYear, position));
            // studentList();
            oos.writeObject(oList);
            oos.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void displayOfficer(){
        if(files.isFile()){//if the file exists will continue to gather its data
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(files));
                oList = (ArrayList<Officer>) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("*-----STUDENT LISTS-----*");
            //gather the object from the list and display its id, name and grade
            for(Officer ob : oList){

                System.out.println("Member:");
                System.out.println("Id: " + ob.getMemberId());
                System.out.println("School Year: " + ob.getSchoolYear());
                System.out.println("Name: " + ob.getName());
                System.out.println("Position: " + ob.getPosition());
                System.out.println("*----------------------*");
            }
        }
    }
}

