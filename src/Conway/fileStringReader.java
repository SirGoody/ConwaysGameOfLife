package Conway;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class fileStringReader {

    private static Scanner kb;

    @SuppressWarnings("resource")														//To get rid of the annoying warnings
    public static void read() throws FileNotFoundException{
        Scanner sc; 																	// Declares Scanner to read the file

        do{																				//A never ending loop unless they get the file name right
            kb = new Scanner(System.in);
            System.out.print("Name of the file you are reading from: ");    			//Prompts the user a question
            String s = kb.nextLine(); 													//Store the answer as String s
            System.out.println("");  													//Creates space for a more organized console
            File f = new File(s);														//Creates a path for the file
            if(f.exists()){																//If the file exists in that path then...
                sc = new Scanner(f);													//Scan the file
                System.out.println("Reading file...");									//Check to see if the if works, also for a better visual
                System.out.println("");													//Creates a space for console organization
                break;																	//Breaks the repeating DoWhile loop if the file is found
            }else{																		//If the file cannot be located then...
                System.out.println("File not found. Please re-enter the file name.");	//Lets the user know that the file could not be found
                System.out.println("");													//Creates a space for console organization
            }
        }while(true);																	//The condition to keep the program running

        for(int i = 0; i < 25; i++){													//A for loop to store into a 2D array from GameOfLife class
            String line = sc.nextLine();												//Setting line to a string that is 1 row, 25 times
            gameOfLife.gridA[i]=line.toCharArray();										//Adding the line to the 2d array from GameOfLife
        }
    }
}
