package codebytersdirectorysystem;

import java.io.Serializable;

abstract class User implements Serializable {

    private int memberId;
    private String firstName;
    private String lastName;
    private String middleInitial;

    public User() {
        this.memberId = 0;
        this.firstName = "Null";
        this.lastName = "Null";
        this.middleInitial = "Null";
    }

    public User(int memberId, String firstName, String lastName, String middleInitial) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
    }

    public void setMemberId(int id) {
        this.memberId = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

   public abstract void updateList();

}
