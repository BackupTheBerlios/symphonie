/**
 * Created on 18 f�vr. 2005
 *@author jsie
 */
package fr.umlv.td3;

public class Article {

    /**
     * 
     * @uml.property name="name" multiplicity="(0 1)"
     */
    private final String name;

    /**
     * 
     * @uml.property name="id" multiplicity="(0 1)"
     */
    private final int id;

    
    public Article(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
