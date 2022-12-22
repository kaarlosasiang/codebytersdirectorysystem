/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codebytersdirectorysystem;

public class Officer extends User{
    private int schoolYear;
    private String position;

    public Officer(String memberId, String firstName, String lastName, char gender, String email, int schoolYear, String position) {
        super(memberId);
        this.schoolYear = schoolYear;
        this.position = position;
    }


    // Getter and setter methods for the fields of the officer
    public void setSchoolYear(int schoolYear){
        this.schoolYear = schoolYear;
    }
    public void setPosition(String position){
        this.position = position;
    }
}
