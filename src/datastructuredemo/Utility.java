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
public class Utility {
    
    static void printStringPermutation(char str[], int left,int right){
        
        // Complexity O (N * N!)
        if(str.length == 0){
            System.out.println("Error: InValid String ");
            return;
        }
        
        if(left == right){ // If Left becomes Right 
            System.out.println(str);
        }
        else
        {
            for(int itr = left ; itr <= right; itr++  ){
                // Swap Itr with Left Position
                swapIndexElement(str,left,itr);
                // DO the recursive Call
                printStringPermutation(str,left+1,right);
                // BackTrack to intial State
                swapIndexElement(str,left,itr);
            }
        }
    }
    
    static void swapIndexElement(char array[], int firstIndex, int secondIndex){
        
        char temp =  array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
    
    static boolean isRotationOfPalindrome(String str){
        
        if( isPalindrome(str)){
            return true;
        }
        else
        {
            // Do Rotaional Check;
            char array[] = str.toCharArray();
            int length = array.length;
            
            int itr = 0;
            while(itr < length){
                //Rotate the array by 1 character
                rotateArray(array);
                
                // Check if Palindrome
                if( isPalindrome(new String(array)) )
                {
                    return true;
                }
                itr += 1;
            }
            
            return false;
        }
    }
    
    static void rotateArray(char [] array){
        
        int length = array.length;
        if( length > 1){
            char startElement = array[0];
            
            int itr = 1;
            while(itr < length){
                array[itr-1]=array[itr];
                itr++;
            }
            array[length-1]=startElement;
        }
    }
    
    static boolean isPalindrome(String inputStr){
        
        char str[] = inputStr.toCharArray();
        if( str.length == 1){
            return true;
        }
        
        int startIndex = 0;
        int endIndex = str.length - 1;
        
        while(startIndex < endIndex){
            
            if(str[startIndex] != str[endIndex]){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
    
    static int isPatternExist(String pattern, String document)
    {
        
        if(pattern == null || document == null){
            return 0;
        }
        
        int lengthOfPattern = pattern.length();
        int lengthOfDocument = document.length();
        
        if(lengthOfDocument < lengthOfPattern || lengthOfPattern <= 0  ){
            // In valid Case. Pattern is too large as compared to Document
            return -1;
        }
        
        char []documentArray = document.toCharArray();
        char []patternArray = pattern.toCharArray();
        
        for(int docItr = 0;  docItr < lengthOfDocument; docItr++){
            
            if(docItr+lengthOfPattern > lengthOfDocument){
                // Invalid Case.
                return -1;
            }
            else
            {
                int temoDocItr =  docItr;
                int pItr = 0;
                for(; pItr < lengthOfPattern;pItr++,temoDocItr++){
                    if(documentArray[temoDocItr] !=  patternArray[pItr]){
                        break;
                    }
                }
                
                if( pItr == lengthOfPattern){
                    return docItr+1;
                }
            }
        }
        
        return -1;
    }
    
    // Get Prefix Array for input Pattern
    static int[] getPrefixArray(String patternStr){
        
        if(patternStr == null ){
            return null;
        }
        
        int patternLength = patternStr.length();
        
        if(patternLength== 0){
            return null;
        }
        
        char []patternArray =  patternStr.toCharArray();
       
        int[] prefixArray = new int[patternLength] ;
        
        int i = 0;
        for(int j = 1; j < patternLength; ){
            
            // If the Chracter are same.
            if(patternArray[i] == patternArray[j]){
                prefixArray [j] = i + 1;
                
                i++;
                j++;
            }
            else// If Character are not match
            {
                // FInd the Next Position of i via looking the j-1 position in prefix array
                if(i == 0){
                    // Then Continue for Next Loop
                    prefixArray[j] = 0;
                    j++;
                }
                else
                {
                    // Do the same check until i becomes to zero
                    i = prefixArray[i-1];
                }
            }
        }
        
        return prefixArray;
    }
    
    static int findPattenUsingKMPAlgo(String pattern, String document){
        
        if(pattern == null || document == null){
            return 0;
        }
        
        int lengthOfPattern = pattern.length();
        int lengthOfDocument = document.length();
        
        if(lengthOfDocument < lengthOfPattern || lengthOfPattern <= 0  ){
            // In valid Case. Pattern is too large as compared to Document
            return -1;
        }
        
        char []documentArray = document.toCharArray();
        char []patternArray = pattern.toCharArray();
        
        // This array contain the index from when we start compare next element in Patter array
        int []prefixArray = getPrefixArray(pattern);
        
        int documentIndex = 0;
        int patternIndex = 0;
        int documentStartIndex = 0;
        
        boolean isValidIndex = (documentStartIndex + lengthOfPattern) <  lengthOfDocument; 
        
        while( isValidIndex ){
            
            // If both chracter are same the increment both indexes
            if(patternArray[patternIndex] == documentArray[documentIndex]){
                patternIndex++;
                documentIndex++;
            }
            else
            {
                // Here we decide two things one is 
                // 1. New patternStartIndex
                // 2. patternIndex
                // Now the prefix Array Help us in this.
                if( patternIndex > 0){
                    patternIndex = prefixArray[patternIndex-1];
                    documentStartIndex = documentStartIndex - patternIndex;
                }
                else
                {
                    documentIndex++;
                    documentStartIndex = documentIndex;
                }
                
                isValidIndex = (documentStartIndex + lengthOfPattern) <  lengthOfDocument;
            }
            
            // if patternIndex reach to end of pattern
            if( patternIndex == lengthOfPattern){
                return documentStartIndex+1;
            }
        }
        
        // if patternIndex reach to end of pattern
        if( patternIndex == lengthOfPattern){
                return documentStartIndex;
        }
        else
        {
            return -1;
        }
    }
}
