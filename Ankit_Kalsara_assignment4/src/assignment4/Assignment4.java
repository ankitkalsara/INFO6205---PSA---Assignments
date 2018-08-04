package assignment4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Assignment4 {
    public static int globalB0 = 0, globalC1 = 0;   
    public static float avgC1;
    public static float avgB0;
    public static int[] myArray ;    
    public static int[] counterArray;
    
    //hash function
    public static int hash(Integer x, int arraySize){
        int i = x.hashCode();
        //System.out.println(x+"----"+(i & 0x7fffffff) % arraySize);        
        return (i & 0x7fffffff) % arraySize;
    }
    
    //function to calculate the c1 and b1 values
    public static void calculate(int[] myArray, int c1, int b0){        
        Random rand = new Random();        
        int randomInt;
        int hashValue;
        int hashCount = 0;       
        boolean collisionOccured = false;        
        int arraySize = myArray.length;
        //take random numbers from 1 to 100 and fill the array
        int min = 1;
        int max = 100000;
        for(int i = 0; i < max; i++){
            randomInt = rand.nextInt(max - min) + min;
            hashValue = hash(randomInt, myArray.length);
            //hashCount++;
            if(arraySize == 0){
                b0 = hashCount;
                //System.out.println("Number of hashes before all the bins are full = " + b0);      
                globalB0 += b0;
                break;  //once the entire array is full, come out of the loop
            }
            else{             
                if(myArray[hashValue] == 0){    //adding the element in empty space
                    myArray[hashValue] = randomInt;
                    counterArray[hashValue] += 1; //keeping a track of balls
                    hashCount++;
                    arraySize--;    //reduce the size of array once position is filled
                }            
                else if (myArray[hashValue] != 0){
                    if(collisionOccured == false){
                        c1 = hashCount;
                        //System.out.println("First collision occured after " + c1 + " hashes");                
                        globalC1 += c1;
                        collisionOccured = true;
                    }                
                    else {  //allowing the collision and overwriting the value
                        myArray[hashValue] = randomInt;                                
                        counterArray[hashValue] += 1;  //keeping a track of balls
                        hashCount++;
                    }                        
                }    
            }  
        }           
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        String input = scan.nextLine();
        int arraySize = Integer.parseInt(input);        
        float avgC1ByFormula;
        float avgB0ByFormula;
        for(int i = 0; i < 100; i++){   //do the procedure 100 times
            myArray = new int[arraySize];   
            counterArray = new int[arraySize];   
            int b0 = 0, c1 = 0; 
            calculate(myArray, c1, b0);   //method to calculate b1 and c1            
        }
        avgB0 = globalB0/100;
        avgC1 = globalC1/100;      
        avgC1ByFormula = (float) Math.sqrt(Math.PI * arraySize / 2 );
        avgB0ByFormula = (float) (arraySize * Math.log(arraySize));
        System.out.println("Average C1 by code = " + avgC1);
        System.out.println("Average C1 by formula = " + avgC1ByFormula);
        System.out.println("Average B0 by code = " + avgB0);
        System.out.println("Average B0 by formula = " + avgB0ByFormula);        
    }
    
}