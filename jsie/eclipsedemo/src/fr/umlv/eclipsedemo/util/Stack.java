/**
 * Created on 18 janv. 2005
 * 
 * @author jsie
 */
package fr.umlv.eclipsedemo.util;

public interface Stack {
    public abstract boolean isEmpty();

    public abstract void push(Object o);

    public abstract Object pop();
}