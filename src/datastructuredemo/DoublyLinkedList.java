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

public class DoublyLinkedList {

    int size =0;
    DoublyListNode head = null;
    DoublyListNode tail = null;

    public DoublyListNode addAtStart(DoublyListNode node){
        System.out.println("Adding Node " + node.data + " at the start");
        //DoublyListNode n = new DoublyListNode(data);
        if(size==0){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
        return node;
    }

    public DoublyListNode addAtEnd(DoublyListNode node){
        System.out.println("Adding Node " + node.data + " at the End");
        //DoublyListNode n = new DoublyListNode(data);
        if(size==0){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.previous = tail;
            tail =node;
        }
        size++;
        return node;
    }

//    public DoublyListNode addAfter(DoublyListNode node, DoublyListNode prevNode){
//        if(prevNode==null){
//            System.out.println("Node after which new node to be added cannot be null");
//            return null;
//        }else if(prevNode==tail){//check if it a last node
//            return addAtEnd(data);
//        }else{
//            System.out.println("Adding node after "+ prevNode.data);
//            //create a new node
//            //DoublyListNode n = new DoublyListNode(data);
//
//            //store the next node of prevNode
//            DoublyListNode nextNode = prevNode.next;
//
//            //make new node next points to prevNode
//            n.next = nextNode;
//
//            //make prevNode next points to new Node
//            prevNode.next = n;
//
//            //make nextNode previous points to new node
//            nextNode.previous = n;
//
//            //make  new Node previous points to prevNode
//            n.previous = prevNode;
//            size++;
//            return n;
//        }
//    }

    public void deleteFromStart(){
        if(size==0){
            System.out.println("\nList is Empty");
        }else{
            System.out.println("\ndeleting node " + head.data + " from start");
            head = head.next;
            size--;
        }
    }

    public void deleteFromEnd(){
        if(size==0){
            System.out.println("\nList is Empty");
        }else if(size==1){
            deleteFromStart();
        }else{
            //store the 2nd last node
            Object x = tail.data;
            DoublyListNode prevTail = tail.previous;

            //detach the last node
            tail = prevTail;
            tail.next=null;
            System.out.println("\ndeleting node " + x + " from end");
            size--;
        }
    }
    
    public void deleteListNode(DoublyListNode treeNode){
        if( treeNode == null){
            // Do nothing
            return;
        }
        
        if(size==0){
            System.out.println("\nList is Empty");
        }
        
        if(treeNode == head){
            deleteFromStart();
        }
        else if(treeNode == tail ){
            deleteFromEnd();
        }
        else
        {
            DoublyListNode prevNode = treeNode.previous;
            DoublyListNode nextNode = treeNode.next;
            
            prevNode.next = nextNode;
            nextNode.previous = prevNode;
            
            size--;
            //treeNode = null;
        }
    }

    public Object elementAt(int index){
        if(index>size){
            return -1;
        }
        DoublyListNode n = head;
        while(index-1!=0){
            n=n.next;
            index--;
        }
        return n.data;
    }

    //get Size
    public int getSize(){
        return size;
    }

    public void print(){
        DoublyListNode temp = head;
        System.out.print("Doubly Linked List: ");
        while(temp!=null){
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}
class DoublyListNode{
    String data;
    DoublyListNode next;
    DoublyListNode previous;
    public DoublyListNode(String data){
        this.data = data;
        next = null;
        previous = null;
    }
    
    public String toString(){
        return data;
    }
}