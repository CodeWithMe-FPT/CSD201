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
public class CheckString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        MyStack<Character> right = new MyStack<>();
        MyStack<Character> left = new MyStack<>();
        int lenghtLeft = s.length();
        int check = 0;
        if(s.length()%2==1){
            lenghtLeft = s.length() + 1;
        }        
        
        for(int i = 0; i<s.length()/2; i++){
            right.push(s.charAt(i));
        }
        
        for(int i = (s.length() - 1) ; i>=lenghtLeft/2; i--){
            left.push(s.charAt(i));
        }
        
        while(!right.isEmpty()){
            if(Character.compare(right.pop(), left.pop())!=0){
                System.out.println("Không phải chuỗi đối xứng");
                check++;
                break;
            }
        }
        
        if(check==0){
            System.out.println("Đây là chuỗi đối xứng");
        }
    }
}
