/**
 * Created on 28 janv. 2005
 *@author jsie
 */

public class Calc {
    private int memory;
    public int returnSeven() {
      return 7;
    }
    public int add(int a, int b) {
      return a+b;
    }
    public int sub(int a, int b) {
	   return a-b;
    }
    public int getMemory() {
      return memory;
    }
    public void setMemory(int memory) {
      this.memory=memory;
    }
}
