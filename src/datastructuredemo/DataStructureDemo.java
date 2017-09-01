/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemo;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author prashantrastogi
 */
public class DataStructureDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AVLTree bst = new AVLTree(21);
        bst.insertKeyInAVLTree(26, bst.rootOfTree);
        bst.insertKeyInAVLTree(30, bst.rootOfTree);
        bst.insertKeyInAVLTree(9, bst.rootOfTree);
        bst.insertKeyInAVLTree(4, bst.rootOfTree);
        bst.insertKeyInAVLTree(14, bst.rootOfTree);
        bst.insertKeyInAVLTree(28, bst.rootOfTree);
        bst.insertKeyInAVLTree(18, bst.rootOfTree);
        bst.insertKeyInAVLTree(15, bst.rootOfTree);
        bst.insertKeyInAVLTree(10, bst.rootOfTree);
        bst.insertKeyInAVLTree(2, bst.rootOfTree);
        bst.insertKeyInAVLTree(3, bst.rootOfTree);
        bst.insertKeyInAVLTree(7, bst.rootOfTree);
        
        bst.preOrderTraversal(bst.rootOfTree); 
        System.out.println("");
        bst.inOrderTraversal(bst.rootOfTree);
        System.out.println("");
        System.out.println(bst.isValidAVLTree(bst.rootOfTree));
        
//        bst.rootOfTree.leftChild = new TreeNode(50);
//        bst.rootOfTree.leftChild.leftChild = new TreeNode(30);
//        bst.rootOfTree.leftChild.rightChild = new TreeNode(55);
//        
//        bst.rootOfTree.rightChild = new TreeNode(70);
//        bst.rootOfTree.rightChild .leftChild= new TreeNode(65);
//        bst.rootOfTree.rightChild .rightChild= new TreeNode(75);
//        
//        bst.inOrderTraversal(bst.rootOfTree);
//        System.out.println("");
//        
//        bst.insertKey(63, bst.rootOfTree);
//        bst.insertKey(53, bst.rootOfTree);
        
        
//        for(int itr = 0; itr <= 10; itr++){
//            int randomNum = ThreadLocalRandom.current().nextInt(2, 1000 + 1);
//            
//            if( itr == 5){
//                bst.insertKey(600, bst.rootOfTree);
//            }
//            else{
//                bst.insertKey(randomNum, bst.rootOfTree);
//            }
//        }
        
//        bst.inOrderTraversal(bst.rootOfTree);
//        System.out.println("");
//        //bst.preOrderTraversal(bst.rootOfTree);
//        System.out.println(bst.findNodeForKey(600, bst.rootOfTree));
//        bst.deleteKey(600);
//        System.out.println("");
//        bst.inOrderTraversal(bst.rootOfTree);
//        System.out.println("");
        //bst.preOrderTraversal(bst.rootOfTree);
        //System.out.println(bst.findNodeForKey(600, bst.rootOfTree));
        //bst.inOrderTraversal(bst.rootOfTree);  
        
//        bst.levelOrderTraversalByLine(bst.rootOfTree);
//        //TreeNode nodeObj = bst.findNodeForKey(65, bst.rootOfTree);
//        System.out.println(bst.heightOfTree());

/*
           InterviewQuestion.enqueItem(10);
           InterviewQuestion.enqueItem(20);
           InterviewQuestion.enqueItem(30);
           
           InterviewQuestion.dequeItem();
           
           InterviewQuestion.enqueItem(90);
           InterviewQuestion.enqueItem(100);

           InterviewQuestion.dequeItem();
           InterviewQuestion.dequeItem();
           InterviewQuestion.dequeItem();
*/
        /*
        LRUCache cache = new LRUCache();
        
        cache.setItem(10, new DoublyListNode("10 String"));
        cache.setItem(20, new DoublyListNode("20 String"));
        cache.setItem(30, new DoublyListNode("30 String"));
        cache.setItem(40, new DoublyListNode("40 String"));
        
        
        cache.printCache();
        cache.getItem(20);
        cache.printCache();
        
        cache.setItem(50, new DoublyListNode("50 String"));
        cache.printCache();
        */
//System.out.println(MathFunctions.isNumberPowerOfTwo(16));
        
        // TODO code application logic here
//        MyLinkedList list = new MyLinkedList();
//        list.insertAtFirst("4");
//        list.insertAtFirst("3");
//        list.insertAtFirst("2");
//        
//        list.insertAtFirst("1");
//        System.out.println(list);
//        list.reverseList();
//        System.out.println(list);

//        char[] charArray = {'a','a'};
//        Utility.printStringPermutation(charArray, 0, 1);
            

/*
            int[] thisIsAnIntArray = {0,1,2,2};
            
            int key  = 1;
            
            System.out.println(MathFunctions.findLeftOccurence(key, thisIsAnIntArray, 0, thisIsAnIntArray.length - 1 ));
            System.out.println(MathFunctions.findRightOccurence(key, thisIsAnIntArray, 0, thisIsAnIntArray.length - 1 ));
            System.out.println(MathFunctions.findOccurence(key, thisIsAnIntArray, 0, thisIsAnIntArray.length - 1 ));
*/
            
    }
    
}
