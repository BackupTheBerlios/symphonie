/*
 * Created on 4 déc. 2004
 *
 */
package fr.umlv.eclipsedemo;

import fr.umlv.eclipsedemo.util.Stack;
import fr.umlv.eclipsedemo.util.StackImpl;

/**
 * @author remi
 *  
 */
public class Main {
    private static void assertion(Object o1, Object o2) {
        if (!o1.equals(o2))
            throw new AssertionError(o1 + " not equals to " + o2);
    }

    public static void main(String[] args) {
        int count;
        try {
            count = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            count = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            count = 1;
        }
        Stack stack = new StackImpl();
        for (int i = 0; i < count; i++)
            stack.push("item " + i);
        assertion(Boolean.valueOf(stack.isEmpty()), Boolean.FALSE);
        System.out.println();
        for (int i = count; --i >= 0;)
            assertion(stack.pop(), "item " + i);
        assertion(Boolean.valueOf(stack.isEmpty()), Boolean.TRUE);
    }
}