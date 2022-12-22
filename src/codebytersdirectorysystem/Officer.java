/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codebytersdirectorysystem;

public class Officer extends Member{
    private int schoolYear;
    private int memberId;
    private String position;

    public Officer(int memberId, String firstName, String lastName, char gender, String email) {
        super(memberId, firstName, lastName, gender, email);
    }


    // Getter and setter methods for the fields of the officer
    public int getSchoolYear() {
        return this.schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Override
    public int getMemberId() {
        return this.memberId;
    }

        @Override
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
