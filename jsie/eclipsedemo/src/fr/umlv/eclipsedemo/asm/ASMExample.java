/**
 * Created on 21 janv. 2005
 *@author jsie
 */
package fr.umlv.eclipsedemo.asm;

import java.io.IOException;
import java.io.PrintWriter;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.ASMifierClassVisitor;

public class ASMExample {

    public static void main(String[] args) {
        ClassReader reader = null;
        try {
            reader = new ClassReader("fr.umlv.eclipsedemo.HelloEclipse");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ASMifierClassVisitor visitor=new ASMifierClassVisitor(
          new PrintWriter(System.out));
        reader.accept(visitor,true);
    }
}
