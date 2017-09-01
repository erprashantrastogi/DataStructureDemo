/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import java.util.*;

/**
 *
 * @author prashantrastogi
 */
public class InterviewQuestion {
    
    private static Stack inStack = new Stack();
    private static Stack outStack = new Stack();
    
    static void enqueItem(int key){
        inStack.push(key);
    }
    
    static void dequeItem(){
        
        if(outStack.empty()){
            // If outStack Empty then pick all elements from in Stack
           
            while(!inStack.empty()){
                outStack.push(inStack.pop());
            }
            System.out.println(outStack.pop());
        }
        else{
            System.out.println(outStack.pop());
        }
    }
    
    
}
