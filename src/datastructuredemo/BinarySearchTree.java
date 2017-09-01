/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructuredemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author prashantrastogi
 */
public class BinarySearchTree {
    
    TreeNode rootOfTree;
    
    BinarySearchTree(int intialKey){
        rootOfTree = new TreeNode(intialKey);
    }
    
    final boolean isBST(TreeNode rootNode){
        
        if( rootNode == null){
            return true;
        }
        
        boolean isLeftKeyCorrect ;
        boolean isRightKeyCorrect ;
        boolean isLeftSubTreeBST;
        boolean isRightSubTreeBST;
        boolean isCurrentNodeSatifyBST;
        
        if(rootNode.rightChild != null){
            isRightKeyCorrect = rootNode.keyName <  rootNode.rightChild.keyName;
        }
        else
        {
            isRightKeyCorrect = true;
        }
        
        if(rootNode.leftChild != null){
            isLeftKeyCorrect = rootNode.keyName >=  rootNode.leftChild.keyName;
        }
        else
        {
            isLeftKeyCorrect = true;
        }
        
        isCurrentNodeSatifyBST = isLeftKeyCorrect &&  isRightKeyCorrect;
        
        if( isCurrentNodeSatifyBST ){
            isLeftSubTreeBST = isBST(rootNode.leftChild);
            isRightSubTreeBST = isBST(rootNode.rightChild);
            
            return isLeftSubTreeBST && isRightSubTreeBST;
        }
        else
        {
            return false;
        }
        
        
        
    }
    
    final void inOrderTraversal(TreeNode rootNode){
        if(rootNode != null){
            
            inOrderTraversal(rootNode.leftChild);
            rootNode.visitNode();
            inOrderTraversal(rootNode.rightChild);
        }
    }
    
    final void preOrderTraversal(TreeNode rootNode){
        if(rootNode != null){
            
            rootNode.visitNode();
            preOrderTraversal(rootNode.leftChild);
            preOrderTraversal(rootNode.rightChild);
        }
    }
    
    final void postOrderTraversal(TreeNode rootNode){
        if(rootNode != null){
            
            postOrderTraversal(rootNode.leftChild);
            postOrderTraversal(rootNode.rightChild);
            rootNode.visitNode();
        }
    }
    
    final void levelOrderTraversal(TreeNode rootNode){
     
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        
        while(!queue.isEmpty()){
            
            TreeNode node = queue.poll();
            if( node.leftChild != null ){
                queue.add(node.leftChild);
            }
            if( node.rightChild != null ){
                queue.add(node.rightChild);
            }
            
            node.visitNode();
        }
    }
    
