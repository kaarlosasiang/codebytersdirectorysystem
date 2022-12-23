
package codebytersdirectorysystem;

import java.io.Serializable;

abstract class User implements Serializable{
    private String memberId;

    public User(String memberId2){
        this.memberId = memberId2;
    }
    public void setMemberId(String memberId){
        this.memberId = memberId;
    }
    public String getMemberId(){
        return memberId;
    }
  
}
