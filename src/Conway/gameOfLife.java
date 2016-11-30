/*
 * @Author: Chase Goodman (cwgoodman@gmail.com)
 * @Version: ALPHA 0.11
 * @Date Started: March 19th, 2015
 */
package Conway;

import java.io.IOException;
import java.util.Scanner;

public class gameOfLife {
    public static char[][] gridA = new char[25][75];										//Creates a 2D character array to store data in
    public static char[][] gridB = new char[25][75];										//Creates a 2D character array to store more data in
    static int count = 0;																	//Declares the int count as value 0 for later use
    private static Scanner kb;

    static void alive(char[][] gridA, char[][] gridB, char a,								//Method to decide and find whether the neighbor is alive or should be alive
                      char d, int x, int y, int count) {
        if (gridA[x][y] == a) {
            try {
                if (gridA[x][y - 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x][y + 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x + 1][y] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x - 1][y] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x + 1][y - 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x + 1][y + 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x - 1][y - 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x - 1][y + 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            if (count == 2 || count == 3) {
                gridB[x][y] = a;
                count = 0;
            } else if (count < 2 || count > 3) {
                gridB[x][y] = d;
                count = 0;
            }
        }
    }

    public static void dead(char[][] gridA, char[][] gridB, char a,									//Method to decide and find whether the neighbor is dead or should be dead
                            char d, int x, int y, int count) {
        if (gridA[x][y] == d) {
            try {
                if (gridA[x][y - 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x][y + 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x + 1][y] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x - 1][y] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x + 1][y - 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x + 1][y + 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x - 1][y - 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }
            try {
                if (gridA[x - 1][y + 1] == a)
                    count += 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                count += 0;
            }

            if (count == 3) {
                gridB[x][y] = a;
                count = 0;
            } else if (count < 3 || count > 3) {
                gridB[x][y] = d;
                count = 0;
            }
        }
    }

    static void putIn(char[][] gridA, char[][] gridB) {
        for (int x = 0; x < gridA.length; x++) {
            for (int y = 0; y < gridA[x].length; y++)
                gridB[x][y] = gridA[x][y];
        }
    }

    public static void main(String[] args) throws IOException {
        kb = new Scanner(System.in);
        char a = 'X';																					//Initializes char a as 'X' for the array
        char d = '.';																					//Initialized char d as '.' for the array
        int i = 1;																						//Initializes i for the generation count
        System.out.println("------------Welcome to The Game of Life------------");						//Welcomes the user to the game
        System.out.println("");																			//Creates a space for organization

        while(true){																					//Creates a never ending loop for a catcher
            Scanner c = new Scanner(System.in);
            System.out.print("Click 1 if you want to play, click 2 if you don't want to play: ");		//Asks the user if he/she wants to play or not
            int ch = c.nextInt();																		//Saving user input as an int with variable a
            System.out.println("");																		//Creates a space for organization

            if (ch==1){																					//If the user wants to play...
                break;																					//Breaks the forever while loop
            }else if(ch == 2) {																			//If the user doesn't want to play
                System.out.println("Goodbye...");														//Say goodbye to the user, more graphically pleasing
                System.exit(0);																			//Quit the entire program
            }else{																						//If he/she enters neither 1 or 2 then...
                System.out.println("Please enter either 1 or 2.");										//Prompt them to either enter a 1 or 2
                System.out.println("");																	//Creates a space for organization
            }
            c.close();
        }																								//The end of the never ending loop
        fileStringReader.read();
        while (true) {																					//The beginning of a never ending loop
            System.out.print("Select 'Q' to quit or 'C' to continue to the next generation: ");			//Tells them how to quit or continue
            String input = kb.nextLine();																//Creates an input to store a value
            if (input.equalsIgnoreCase("c")) {															//If they select to continue
                System.out.println("");																	//Creates space in the console to clean it up
                System.out.println("----------------------Generation "+i+"----------------------\n");	//Lets them know what generation they are on
                for (int x = 0; x < 25; x++) {															//A loop to print out each line on the txt file
                    for (int y = 0; y < 75; y++) {														//A nested loop to print out each character in each line of the txt file
                        alive(gridA, gridB, a, d, x, y, count);											//Finds all of the ones that are still alive and changes their value
                        dead(gridA, gridB, a, d, x, y, count);											//Finds all of the ones that are dead and changes their value
                    }
                }
                printer(gridB);																			//Prints gridB to the console as a display
                putIn(gridB, gridA);																	//Puts the gridA and gridB as the new ones
                i++;																					//Counts the generation number
            } else if (input.equalsIgnoreCase("q")) {													//in case they select to quit
                System.out.println("Goodbye...");														//Lets the user know that I understood that they want to stop
                System.exit(0);																			//Close the program
            } else {																					//If they don't enter either Q or N
                System.out.print("Do you want to quit(Q) or continue to the next generation(C): ");	    //This lets them re-enter it into something the program understands
            }
        }																								//The end of the never ending loop
    }																									//End of the main function

    static void printer(char[][] nGrid) {																//Prints each generation to the console
        for (int x = 0; x < 25; x++) {																	//A loop for each line
            for (int y = 0; y < 75; y++) {																//A nested loop for each character in each line
                System.out.print(nGrid[x][y]);															//Prints out the new grid
                if (y == 74)																			//If it is at the 74th char in the array...
                    System.out.println("\n");															//go to next line
            }
        }																								//End of nested for loop
    }

}
