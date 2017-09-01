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
public class QueueWithDoublyLinkList {
    
    int sizeOfQueue;
    DoublyListNode front;
    DoublyListNode rear;
    
    DoublyLinkedList list;

    public QueueWithDoublyLinkList(int sizeOfQueue) {
        this.list = new DoublyLinkedList();
        this.sizeOfQueue = sizeOfQueue;
    }
    
    void enqueFront(DoublyListNode item){
        this.list.addAtStart(item);
    }
    
    void dequeuRear(){
        this.list.deleteFromEnd();
    }
    
    void deleteNode(DoublyListNode listNode){
        if( listNode == null){
            return;
        }
        
        this.list.deleteListNode(listNode);
    }
    
    int maxSize(){
        return this.sizeOfQueue;
    }
    
    int count(){
        return this.list.getSize();
    }
    
}
