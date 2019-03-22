public class MyDeque<E> {

  private E[] data;
  private int size, start, end;

@SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 10;
    start = 0;
    end = 0;
  }

@SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = initialCapacity;
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String output = "[";
    if(start<=end){
      for(int x = start; x < end; x++) {
        output += data[x] + ", ";
      }
      return output + data[end] + "]";
    }
    for(int x = start; x < size; x++){ //from start to last element in list
      output += data[x] + ", ";
    }
    for(int x = 0; x < end; x++){ //from 0th index to end
      output += data[x] + ", ";
    }
    return output + data[end] + "]";
  }

  public void addFirst(E element){
    if(end==start-1 || (end==size-1 && start==0)) resize();
    if(end < start || start!= 0) {
      start--;
      data[start] = element;
    }
    if(start==0) {
      start = size-1;
      data[start] = element;
    }
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
    E temp = data[end];

    return temp;
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }


  private void resize() {
    MyDeque newSize = new MyDeque(this.size*2+1);
    // for(int x = 0; x < this.size; x++){
    //   newSize.data[x] = this.data[x];
    // }
    // newSize.start = this.start;
    // newSize.end = this.end;
  }


}
