/**
 * Created on 11 févr. 2005
 *@author jsie
 */
package fr.umlv.td3;

import java.util.List;

public class Company implements Contact{
    private String name;
    private String address;
    private String sirepNumber;
    private List<Personne> collaborators;
    
    public Company(String name,String address,String sirepNumber,List<Personne> collaborators){
        this.name = name;
        this.address = address;
        this.sirepNumber = sirepNumber;
        this.collaborators = collaborators;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getSirepNumber(){
        return sirepNumber;
    }
    
    public List<Personne> getCollaborators(){
        return collaborators;
    }
}
