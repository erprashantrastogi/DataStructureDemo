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
public class AVLTree extends BinarySearchTree {
    
    public AVLTree(int intialKey) {
        super(intialKey);
    }
    
    // return true if balancing factor is maintained -1 0 1 
    boolean isValidAVLTree(TreeNode treeNode){
        
        if( treeNode == null){
            return true;
        }
        
        // Base Condition
        if(!isValidBalingFactor (treeNode)){
            return false;
        }
        else
        {
            boolean isValid = isValidAVLTree(treeNode.leftChild) && isValidAVLTree(treeNode.leftChild);
            return isValid;
        }
    }
    
    boolean isValidBalingFactor(TreeNode treeNode){
        
        if( treeNode == null){
            return true;
        }
        
        int balancingFactor = heightOfNode(treeNode.leftChild) - heightOfNode(treeNode.rightChild) ;
        return balancingFactor > -2 && balancingFactor < 2;
    }
    
    
    final TreeNode insertKeyInAVLTree(int keyName, TreeNode rootNode){
        TreeNode newlyInsertedNode = super.insertKey(keyName, rootNode);
        
        TreeNode ancestorNode = newlyInsertedNode.parentNode;
    
        while(ancestorNode != null && isValidBalingFactor(ancestorNode)){
           ancestorNode = ancestorNode.parentNode;
        }
        
        if(ancestorNode == null){
            // Balancing Factor of any node is not Changed.
            // Dont need rotation
            //System.out.println("Do Nothing");
        }
        else 
        {
            String rotationType = "";
            if( ancestorNode.keyName >  keyName){
                rotationType = rotationType + "L";
                
                if(ancestorNode.leftChild.keyName > keyName){
                    rotationType = rotationType + "L";
                }
                else{
                    rotationType = rotationType + "R";
                }
            }
            else{
                rotationType = rotationType + "R";
                
                if(ancestorNode.rightChild.keyName > keyName){
                    rotationType = rotationType + "L";
                }
                else{
                    rotationType = rotationType + "R";
                }
            }
            
            
            TreeNode parentOfCulpritNode = ancestorNode.parentNode;
            boolean isCulpritNodeAsParent = ancestorNode == rootOfTree;
            
            boolean isLeftChild = false;
            if( !isCulpritNodeAsParent ){
                isLeftChild = parentOfCulpritNode.isLeftChild(ancestorNode);
            }
            
            TreeNode newRootOfCulpritNode = null;
            
            if(rotationType.equals("LL")){
                newRootOfCulpritNode = leftRotate(ancestorNode);
            }
            else if(rotationType.equals("RR")){
                newRootOfCulpritNode = rightRotate(ancestorNode);
            }
            
            else if(rotationType.equals("RL")){
                newRootOfCulpritNode = rightLeftRotate(ancestorNode);
            }
            else
            {   // LR Rotation
                newRootOfCulpritNode = leftRightRotate(ancestorNode);
            }
            
            if( !isCulpritNodeAsParent ){
                
                if( isLeftChild ){
                    parentOfCulpritNode.leftChild = newRootOfCulpritNode;
                }
                else{
                    parentOfCulpritNode.rightChild=newRootOfCulpritNode;
                }
                
                newRootOfCulpritNode.parentNode = parentOfCulpritNode;
            }
            else
            {
                rootOfTree = newRootOfCulpritNode;
                rootOfTree.parentNode = null;
            }
            
            
            System.out.println(rotationType);
            
        }
        
        return newlyInsertedNode;
    }
    
    TreeNode doRebalancing(TreeNode treeNode,int keyName){
        
        if( treeNode == null){
            System.out.println("Error: InValid Rebalancing: Null Object");
            return null;
        }
        else
        {
            
        }
        return null;
    }
    
    final boolean deleteKeyInAVLTree(int keyName){
        TreeNode parentOfDeletedNode =  super.deleteKey(keyName);
        
        while(parentOfDeletedNode != null){
            
            if(isValidBalingFactor(parentOfDeletedNode)){
                // DO Nothing
            }
            else
            {
                // Do Rebalancing on this Node parentOfDeletedNode
                doRebalancing(parentOfDeletedNode,keyName);
            }
            
            parentOfDeletedNode = parentOfDeletedNode.parentNode;
        }
        
        
        return true;
    }
    
    TreeNode leftRotate(TreeNode treeNode){
        
        if(treeNode == null){
            System.out.println("Error: Invalid Left Left Rotation");
            return null;
        } 
        // This is the Left Left Case: LL Case
        TreeNode A = treeNode;
        TreeNode B = treeNode.leftChild;
        
        TreeNode T2 = B.rightChild;
        
        B.rightChild = A;
        A.parentNode = B;
        
        if( T2 != null){
            T2.parentNode = A;
            A.leftChild = T2;
        }
        else
        {
            A.leftChild = null;
        }
        return B;
    }
    
    TreeNode rightRotate(TreeNode treeNode){
        
        if(treeNode == null){
            System.out.println("Error: Invalid Right Right Rotation");
            return null;
        } 
        // This is the Right Right Case: RR Case
        
        TreeNode A = treeNode;
        TreeNode B = treeNode.rightChild;
        TreeNode T2 = B.leftChild;
        
        B.leftChild = A;
        A.parentNode = B;
        
        if( T2 != null){
            A.rightChild = T2;
            T2.parentNode = A;
        }
        else
        {
            A.rightChild = null;
        }
        
        return B;
    }
    
    TreeNode leftRightRotate(TreeNode treeNode){
        
        // LR -> LR
        
        TreeNode firstRotationResult = rightRotate(treeNode.leftChild);
        treeNode.leftChild = firstRotationResult;
        firstRotationResult.parentNode = treeNode;
        
        TreeNode secondRotationResult = leftRotate(treeNode);
        return secondRotationResult ;
        
    }
    
    TreeNode rightLeftRotate(TreeNode treeNode){
        
        //RL Case -> RL
        
        TreeNode firstRotationResult = leftRotate(treeNode.rightChild);
        treeNode.rightChild = firstRotationResult;
        firstRotationResult.parentNode = treeNode;
        
        TreeNode secondRotationResult = rightRotate(treeNode);
        return secondRotationResult ;
        
    }
}
