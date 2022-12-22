
package codebytersdirectorysystem;

import java.sql.Date;

public class Member extends User{
    private String firstName;
    private String lastName;
    private char middleInitial;
    private char gender;
    private Date dateOfBirth;
    private String cellphoneNumber;
    private String email;

    public Member(int memberId, String firstName, String lastName, char middleInitial, char gender, Date dateOfBirDate, String cellphoneNumber, String email) {
        super(memberId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.gender = gender;
        this.dateOfBirth = dateOfBirDate;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
    }
    
}