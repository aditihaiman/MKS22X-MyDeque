import java.util.*;
import java.io.*;

public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] data = s.split(" ");
      MyDeque calc = new MyDeque(data.length);
      for(int x = 0; x < data.length; x++) {

        try{
          calc.addLast(Double.parseDouble(data[x]));
        }
        catch(NumberFormatException e){ //when the substring is an operation, not an integer
          if(data[x].equals("+")) {
            calc.addLast((double)(calc.removeLast()) + (double)calc.removeLast());
          }
          if(data[x].equals("-")) {
            calc.addLast(-1 * (double)calc.removeLast() + (double)calc.removeLast());
          }
          if(data[x].equals("*")) {
            calc.addLast((double)calc.removeLast() * (double)calc.removeLast());
          }
          if(data[x].equals("/")) {
            calc.addLast(1/(double)calc.removeLast() * (double)calc.removeLast());
          }
          if(data[x].equals("%")) {
            Double temp = (double)calc.removeLast();
            calc.addLast((double)calc.removeLast() % temp);
          }

        }
      }

      return (double)calc.getLast();
    }
}
