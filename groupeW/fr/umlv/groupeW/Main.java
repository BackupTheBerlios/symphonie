/*
 * Created on 25 févr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.groupeW;

/**
 * @author alebeuva
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Main {

	public static void main(String[] args) {
		
		Hello.hello();
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
		Bye.auRevoir();
	}
}
