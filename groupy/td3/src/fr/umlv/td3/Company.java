/**
 * Created on 11 févr. 2005
 *@author jsie
 */
package fr.umlv.td3;


import java.util.Collection;


import java.util.Iterator;
import java.util.List;

public class Company implements Contact{
    private String name;
    private String address;
    private String sirepNumber;
    private List collaborators;
    
    public Company(String name,String address,String sirepNumber,List collaborators){
        this.name = name;
        this.address = address;
        this.sirepNumber = sirepNumber;
        this.collaborators = collaborators;
    }

    /**
     * 
     * @uml.property name="name"
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @uml.property name="address"
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @uml.property name="sirepNumber"
     */
    public String getSirepNumber() {
        return sirepNumber;
    }

    /**
     * 
     * @uml.property name="collaborators"
     */
    public List getCollaborators() {
        return collaborators;
    }

    /**
     *  
     * @uml.property name="person"
     * @uml.associationEnd inverse="company:fr.umlv.td3.Person" multiplicity="(0 1)"
     */
    private Person person;

    /**
     *  
     * @uml.property name="person"
     */
    public Person getPerson() {
        return person;
    }

    /**
     *  
     * @uml.property name="person"
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     *  
     * @uml.property name="person1"
     * @uml.associationEnd inverse="company1:fr.umlv.td3.Person" multiplicity="(1 -1)"
     */
    private Collection person1;

    /**
     * 
     * @uml.property name="person1"
     */
    public void setPerson1(java.util.Collection value) {
        person1 = value;
    }

    /**
     * 
     * @uml.property name="person1"
     */
    public Iterator person1Iterator() {
        return person1.iterator();
    }

    /**
     * 
     * @uml.property name="person1"
     */
    public boolean addPerson1(fr.umlv.td3.Person element) {
        return person1.add(element);
    }

    /**
     * 
     * @uml.property name="person1"
     */
    public boolean removePerson1(fr.umlv.td3.Person element) {
        return person1.remove(element);
    }

    /**
     * 
     * @uml.property name="person1"
     */
    public boolean isPerson1Empty() {
        return person1.isEmpty();
    }

    /**
     * 
     * @uml.property name="person1"
     */
    public void clearPerson1() {
        person1.clear();
    }

    /**
     * 
     * @uml.property name="person1"
     */
    public boolean containsPerson1(fr.umlv.td3.Person element) {
        return person1.contains(element);
    }

    /**
     * 
     * @uml.property name="person1"
     */
    public boolean containsAllPerson1(Collection elements) {
        return person1.containsAll(elements);
    }

    /**
     * 
     * @uml.property name="person1"
     */
    public int person1Size() {
        return person1.size();
    }

    /**
     * 
     * @uml.property name="person1"
     */
    public fr.umlv.td3.Person[] person1ToArray() {
        return (fr.umlv.td3.Person[]) person1
            .toArray(new fr.umlv.td3.Person[person1.size()]);
    }

    /**
     *  
     * @uml.property name="person2"
     * @uml.associationEnd inverse="company2:fr.umlv.td3.Person" multiplicity="(1 -1)"
     */
    private Collection person2;

    /**
     * 
     * @uml.property name="person2"
     */
    public void setPerson2(java.util.Collection value) {
        person2 = value;
    }

    /**
     * 
     * @uml.property name="person2"
     */
    public Iterator person2Iterator() {
        return person2.iterator();
    }

    /**
     * 
     * @uml.property name="person2"
     */
    public boolean addPerson2(fr.umlv.td3.Person element) {
        return person2.add(element);
    }

    /**
     * 
     * @uml.property name="person2"
     */
    public boolean removePerson2(fr.umlv.td3.Person element) {
        return person2.remove(element);
    }

    /**
     * 
     * @uml.property name="person2"
     */
    public boolean isPerson2Empty() {
        return person2.isEmpty();
    }

    /**
     * 
     * @uml.property name="person2"
     */
    public void clearPerson2() {
        person2.clear();
    }

    /**
     * 
     * @uml.property name="person2"
     */
    public boolean containsPerson2(fr.umlv.td3.Person element) {
        return person2.contains(element);
    }

    /**
     * 
     * @uml.property name="person2"
     */
    public boolean containsAllPerson2(Collection elements) {
        return person2.containsAll(elements);
    }

    /**
     * 
     * @uml.property name="person2"
     */
    public int person2Size() {
        return person2.size();
    }

    /**
     * 
     * @uml.property name="person2"
     */
    public fr.umlv.td3.Person[] person2ToArray() {
        return (fr.umlv.td3.Person[]) person2
            .toArray(new fr.umlv.td3.Person[person2.size()]);
    }

}
