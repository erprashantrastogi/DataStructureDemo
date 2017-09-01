/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

/**
 *
 * @author prashantrastogi
 */

public class MyLinkedList {
    
    ListNode head = null;
    
    @Override
    public String toString(){
        
        ListNode current = head;
        
        String result = "";
        
        if( head == null){
            result = "Empty List";
        }
        else{
            result = current.key;
            while(current.nextPtr != null){
                current =  current.nextPtr;
                result = result + " -> " + current.key;
            }
        }
        
        return result;
    }
    
    void insertAtFirst(String key){
        if(head == null){
            head = new ListNode(key);
        }
        else
        {
            ListNode tempNode = new ListNode(key);
            tempNode.nextPtr =  head;
            head = tempNode;
        }
    }
    
    void reverseList(){
        if(head == null || head.nextPtr == null){
            // Do nothing
        }
        else
        {
            ListNode currentNode = head;
            ListNode nextNode = head.nextPtr;
            ListNode prevNode = null;
            
            while(nextNode != null){
                
                currentNode.nextPtr = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
                nextNode = currentNode.nextPtr;
            }
            
            currentNode.nextPtr = prevNode;
            head = currentNode;
        }
    }
    
}


class ListNode{
    String key;
    ListNode nextPtr;
    
    ListNode(String keyName){
        key = keyName;
        nextPtr = null;
    }
}