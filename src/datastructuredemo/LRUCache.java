/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import java.util.*; 

interface CacheInterface{
    
    void setItem(int keyName,DoublyListNode Item);
    Object getItem(int keyName);
    
    void removeItem(int keyName);
    boolean isEmpty();
    
    int capacityOfCache();
    int numberOfItemInCache();
    
    void printCache();
}

/**
 *
 * @author prashantrastogi
 */
public class LRUCache implements CacheInterface{

    static int capacityOfCache = 4;
    
    // Hash Map for Fast Access
    Map<Integer,DoublyListNode> hashMap=new HashMap<Integer,DoublyListNode>();
    QueueWithDoublyLinkList queueObj = new QueueWithDoublyLinkList(capacityOfCache);
    
    
    public void setItem(int keyName, DoublyListNode newItem) {
        //1. Check in Hash Map
        DoublyListNode item = hashMap.get(keyName);
        
        if( item != null){
            // Item Present in HashMap.
            
            //Delete From Middle
            queueObj.deleteNode(item);
            
            // Place into Front
            queueObj.enqueFront(newItem);
            
            // UPdate Hash Map As Well
            hashMap.put(keyName, (DoublyListNode) newItem);
        }
        else
        {
            if(numberOfItemInCache() < capacityOfCache()){
                // Can Insert New Item in Hash Map
                hashMap.put(keyName, (DoublyListNode) newItem);
                
                // Also in Front of Queue
                queueObj.enqueFront(newItem);
            }
            else
            {
                // Cache is full then 
                //1. Remove Least Recent User Item from Rear
                queueObj.dequeuRear();
                
                // Can Insert New Item in Hash Map
                hashMap.put(keyName, (DoublyListNode) newItem);
                
                // Also in Front of Queue
                queueObj.enqueFront(newItem);
            }
        }
        
    }

    @Override
    public Object getItem(int keyName) {
        DoublyListNode listNode = hashMap.get(keyName);
        
        if( listNode != null){
            
            queueObj.deleteNode(listNode);
            queueObj.enqueFront(listNode);
            return listNode;
        }
        else{
            return null;
        }
    }

    @Override
    public void removeItem(int keyName) {
        DoublyListNode listNode = hashMap.get(keyName);
        
        if( listNode != null){
            
            queueObj.deleteNode(listNode);
            hashMap.remove(keyName);
        }
    }

    @Override
    public boolean isEmpty() {
        return numberOfItemInCache() == 0;
    }

    @Override
    public int capacityOfCache() {
        return capacityOfCache;
    }

    @Override
    public int numberOfItemInCache() {
        return queueObj.list.getSize();
    }
    
    public void printCache(){
        this.queueObj.list.print();
    }
    
    
}
