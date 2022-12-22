
package codebytersdirectorysystem;

public class Member {
    private int memberId;
    private String firstName;
    private String lastName;
    private char gender;

    private String email;


    // Constructor to initialize the fields of the member
    public Member(int memberId, String firstName, String lastName, char gender, String email) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    // Getter and setter methods for the fields of the member
    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
