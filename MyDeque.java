public class MyDeque<E> {

  private E[] data;
  private int size, start, end, length;

@SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    length = 10;
    start = 0;
    end = 0;
    size = 0;
  }

@SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    length = initialCapacity;
    start = 0;
    end = 0;
    size = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    if(size==0) return "[]";
    String output = "[";
    if(start<=end){
      for(int x = start; x < end; x++) {
        if(data[x]!=null) output += data[x] + ", ";
      }
      return output + data[end] + "]";
    }
    for(int x = start; x < length; x++){ //from start to last element in list
      if(data[x]!=null) output += data[x] + ", ";
    }
    for(int y = 0; y < end; y++){ //from 0th index to end
      if(data[y]!=null) output += data[y] + ", ";
    }
    return output + data[end] + "]";
  }

  public void addFirst(E element){
    if(end==start-1 || (end==length-1 && start==0)) resize(); //replace with if(size==length)
    if(end < start || start!= 0) {
      start--;
    }
    if(start==0) {
      start = length-1;
    }
    data[start] = element;
    size++;
  }

  public void addLast(E element){
    if(end==start-1 || (end==length-1 && start==0)) resize();
    if(end <= start) {
      end++;
    }
    else {
      if(end < length-1) end++;
      if(end==length-1) end=0;
    }
    data[end] = element;
    size++;
  }

  public E removeFirst(){
    E temp = data[start];
    if(start==end) data[start] = null;
    else if(start==length-1){
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
    MyDeque newSize = new MyDeque(this.length*2+1);
    if(start==0){
      for(int x = 0; x < newSize.length; x++){
        newSize.data[x] = this.data[x];
      }
    }
    else {
      int idx = 0;
      for(int x = this.start; x < newSize.length; x++){
        newSize.data[idx] = this.data[x];
        idx++;
      }
      for(int x = 0; x < this.end; x++) {
        newSize.data[idx] = this.data[x];
        idx++;
      }
    }
  }


}
