import java.util.*;
import java.io.*;


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
    if(element == null) throw new NullPointerException();
    if(size==length) resize(); //replace with if(size==length)
    if(size!=0) {
      if(start!=0) start--;
      else start = length-1;
    }
    data[start] = element;
    size++;
  }

  public void addLast(E element){
    if(element == null) throw new NullPointerException();
    if(size==length) resize();
    if(size!=0) {
      if(end==length-1) end = 0;
      else end++;
    }
    data[end] = element;
    size++;

  }

  public E removeFirst(){
    if(size==0) throw new NoSuchElementException();
    E temp = data[start];
    data[start] = null;
    if(start!=end) {
      if(start==length-1) start = 0;
      else start++;
    }
    size--;
    return temp;
  }

  public E removeLast(){
    if(size==0) throw new NoSuchElementException();
    E temp = data[end];
    data[end] = null;
    if(start!=end) {
      if(end==0) end = length - 1;
      else end--;
    }
    size--;
    return temp;
  }

  public E getFirst(){
    if(size==0) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast(){
    if(size==0) throw new NoSuchElementException();
    return data[end];
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] newSize = (E[])new Object[length*2+1];
    if(start==0){
      for(int x = 0; x < length; x++){
        newSize[x] = data[x];
      }
    }
    else {
      int idx = 0;
      for(int x = start; x < length; x++){
        newSize[idx] = data[x];
        idx++;
      }
      for(int x = 0; x <= end; x++) {
        newSize[idx] = data[x];
        idx++;
      }
    }
    start = 0;
    end = size-1;
    length = length * 2 + 1;
    data = newSize;
  }


}
