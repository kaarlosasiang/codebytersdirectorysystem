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

import javax.swing.plaf.synth.Region;

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
                case 'a' -> Methods.register();
                case 'b' -> Methods.displayList();
                case 'c' -> {
                    loop = "no";
                    System.out.println("Program Terminated");
                }
                default ->
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
        } while ("yes".equals(loop));
    }  

}
