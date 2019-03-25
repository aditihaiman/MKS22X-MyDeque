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
          calc.addLast(Integer.parseInt(data[x]));

        }

        catch(NumberFormatException e){
          if(data[x].equals("+")) {
            calc.addLast(calc.removeLast() + calc.removeLast());
          }
          if(data[x].equals("-")) {
            calc.addLast(-1 * calc.removeLast() + calc.removeLast());
          }
          if(data[x].equals("*")) {
            calc.addLast(calc.removeLast() * calc.removeLast());
          }
          if(data[x].equals("/")) {
            calc.addLast(1/calc.removeLast() * calc.removeLast());
          }
          if(data[x].equals("%")) {
            calc.addLast(calc.removeLast() + calc.removeLast());
          }

        }



      }

      return 0;
    }
}
