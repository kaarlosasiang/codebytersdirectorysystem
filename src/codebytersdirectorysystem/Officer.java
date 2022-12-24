/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codebytersdirectorysystem;

public class Officer extends User{
    private String schoolYear;
    private String position;

    public Officer(String memberId, String firstName, String lastName, String middleInitial, String schoolYear, String position) {
        super(memberId, firstName, lastName, middleInitial);
        this.schoolYear = schoolYear;
        this.position = position;
    }


    // Getter and setter methods for the fields of the officer
    public void setSchoolYear(String schoolYear){
        this.schoolYear = schoolYear;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public String getSchoolYear(){
        return schoolYear;
    }
    public String getPosition(){
        return  position;
    }
    //returns name
    public String getName(){
       String name = getFirstName() + " " + getMiddleInitial() + " " +getLastName();
       return name;
    }
    
}
