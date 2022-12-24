package codebytersdirectorysystem;


public class Member extends User {

    private String gender;
    private String dateOfBirth;
    private String cellphoneNumber;
    private String email;

    public Member(String memberId, String firstName, String lastName, String middleInitial, String gender, String dateOfBirth, String cellphoneNumber, String email) {
        super(memberId, firstName, lastName, middleInitial);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
    }

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

}
