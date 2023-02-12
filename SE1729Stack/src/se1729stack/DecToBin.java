/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1729stack;

import java.util.Scanner;

/**
 *
 * @author ManhComputer
 */
public class DecToBin {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        Scanner sc =  new Scanner(System.in);
        int dec = Integer.parseInt(sc.nextLine());
        while(dec!=0){
            stack.push(dec%2);
            dec = dec/2;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();
       
    }
}