    final void levelOrderTraversalByLine(TreeNode rootNode){
     
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        
        queue1.add(rootNode);
        
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            
            if( !queue1.isEmpty() ){
                TreeNode node = queue1.poll();
                if( node.leftChild != null ){
                    queue2.add(node.leftChild);
                }
                if( node.rightChild != null ){
                    queue2.add(node.rightChild);
                }
            
                node.visitNode();
                
                if( queue1.isEmpty()){
                    System.out.println("");
                }
            }
            else
            {
                TreeNode node = queue2.poll();
                if( node.leftChild != null ){
                    queue1.add(node.leftChild);
                }
                if( node.rightChild != null ){
                    queue1.add(node.rightChild);
                }
            
                node.visitNode();
                
                if( queue2.isEmpty()){
                    System.out.println("");
                }
            }
        }
    }
    
    /*
        return Tree Node if Success
        return null if Failure
    */
    final TreeNode findNodeForKey(int keyName, TreeNode rootNode){
        
        if( rootNode == null){
            // Invalid Case
            System.out.println("Error: Node node found with Key : "+keyName);
            return null;
        }
        
        if(rootNode.keyName == keyName){
            return rootNode;
        }
        else
        {
            if(keyName < rootNode.keyName && rootNode.leftChild != null ){
                // Search in Left Tree
                return findNodeForKey(keyName,rootNode.leftChild);
            }
            else if(keyName > rootNode.keyName && rootNode.rightChild != null ){
                // Search in Right Tree
                return findNodeForKey(keyName,rootNode.rightChild);
            }
            else
            {
                System.out.println("Error: Node node found with Key : "+keyName);
                return null;
            }
        }
    }
    
    final TreeNode insertKey(int keyName, TreeNode rootNode){
        
        //Base Case
        if( rootOfTree == null){
            // Tree is Empty.Create new Node and Insert
            rootOfTree = new TreeNode(keyName);
            return rootOfTree;
        }
        
        if(keyName < rootNode.keyName){
            
            if( rootNode.leftChild == null){
                // Insert Here
                rootNode.leftChild = new TreeNode(keyName);
                rootNode.leftChild.parentNode = rootNode;
                return rootNode.leftChild;
            }
            else{
                // Recursively Call on Left Child
                return insertKey(keyName,rootNode.leftChild);
            }
        }
        else if(keyName > rootNode.keyName){
            if( rootNode.rightChild == null){
                // Insert Here
                rootNode.rightChild = new TreeNode(keyName);
                rootNode.rightChild.parentNode = rootNode;
                return rootNode.rightChild;
            }
            else{
                // Recursively Call on Left Child
                return insertKey(keyName,rootNode.rightChild);
            }
        }
        else
        {
            System.out.println("Error: Duplicate Key : "+keyName);
            return null;
        }
    } 
    
    final TreeNode getSuccessorForKey(int keyName){
        
        TreeNode nodeForKey = findNodeForKey(keyName,rootOfTree);
        
        if( nodeForKey == null){
            System.out.println("Node not found for key : "+keyName);
            return null;
        }
        else{
            // If Right Child is available the successor in right Child
            if( nodeForKey.rightChild != null){
                return getMinKeyNode(nodeForKey.rightChild);
            }
            else// Then Come From RootOfTree to target Node and track the max Node.
            {
                TreeNode ancestor = rootOfTree;
                TreeNode successor = null;
                
                while(ancestor != nodeForKey){
                    
                    if(ancestor.keyName > keyName){
                        successor = ancestor;
                        ancestor = ancestor.leftChild;
                    }
                    else{
                        ancestor = ancestor.rightChild;
                    }
                }
                return successor;
            }
        }
    }
    
    final TreeNode getMaxKeyNode(TreeNode subTree){
        if( subTree == null){
            return null;
        }
        else
        {
            while(subTree.rightChild != null){
                subTree = subTree.rightChild;
            }
            
            return subTree;
        }
    }
    
    final TreeNode getMinKeyNode(TreeNode subTree){
       
        if( subTree == null){
            return null;
        }
        else
        {
            while(subTree.leftChild != null){
                subTree = subTree.leftChild;
            }
            
            return subTree;
        }
    }
    
    final TreeNode getPredeccessorForKey(int keyName){
        TreeNode nodeForKey = findNodeForKey(keyName,rootOfTree);
        
        if( nodeForKey == null){
            System.out.println("Node not found for key : "+keyName);
            return null;
        }
        else{
            // If Right Child is available the successor in right Child
            if( nodeForKey.leftChild != null){
                return getMaxKeyNode(nodeForKey.leftChild);
            }
            else// Then Come From RootOfTree to target Node and track the max Node.
            {
                TreeNode ancestor = rootOfTree;
                TreeNode predeccessor = null;
                
                while(ancestor != nodeForKey){
                    
                    if(ancestor.keyName < keyName){
                        predeccessor = ancestor;
                        ancestor = ancestor.rightChild;
                    }
                    else{
                        ancestor = ancestor.leftChild;
                    }
                }
                return predeccessor;
            }
        }
    }
    
    boolean deleteNode(TreeNode treeNode){
        
        if( treeNode.isLeaveNode()){
            if(treeNode.parentNode.keyName > treeNode.keyName){
                treeNode.parentNode.leftChild = null;
            }
            else{
                treeNode.parentNode.rightChild = null;
            }
        }
        else if( treeNode.leftChild != null){
            if(treeNode.parentNode.keyName > treeNode.keyName){
                treeNode.parentNode.leftChild = treeNode.leftChild;
            }
            else{
                treeNode.parentNode.rightChild = treeNode.leftChild;
            }
        }
        else if( treeNode.rightChild != null){
            if(treeNode.parentNode.keyName > treeNode.keyName){
                treeNode.parentNode.leftChild = treeNode.rightChild;
            }
            else{
                treeNode.parentNode.rightChild = treeNode.rightChild;
            }
        }
        else{
            System.out.println("Error: Deletetion Not Allowed");
            return false;
        }
        
        System.out.println("Node deleted for key: "+treeNode.keyName);
        return true;
    }
    
    // This function will Return the Parent Node of Deleted Node
    final TreeNode deleteKey(int keyName){
        // 1. Find Node with Key
        TreeNode treeNode = findNodeForKey(keyName,rootOfTree);
        
        if(treeNode == null){
            System.out.println("System Error: Node not found for key: "+keyName);
            return null;
        } 
        else
        {
            if( treeNode.leftChild != null && treeNode.rightChild != null){
                // Two way if Node Has both Left as well Right Subtree.
                // 1. Find MaxElement in Left Subtree and Replce with That and Delete the MaxElement Node
                TreeNode maxNode = getMaxKeyNode(treeNode.leftChild);
                
                int tempKeyName = maxNode.keyName;
                
                TreeNode parentNode = maxNode.parentNode;
                // Delete Max Node
                deleteNode(maxNode);
                treeNode.keyName = tempKeyName;
                
                return parentNode;
                
            }
            else
            {
                TreeNode parentNode = treeNode.parentNode;
                deleteNode(treeNode);
                return parentNode;
            }
        } 
    }
    
    final int heightOfTree(){
        return heightOfNode(rootOfTree);
    }
    
    final int heightOfNode(TreeNode treeNode){
        // Height : Longest path from treeNode to Leave Node. Downwards
        if(treeNode == null){
            return 0;
        }
        
        if(treeNode.leftChild == null && treeNode.rightChild == null){
            return 1;
        }
        else
        {
            return 1 + MathFunctions.Max(heightOfNode(treeNode.leftChild), heightOfNode(treeNode.rightChild));
        }
    }
    
}

class TreeNode{
    TreeNode parentNode;
    TreeNode leftChild;
    TreeNode rightChild;
    int keyName;
    
    // In AVL Tree Balancing Factor should be -1 0 +1
    // Balancing Factor = heightOfLeftTree - heightOfRightTree
    //int balancingFactor;
    
    TreeNode(int keyName){
        this.keyName = keyName;
        leftChild = null;
        rightChild = null;
        parentNode = null;
        //balancingFactor = 0;
    }
    
    boolean isLeaveNode(){
        return this.leftChild == null && this.rightChild == null;
    }
    
    void visitNode(){
        System.out.print(keyName + " , ");
    }
    
    @Override
    public String toString(){
        return "Root Info keyName : " + this.keyName;
    }
    
    final boolean isLeftChild(TreeNode treeNode){
        return this.leftChild == treeNode;
    }
    
    final boolean isRightChild(TreeNode treeNode){
        return this.rightChild == treeNode;
    }
    
    final boolean isParentNode(TreeNode treeNode){
        return this.parentNode == treeNode;
    }

}

