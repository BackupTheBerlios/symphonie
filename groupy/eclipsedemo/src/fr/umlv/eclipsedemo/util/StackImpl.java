/**
 * Created on 18 janv. 2005
 * 
 * @author jsie
 */
package fr.umlv.eclipsedemo.util;

import java.util.ArrayList;

public class StackImpl implements Stack {
    private final ArrayList list;

    public StackImpl() {
        list = new ArrayList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(Object o) {
        list.add(o);
    }

    public Object pop() {
        return list.remove(list.size() - 1);
    }

}