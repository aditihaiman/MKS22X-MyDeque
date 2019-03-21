public class MyDeque<E> {

  private E[] data;
  private int size, start, end;

@SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
  }

@SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
  }

  public int size(){
    return size;
  }

  public String toString(){
    String output = "";
    return output;
  }

  public void addFirst(E element){

  }

  public void addLast(E element){

  }

  public E removeFirst(){
    E temp = data[start];
    if(start==end) data[start] = null;
    else if(start==size-1){
      data[start] = null;
      start = 0;
    }
    else {
      data[start] = null;
      start++;
    }
    return temp;
  }

  public E removeLast(){

  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }


}
