package se1729.sll;

import java.util.NoSuchElementException;

/**
 *
 * @author ManhComputer
 * @param <T>
 */
public class CLL<T extends Comparable<T>>{
    Node<T> head;
    public int size;
    public CLL() {
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
            head = p;
            head.next = head;
        } else{            
            p.next = head;
            head = p;
        }
        size++; 
        this.rotate();
    }
    
    void rotate(){
        Node firstNode = head;
        Node tmp = head;
        for(int i = 0; i<this.size - 1; i++){
            tmp = tmp.next;
        }
        tmp.next = firstNode;
}
    
    void printAll() {
        Node tmphead = head;
        for(int i = 0; i< this.size; i++){
            System.out.print(tmphead.data + " ");
            tmphead = tmphead.next;
        }
    }
    
    void addLast(T el){
        Node p = new Node(el);
        if(isEmpty()){
            head = p;
        } else {
            Node tmp = head;
            for(int i = 0; i<this.size - 1; i++){
                tmp = tmp.next;
            }
            tmp.next = p;
            p.next = head;
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
            return;
        } else{
            if(pos==size){
                this.addLast(el);
                return;
            } else{
                while(--pos!=0){
                    tmp = tmp.next;
                }
                tmp.next = new Node(el,tmp.next);
            }
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
                Node tmp = head;
                for(int i = 0; i<this.size - 1; i++){
                    tmp = tmp.next;
                }
                return (T)tmp.data;
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
        Node tmp = head;
        head = tmp.next;
        size--;
        this.rotate();
    }
    
    void removeLast(){
        if(size==0){
            throw new NoSuchElementException();
        }
        if(size==1){
            removeFirst();
        }
        Node tmp = head;
        for(int i = 0; i<this.size - 2; i++){
            tmp = tmp.next;
        }
        tmp.next = head;
        size--;
        this.rotate();

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
        size = 0;
    }
   
}
  

