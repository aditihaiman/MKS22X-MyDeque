public class Driver {
  public static void main(String[] args) {
    MyDeque test = new MyDeque();
    //System.out.println(test.toString());
    for(int x = 0; x < 10; x++) {
      test.addLast(x);
    }
    System.out.println(test.getLast());
    System.out.println(test.toString());
    //System.out.println(test.size());

  }

}
