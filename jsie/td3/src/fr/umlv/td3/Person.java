/**
 * Created on 11 févr. 2005
 *@author jsie
 */
package fr.umlv.td3;



import java.util.Collection;



import java.util.Iterator;



public class Person implements Contact{
    private String firstName;
    private String lastName;
    private String address;
    private String number;
    
    public Person(String firstName,String lastName,String address,String number){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.number = number;
    }

    /**
     * 
     * @uml.property name="firstName"
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @uml.property name="lastName"
     */
    public String getLastName() {
        return lastName;
    }

    
    public String getName(){
        return firstName+lastName;
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
     * @uml.property name="number"
     */
    public String getNumber() {
        return number;
    }
 
    
    public void setAdress(String address){
        this.address = address;
    }

    /**
     * 
     * @uml.property name="number"
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     *  
     * @uml.property name="company"
     * @uml.associationEnd inverse="person:fr.umlv.td3.Company" multiplicity="(1 -1)"
     */
    private Collection company;

    /**
     * 
     * @uml.property name="company"
     */
    public void setCompany(java.util.Collection value) {
        company = value;
    }

    /**
     * 
     * @uml.property name="company"
     */
    public Iterator companyIterator() {
        return company.iterator();
    }

    /**
     * 
     * @uml.property name="company"
     */
    public boolean addCompany(fr.umlv.td3.Company element) {
        return company.add(element);
    }

    /**
     * 
     * @uml.property name="company"
     */
    public boolean removeCompany(fr.umlv.td3.Company element) {
        return company.remove(element);
    }

    /**
     * 
     * @uml.property name="company"
     */
    public boolean isCompanyEmpty() {
        return company.isEmpty();
    }

    /**
     * 
     * @uml.property name="company"
     */
    public void clearCompany() {
        company.clear();
    }

    /**
     * 
     * @uml.property name="company"
     */
    public boolean containsCompany(fr.umlv.td3.Company element) {
        return company.contains(element);
    }

    /**
     * 
     * @uml.property name="company"
     */
    public boolean containsAllCompany(Collection elements) {
        return company.containsAll(elements);
    }

    /**
     * 
     * @uml.property name="company"
     */
    public int companySize() {
        return company.size();
    }

    /**
     * 
     * @uml.property name="company"
     */
    public fr.umlv.td3.Company[] companyToArray() {
        return (fr.umlv.td3.Company[]) company
            .toArray(new fr.umlv.td3.Company[company.size()]);
    }

    /**
     *  
     * @uml.property name="company1"
     * @uml.associationEnd inverse="person1:fr.umlv.td3.Company" multiplicity="(0 1)"
     */
    private Company company1;

    /**
     *  
     * @uml.property name="company1"
     */
    public Company getCompany1() {
        return company1;
    }

    /**
     *  
     * @uml.property name="company1"
     */
    public void setCompany1(Company company1) {
        this.company1 = company1;
    }

    /**
     *  
     * @uml.property name="command"
     * @uml.associationEnd inverse="person:fr.umlv.td3.Command" multiplicity="(0 -1)"
     */
    private Collection command;

    /**
     * 
     * @uml.property name="command"
     */
    public void setCommand(java.util.Collection value) {
        command = value;
    }

    /**
     * 
     * @uml.property name="command"
     */
    public Iterator commandIterator() {
        return command.iterator();
    }

    /**
     * 
     * @uml.property name="command"
     */
    public boolean addCommand(fr.umlv.td3.Command element) {
        return command.add(element);
    }

    /**
     * 
     * @uml.property name="command"
     */
    public boolean removeCommand(fr.umlv.td3.Command element) {
        return command.remove(element);
    }

    /**
     * 
     * @uml.property name="command"
     */
    public boolean isCommandEmpty() {
        return command.isEmpty();
    }

    /**
     * 
     * @uml.property name="command"
     */
    public void clearCommand() {
        command.clear();
    }

    /**
     * 
     * @uml.property name="command"
     */
    public boolean containsCommand(fr.umlv.td3.Command element) {
        return command.contains(element);
    }

    /**
     * 
     * @uml.property name="command"
     */
    public boolean containsAllCommand(Collection elements) {
        return command.containsAll(elements);
    }

    /**
     * 
     * @uml.property name="command"
     */
    public int commandSize() {
        return command.size();
    }

    /**
     * 
     * @uml.property name="command"
     */
    public fr.umlv.td3.Command[] commandToArray() {
        return (fr.umlv.td3.Command[]) command
            .toArray(new fr.umlv.td3.Command[command.size()]);
    }

    /**
     *  
     * @uml.property name="company2"
     * @uml.associationEnd inverse="person2:fr.umlv.td3.Company" multiplicity="(0 1)"
     */
    private Company company2;

    /**
     *  
     * @uml.property name="company2"
     */
    public Company getCompany2() {
        return company2;
    }

    /**
     *  
     * @uml.property name="company2"
     */
    public void setCompany2(Company company2) {
        this.company2 = company2;
    }

}
