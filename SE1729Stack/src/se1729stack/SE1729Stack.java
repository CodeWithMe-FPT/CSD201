/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package se1729stack;
import java.util.LinkedList;
import java.util.Stack;
/**
 *
 * @author ManhComputer
 */
public class SE1729Stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<Integer> s = new Stack<>();
        MyStack<Integer> ms = new MyStack<>();
        MyStack1<Integer> ms1 = new MyStack1<>();
        
        s.push(5);
        s.push(7);
        s.push(9);
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
        s.clear();
        System.out.println(s.isEmpty());
        
        
        
        ms.push(5);
        ms.push(7);
        ms.push(9);
        System.out.println(ms.pop());
        System.out.println(ms.peek());
        System.out.println(ms.isEmpty());
        ms.clear();
        System.out.println(ms.isEmpty());
        
        ms1.push(5);
        ms1.push(7);
        ms1.push(9);
        System.out.println(ms1.pop());
        System.out.println(ms1.peek());
        System.out.println(ms1.isEmpty());
        ms1.clear();
        System.out.println(ms1.isEmpty());
        
    }
    
}
