
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

    public Member(int memberId, String firstName, String lastName, char middleInitial, char gender, Date dateOfBirth, String cellphoneNumber, String email) {
        super(memberId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setMiddleInitial(char middleInitial){
        this.middleInitial = middleInitial;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public void setCellphoneNumber(String cellphoneNumber){
        this.cellphoneNumber = cellphoneNumber;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public char getMiddleInitial(){
        return middleInitial;
    }
    public char getGender(){
        return gender;
    }
    public Date getDateOfBirth(){
        return dateOfBirth;
    }
    public String getCellphoneNumber(){
        return cellphoneNumber;
    }
    public String getEmail(){
        return email;
    }
    
}