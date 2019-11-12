import java.util.Scanner;
import java.io.FileReader;
import java.io.*;
import java.lang.String;
import java.util.Random;
/** This is a Java Program
FileName : "Hero_Game".
Author: Shane Bryant
Date: 12/4/2019
Purpose: This is a Java Program that asks the user to pick a character to play as, 
then pick the character they want to fight as, 
then use an RNG to compute a winner after 7 rounds!*/
public class Hero_Game { 
   //Method that opens file "Hero.txt" and reads it from a specific line and stops reading at another specific line (displays the text from the file into the console)
   public static void files() throws IOException {
      	
      BufferedReader in = new BufferedReader (new FileReader("Hero.txt")); //Allows text to be read from the file "Hero.txt"
      String inFile = "";
      int startLine = 1; //Text from file is outputted starting from the first line
      int endLine = 7;   //Text from file is outputted ending at the seventh line
      for (int i = 0; i < startLine; i++) { 
         inFile = in.readLine(); 
      }
      for (int i = startLine; i < endLine + 1; i++) {
         inFile = in.readLine();
         System.out.println(inFile); 
      }
      	
      in.close(); //The file is closed
   } 
   //Method that initializes the character traits of attack, health, and special as Random for both charcaters selected 
   //Adds all the stats for the first character, then
   //Adds all the stats for the second character, then returns (Attack > Attack2)
   public static boolean RNG(){
      Random rand = new Random();  
      int Attack = rand.nextInt(500); 
      int Attack2 = rand.nextInt(500);
      int Health = rand.nextInt(500); 
      int Health2 = rand.nextInt(500);
      int Special2 = rand.nextInt(500); 
      int Special = rand.nextInt(500);
      Attack = Attack + Health + Special;
      Attack2 = Attack2 + Health2 +Special2;
      return (Attack > Attack2);
   
   }
   //The main method (executs the bulk or main parts of the code)
   public static void main(String[] args) throws IOException { 
      //Initializes String, char, and int variables
      String repeat;
      char choice;
      char pick;
      int win = 0; 
      int win2 = 0;
      String fileName = "Hero_Results.txt"; //String fileName initialized to the text file name
      PrintWriter outFile = new PrintWriter(fileName); //PrintWriter declared | Allows user to print the results to a file 
   //The do is connected to a do-while loop that allows the user to restart the program if they'd like to        
      do{      
      /*
      Display messages asking the user to select a character from the list that they want to play as
      Acquire user input
      */
         
         System.out.println("Pick a Superhero from the following list that you want to play as!");
         files(); //Calls method files(); | displays the character list
         Scanner s = new Scanner(System.in);
         choice = s.next().charAt(0); //Allows user to input a letter for char choice;
         //Input Validation (checks to see if the input is one of the following | if it is not one of the following, then the following gets executed)        
         while (choice != 't' && choice != 'T' && choice != 'b' && choice != 'B' && choice != 'd' && choice != 'D' && choice != 'p' 
                  && choice != 'P' && choice != 'a' && choice != 'A' && choice != 'z' && choice != 'Z' )
         {
            System.out.println("Invalid input! Pick from the following:");
            files(); //Calls method files(); | displays the character list
            choice = s.next().charAt(0); //Allows user to input another letter for char choice;
         }
      /*
      Display messages asking the user to select a character from the list that they want to fight against
      Acquire user input
      */ 
         System.out.println("Pick a DIFFERENT charcater that you would like to fight?");
         files(); //Calls method files(); | displays the character list
         pick = s.next().charAt(0); //Allows user to input another letter for char pick;
         //Input Validation (checks to see if the input is one of the following | if it is not one of the following, then the following gets executed)        
         while (pick != 't' && pick != 'T' && pick != 'b' && pick != 'B' && pick != 'd' && pick != 'D' 
                  && pick != 'p' && pick != 'P' && pick != 'a' && pick != 'A' && pick != 'z' && pick != 'Z' )
         {
            System.out.println("Invalid input! Pick from the following:");
            files(); //Calls method files(); | displays the character list
            pick = s.next().charAt(0); //Allows user to input another letter for char pick;
         }
         switch (choice) {
         /*
         Case 1 for the first character
         Include nested if statements to allow an outcome that is true when using an RNG 
         and comparing which number was higher from the RNG 
         The higher number is the winner and a message is displayed stating that character is the winner 
         */
            case 'T':
            case 't':
               //If the same character is chosen twice, then the output is invalid and the program ends! | This is repeated throughout the switch statements
               if (pick == 'T' || pick == 't'){
                  outFile.println("Invalid! You cannot fight against the same charcater!");
               }
               if (pick == 'B' || pick == 'b'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     //As long as the boolean value of the method RNG() is true, then computes a winner of the round using the RNG values
                     //RNG() is initialized to true | and the following is repeated throughout the switch statement
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Tanjiro won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Barack Obama won this round!");
                     }
                  }
                  //Compares the win total between the characters and finds the total number of wins!
                  if (win > win2)
                     outFile.println("Tanjiro is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Barack Obama is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'D' || pick == 'd'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Tanjiro won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Dhruv won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Tanjiro is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Drhuv is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'P' || pick == 'p'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Tanjiro won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Phoebe won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Tanjiro is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Phoebe is the winner of the 7 rounds with a total of "+win2+" wins!");
               } 
               if (pick == 'A' || pick == 'a'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Tanjiro won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Aadhya won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Tanjiro is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Aadhya is the winner of the 7 rounds with a total of "+win2+" wins!");
               }   
               if (pick == 'Z' || pick == 'z'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Tanjiro won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Zenitsu won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Tanjiro is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Zenitsu is the winner of the 7 rounds with a total of "+win2+" wins!");
               }   
            
               break;
         /*
         Case 2 for the second character
         Include nested if statements to allow an outcome that is true when using an RNG 
         and comparing which number was higher from the RNG 
         The higher number is the winner and a message is displayed stating that character is the winner 
         */          
            case 'B':
            case 'b':
               if (pick == 'B' || pick == 'b'){
                  outFile.println("Invalid! You cannot fight against the same charcater!");
               }
               if (pick == 'T' || pick == 't'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Barack Obama won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Tanjiro won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Barack Obama is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Tanjiro is the winner of the 7 rounds with a total of "+win2+" wins!");
               }      
            
               if (pick == 'D' || pick == 'd'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Barack Obama won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Dhruv won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Barack Obama is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Drhuv is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'P' || pick == 'p'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Barack Obama won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Phoebe won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Barack Obama is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Phoebe is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'A' || pick == 'a'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Barack Obama won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Aadhya won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Barack Obama is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Aadhya is the winner of the 7 rounds with a total of "+win2+" wins!");
               }        
               if (pick == 'Z' || pick == 'z'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Barack Obama won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Zenitsu won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Barack Obama is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Zenitsu is the winner of the 7 rounds with a total of "+win2+" wins!");
               } 
            
               break;
         /*
         Case 3 for the third character
         Include nested if statements to allow an outcome that is true when using an RNG 
         and comparing which number was higher from the RNG 
         The higher number is the winner and a message is displayed stating that character is the winner 
         */         
            case 'D':
            case 'd':
               if (pick == 'D' || pick == 'd'){
                  outFile.println("Invalid! You cannot fight against the same charcater!");
               }
               if (pick == 'T' || pick == 't'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Dhruv won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Tanjiro won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Dhruv is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Tanjiro is the winner of the 7 rounds with a total of "+win2+" wins!");
               }      
               if (pick == 'B' || pick == 'b'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Dhruv won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Barack Obama won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Dhruv is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Barack Obama is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'P' || pick == 'p'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Dhruv won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Phoebe won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Dhruv is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Phoebe is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'A' || pick == 'a'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Dhruv won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Aadhya won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Dhruv is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Aadhya is the winner of the 7 rounds with a total of "+win2+" wins!");
               }          
               if (pick == 'Z' || pick == 'z'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Dhruv won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Zenitsu won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Dhruv is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Zenistu is the winner of the 7 rounds with a total of "+win2+" wins!");
               }   
            
               break;
         /*
         Case 4 for the fourth character
         Include nested if statements to allow an outcome that is true when using an RNG 
         and comparing which number was higher from the RNG 
         The higher number is the winner and a message is displayed stating that character is the winner 
         */ 
            case 'P':
            case 'p':
               if (pick == 'P' || pick == 'p'){
                  outFile.println("Invalid! You cannot fight against the same charcater!");
               }
               if (pick == 'T' || pick == 't'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Phoebe won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Tanjiro won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Phoebe is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Tanjiro is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'B' || pick == 'b'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Phoebe won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Barack Obama won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Phoebe is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Barack Obama is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'D' || pick == 'd'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Phoebe won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Dhruv won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Phoebe is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Dhruv is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'A' || pick == 'a'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Phoebe won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Aadhya won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Phoebe is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Aadhya is the winner of the 7 rounds with a total of "+win2+" wins!");
               }          
               if (pick == 'Z' || pick == 'z'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Phoebe won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Zenitsu won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Phoebe is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Zenitsu is the winner of the 7 rounds with a total of "+win2+" wins!");
               }   
            
               break;
         /*
         Case 5 for the fifth character
         Include nested if statements to allow an outcome that is true when using an RNG 
         and comparing which number was higher from the RNG 
         The higher number is the winner and a message is displayed stating that character is the winner 
         */        
            case 'A':
            case 'a':
               if (pick == 'A' || pick == 'a'){
                  outFile.println("Invalid! You cannot fight against the same charcater!");
               }
               if (pick == 'T' || pick == 't'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Aadhya won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Tanjiro won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Aadhya is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Tanjiro is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'D' || pick == 'd'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Aadhya won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Dhruv won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Aadhya is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Dhruv is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'P' || pick == 'p'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Aadhya won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Phoebe won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Aadhya is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Phoebe is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'B' || pick == 'b'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Aadhya won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Barack Obama won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Aadhya is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Barack Obama is the winner of the 7 rounds with a total of "+win2+" wins!");
               }          
               if (pick == 'Z' || pick == 'z'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Aadhya won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Zenitsu won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Aadhya is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Zenitsu is the winner of the 7 rounds with a total of "+win2+" wins!");
               }   
            
               break;
         /*
         Case 6 for the sixth character
         Include nested if statements to allow an outcome that is true when using an RNG 
         and comparing which number was higher from the RNG 
         The higher number is the winner and a message is displayed stating that character is the winner 
         */         
            case 'Z':
            case 'z':
               if (pick == 'Z' || pick == 'z'){
                  outFile.println("Invalid! You cannot fight against the same charcater!");
               }
               if (pick == 'T' || pick == 't')
               {
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Zenitsu won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Tanjiro won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Zenitsu is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Tanjiro is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'D' || pick == 'd'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Zenitsu won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Dhruv won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Zenitsu is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Dhruv is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'P' || pick == 'p'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Zenitsu won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Phoebe won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Zenitsu is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Phoebe is the winner of the 7 rounds with a total of "+win2+" wins!");
               }
               if (pick == 'B' || pick == 'b'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Zenitsu won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Barack Obama won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Zenitsu is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Barack Obama is the winner of the 7 rounds with a total of "+win2+" wins!");
               }          
               if (pick == 'A' || pick == 'a'){
                  outFile.println("-------------------------------");
                  outFile.println("RESULTS OF GAME");
                  outFile.println("-------------------------------");
                  win = 0;
                  win2 = 0;
                  for(int i=1; i <=7 ; i++){
                     if(RNG()==true)
                     {
                        win = win + 1;
                        outFile.println(i+". Zenitsu won this round!"); 
                     }
                     else
                     { 
                        win2 = win2 + 1;
                        outFile.println(i+". Aadhya won this round!");
                     }
                  }
                  if (win > win2)
                     outFile.println("Zenitsu is the winner of the 7 rounds with a total of "+win+" wins!");
                  else 
                     outFile.println("Aadhya is the winner of the 7 rounds with a total of "+win2+" wins!");
               }       		
               break;                         
         }
         
         System.out.println("\nWould you like to repeat the program? (Yes or No)");
         repeat = s.next();
      }
      
      //The while is connected to a do-while loop that allows the user to restart the program if they'd like to    
      while (repeat.equalsIgnoreCase("Yes"));
      //If, is connected to the do-while to see of the condition is true when the user doesn't enter "Yes", and ends the program     
      if (repeat != ("Yes")) {
         System.out.println("Thank you for using the program!");
         outFile.close(); //Closes the file that the results is printed to ("Hero_Results.txt")
      }
   }
}