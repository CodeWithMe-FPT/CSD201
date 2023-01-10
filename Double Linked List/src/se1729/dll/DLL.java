package se1729.dll;

import java.util.NoSuchElementException;

/**
 *
 * @author ManhComputer
 * @param <T>
 */
public class DLL<T extends Comparable<T>>{
    Node<T> head, tail;
    public int size;
    public DLL() {
        size = 0;
    }
    
    boolean isEmpty(){
       return head==null;
    }
    
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private boolean isAvaiableRemove(int index){
        return index>=0 && index <size;
    }
    
    void addFirst(T el){
        Node p =  new Node(el);
        if(isEmpty()){
            head = tail= p;    
        } else{
            head.prev = p;
            p.next = head;
            head = p;
        }
        size++;
    }
    
    void printAll() {
        Node tmphead = head; 
        while(tmphead!=null){
            System.out.print(tmphead.data + " ");
            tmphead = tmphead.next;
        }
    }
    
    void addLast(T el){
        Node p = new Node(el);
        if(isEmpty()){
            head = tail = p;
        } else {
            p.prev = tail;
            tail.next = p;
            tail = p;
        }
        size++;
    }
    
    void addPos(int pos, T el){
        Node tmp = head;
        if(!isPositionIndex(pos)){
            throw new IndexOutOfBoundsException("Index: " + pos + ", Size: " + size);
        }
        
        if(pos==0){
            this.addFirst(el);
        } else{
            while(--pos!=0){
                tmp = tmp.next;
            }
            tmp.next = new Node(el,tmp.next,tmp);
        }
        size++;

    }
    
    void addMany(T a[]){
        for( T x: a){
            this.addLast(x);
        }
    }
    
    int size(){
        return size;
    }
    
    int indexOf(T val){
        Node<T> tmp = head;
        int pos = 0;
        while(pos<=size){
            if(val.compareTo(tmp.data) == 0){
                return pos;
            } else{
                tmp = tmp.next;
                pos++;
            }

        }
        return -1;
    }
    
    T get(int pos){
        int index = 0;
        if(!isAvaiableRemove(pos)){
            throw new NoSuchElementException();
        }
        if(pos==0){
            return head.data;
        } else{
           if(pos==size-1){
               return tail.data;
           } else {
                Node<T> tmp = head;
                while(index<pos){
                    tmp = tmp.next;
                    index++;
                }
                return tmp.data;
           }
        }

    }
    
    void removeFirst(){
        if(size==0){
            throw new NoSuchElementException();
        }
        head = head.next;
        head.prev = null;
        size--;
    }
    
    void removeLast(){
        if(size==0){
            throw new NoSuchElementException();
        }
        if(size==1){
            removeFirst();
        }
        tail.prev.next = null;
        tail = tail.prev;
        size--;
    }
    
    void removePos(int pos){
        if(!isAvaiableRemove(pos)){
            throw new NoSuchElementException();
        }
        Node tmp = head;
        if(pos == 0){
            removeFirst();
            return;
        } else{
            if(pos==size-1){
                removeLast();
                return;
            }
        }
        while(--pos!=0){
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        size--;
    }
    
    void removeAll(){
        if(size==0){
            throw new NoSuchElementException();
        }        
        head = null;
        tail = null;
        size = 0;
    }
   
   
}

