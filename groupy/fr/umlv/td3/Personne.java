/**
 * Created on 11 févr. 2005
 *@author jsie
 */
package fr.umlv.td3;


public class Personne implements Contact{
    private String firstName;
    private String lastName;
    private String address;
    private String number;
    
    public Personne(String firstName,String lastName,String address,String number){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.number = number;
    }
    
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getName(){
        return firstName+lastName;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getNumber(){
        return number;
    } 
    
    public void setAdress(String address){
        this.address = address;
    }
    
    public void setNumber(String number){
        this.number = number;
    }
    
}
