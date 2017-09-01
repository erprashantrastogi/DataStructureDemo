package datastructuredemo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prashantrastogi
 */
public class MathFunctions {
    
    static int LeftOnly = 10;
    static int RightOnly = 20;
    static int Both = 30;
    
    static int startIndex = 0;
    static int endIndex = 0;
    
    
    static float power(float X, int Y){
        
        /*
                                      1                           if Y = 0
            power(X ^ Y) =            X^(Y/2)  *  X^(Y/2)         if Y is Even 
                                 X   * X^(Y/2)  *  X^(Y/2)        if Y is Odd
        
        Complexity O(LogY)
        
        */
        
        float result;
        
        if(Y == 0){
            result = 1;
        }
        else
        {
            float temp = power(X,Y/2);
        
            if(Y%2 == 0) // Y is Even then X^Y = X^(Y/2) * X^(Y/2)
            {
                // temp = power(X,Y/2);
                result = temp * temp; 
            }
            else  // Y is Odd then X^Y = X * X^(Y-1)
            {
                //int temp = power(X,Y/2);
                if( Y > 0){
                    result = X * temp * temp;
                }
                else
                {
                    result =  temp * temp / X;
                }
                
            }
        }
        
        return result;
    }
    
    static float precesion = 0.000005f;
    
    static float findSquareRoot(float number){
        
        /*
        Complexity: Log (number)
        */
        
        float start = 0f;
        float end = number;
        float previosMid = 0;
        float mid = (start + end) / 2;
        float diff = mid -  previosMid;
        
        if( diff < 0){
            diff = -diff;
        }
        
        while( mid*mid !=  number && diff > precesion )
        {
            if( mid*mid > number){
                end = mid;
            }
            else{
                start = mid;
            }
            
            mid = (start + end) / 2;
            diff = mid -  previosMid;
            
            if( diff < 0){
            diff = -diff;
            }
            
            previosMid = mid;
        }
        
        return mid;
    }
    
    static float findNthRoot(float number,int N){
        
        float start = 0f;
        float end = number;
        float previosMid = 0;
        float mid = (start + end) / 2;
        float diff = mid -  previosMid;
        
        if( diff < 0){
            diff = -diff;
        }
        
        while( power(mid,N) !=  number && diff > precesion )
        {
            if( power(mid,N) > number){
                end = mid;
            }
            else{
                start = mid;
            }
            
            mid = (start + end) / 2;
            diff = mid -  previosMid;
            
            if( diff < 0){
            diff = -diff;
            }
            
            previosMid = mid;
        }
        
        return mid;
    }
    
    static int findLeftOccurence(int key,int array[],int start,int end){
        
        if(start > end){ // Invalid Case
            return -1;
        }
        
        if( array[start] == key){
            return start;
        }
        
        int midIndex = (start + end) / 2;
        
        if(array[midIndex] == key){
            
            if(array[midIndex-1] != key){
                return  midIndex;
            }
            else
            {
                return findLeftOccurence(key,array,start,midIndex-1);
            }
        }
        else if( array[midIndex] > key)
        {
            return findLeftOccurence(key,array,start,midIndex-1);
            
        }
        else
        {
            return findLeftOccurence(key,array,midIndex+1,end);
        }
    }
    
    
    static int findRightOccurence(int key,int array[],int start,int end){
        
        if(start > end){ // Invalid Case
            return -1;
        }
        
        if( array[end] == key){
            return end;
        }
        
        int midIndex = (start + end) / 2;
        
        if(array[midIndex] == key){
            
            if(array[midIndex+1] != key){
                return  midIndex;
            }
            else
            {
                return findRightOccurence(key,array,midIndex+1,end);
            }
        }
        else if(array[midIndex] > key)
        {
            return findRightOccurence(key,array,start,midIndex-1);
        }
        else{
            return findRightOccurence(key,array,midIndex+1,end);
        }
    }
    
    static int findOccurence(int key,int array[],int start,int end){
        
        if(start > end){// Invalid Case
            return -1;
        }
        if(array[start] == key && array[end] == key)
        {
            return end - start;
        }
        
        int leftIndex = findLeftOccurence(key,array,start,end);
        
        if( leftIndex == -1){
            return leftIndex;
        }
        
        int rightIndex = findRightOccurence(key,array,start,end);
        
        if( rightIndex == -1){
            return rightIndex;
        }
        
        return  rightIndex - leftIndex + 1;
        
    }
    
    // Print All Valid Paranthesis of input size 2n, n is Open and n is close
    static void printAllValidBracket(int leftRemain,int rightRemain,String currentStr  ){
        
        // Base Case
        if(rightRemain == 0 && leftRemain == 0){
            System.out.println(currentStr);
            return;
        }
        
        if(leftRemain > 0){// More Opening Bracket
            // Two Cases
            //1. Add {
            printAllValidBracket(leftRemain-1,rightRemain,currentStr+"{");
            
            //2. if leftRemain < rightRemain then Add }
            if(leftRemain < rightRemain){
                printAllValidBracket(leftRemain,rightRemain-1,currentStr+"}");
            }
        }
        else
        {
            if(rightRemain > 0){
                printAllValidBracket(leftRemain,rightRemain-1,currentStr+"}");
            }
        } 
    }
    
    
    static int findGCD(int firstNum, int secondNum){
        
        // Invalid Case
        if(firstNum == 0 || secondNum == 0 ){
            return 0;
        }
        
        // Base Condition
        if(firstNum == secondNum){
            return  firstNum;
        }
        
        if(firstNum > secondNum){
            return findGCD(firstNum-secondNum ,secondNum);
        }
        else{
            return findGCD(firstNum ,secondNum - firstNum);
        }
    }
    
    static String changeIntoRational(float number){
        
        if(number == 0){
            return "0";
        }
        
        int tenPoly = 1;
        while( (float)number*tenPoly -  (int)(number*tenPoly) != 0){
            tenPoly *= 10;
        }
        
        int divident = (int) (number*tenPoly);
        int divisior = tenPoly;
        
        int gcd = findGCD(divident,divisior);
        
        String rationalStr = number + ":= " +  divident/gcd + "/" + divisior/gcd;
        return rationalStr;
    }
    
    static boolean isNumberPowerOfTwo(int num){
        
        int result = num & ( num - 1 );
        if(result == 0){
            return true;
        }
        else
        {
            return false;
        }
    }
    
    static int Max(int firstNum, int secondNum ){
        return firstNum > secondNum ? firstNum : secondNum; 
    }
}
