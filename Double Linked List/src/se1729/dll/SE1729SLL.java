/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1729.dll;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 *
 * @author ManhComputer
 */
public class SE1729SLL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DLL<Integer> sll = new DLL<Integer>();
        Integer[] myNum = { 10, 20, 30, 40 };
        sll.addFirst(5);
        sll.addFirst(7);
        sll.addFirst(9);
        sll.addLast(99);
        sll.addPos(0, 12);
        sll.addPos(2, 4);
        sll.addMany(myNum);
        System.out.println(sll.indexOf(99));
        System.out.println(sll.get(2));
        sll.printAll();
        System.out.println("\n");
        sll.removeFirst();
        sll.printAll();
        System.out.println("\n");        
        sll.removeLast();
        sll.printAll();  
        System.out.println("\n");                
        sll.removePos(2);
        sll.printAll();
        System.out.println("\n");                
        sll.removeAll();
        System.out.println(sll.head);        
        
        
        
//        LinkedList <Integer> sll1 = new LinkedList<>();
//        sll1.removeFirst();
//        sll1.add(9);
//        sll1.add(7);
//        sll1.add(5);
//        System.out.println(sll1.toString());
//        sll1.add(2,20);
//        System.out.println(sll1.toString());
//        sll1.addFirst(100);
//        System.out.println(sll1.toString());
//        sll1.addLast(50);
//        System.out.println(sll1.toString());
//        System.out.println(sll1.get(0));
//        System.out.println(sll1.indexOf(100));
//        System.out.println(sll1.size());

       
    }
    
}
