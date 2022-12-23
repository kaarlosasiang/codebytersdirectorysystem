package codebytersdirectorysystem;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sample {
    private static final OpenOption APPEND = null;

    public static void makeReservations() {
        String filePath =  "src/codebytersdirectorysystem/Database/users.txt";
        Path pathToFile = Paths.get(filePath);
        Scanner input = new Scanner(System.in);
       

//      declaration for the variables with no assigned values yet
        String name, lname, date, time;
        int adults, childrens, subtotal, id = 0;

//        User input for the reservation details

        System.out.println("Enter First name: ");
        name = input.next();

        System.out.println("Enter Last name: ");
        lname = input.next();

        System.out.println("Enter Date eg.(May/29/2022): ");
        date = input.next();

        System.out.println("Enter Time eg. (10:00am/pm): ");
        time = input.next();

        System.out.println("Enter no. of Adults: ");
        adults = input.nextInt();

        System.out.println("Enter no. of Childrens: ");
        childrens = input.nextInt();

        int numAdults, numChildrens;

//        Number of adults and childrens calculated
        numAdults = adults * 500;
        numChildrens = childrens * 300;

//        Subtotal of adults + children
        subtotal = numAdults + numChildrens;

        try {
            //         The purpose of the block of code is to store the data to the reservations text file
            Path path = pathToFile.toAbsolutePath();
            File files = new File(path.toString());
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            InputStream inputs = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputs));

            boolean found = false;
            int tableNumber;
            String _temp = null;

            while ((_temp = reader.readLine()) != null) {

//                To get the separated data using space
                String[] accounts = _temp.split(" ");
                StringTokenizer stn = new StringTokenizer(_temp);
                tableNumber = Integer.parseInt(stn.nextToken());

                // variable for auto increment id/number
                id = tableNumber + 1;

            }

            writer.write(id + " " + date + " " + time + " " + name + "-" + lname + " " + adults + " " + childrens + " " + subtotal);
            writer.newLine();
            System.out.println("Reservation Created");
            
            writer.close();
            output.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    
    }
}
