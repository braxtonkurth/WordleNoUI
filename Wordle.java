import java.util.Scanner;
import java.util.Random;
class Wordle{
    public static void main(String[] args){
        final String green = "\u001b[42m";
        final String yellow = "\u001b[43m";
        final String reset = "\u001b[0m";

        String[] words = {"DRILL", "FIBER", "RIBRE", "FUNNY", "DRINK", "FIELD", "DRIVE", "SWIFT", "FIFTH", "GIANT", "GIVEN", "DROVE", "GLASS", "DYING", "FIGHT", "GLOBE", "GLOVE", "ABOUT", "ABOVE", "ABUSE", "ACTOR", "ACUTE"};
        int index = (int)(Math.random() * (words.length - 1));
        String correct = words[index];
        String guess = "";
        Scanner scanner = new Scanner(System.in);
        for(int j = 0; j < 6; j++){
            System.out.print("Guess #" + (j + 1) + ": ");
            guess = scanner.nextLine().toUpperCase();
            if(guess.length() != 5){
                System.out.println("Please enter a 5 letter word.");
                j--;
                continue;
            }
            for(int i = 0; i < 5; i++){
                if(guess.substring(i, i + 1).equals(correct.substring(i, i + 1))){
                    System.out.print(green + guess.substring(i, i + 1) + reset); //letter matches
                }
                else if(correct.indexOf(guess.substring(i, i + 1)) > -1){
                    System.out.print(yellow + guess.substring(i, i + 1) + reset); //in word but different location
                }
                else{
                    System.out.print(guess.substring(i, i + 1)); //letter not in word
                }
            }
            System.out.println("");

            if(guess.equals(correct)){
                System.out.println("Correct!");
                System.exit(0);
            }
        }
        if(!guess.equals(correct)){
            System.out.println("You lost! The correct word was " + correct + ".");
        }
    }
}