package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice();

        //ask how many players

        try {
            int numberOfPlayers = Console.promptForInt("How many players are there? ");
            /ask name of each player
            String[] playerNames = new String[numberOfPlayers];

            for (int playerNumber = 1; playerNumber <= numberOfPlayers; playerNumber++) {
                int playerIndex = playerNumber - 1;
                playerNames[playerIndex] = Console.promptForString("Name of player " + playerNumber + ": ");
            }

            System.out.println(numberOfPlayers);
            for (String s : playerNames) {
                System.out.println(s);
            }

            //each player should roll
            int[] rolls = new int[numberOfPlayers];

            for (int playerNumber = 1; playerNumber <= numberOfPlayers; playerNumber++) {
                int playerIndex = playerNumber - 1;
                rolls[playerIndex] = dice.roll();
                System.out.printf("%s rolled a %d\n", playerNames[playerIndex], rolls[playerIndex]);
            }

            int highestRoll = rolls[0];
            for (int roll : rolls) {
                if (roll > highestRoll) {
                    highestRoll = roll;
                }
            }

            int numberOfHighestRolls = 0;
            for (int roll : rolls) {
                if (roll == highestRoll) {
                    numberOfHighestRolls++;
                }
            }

            //is there a tie?
            boolean isTie = (numberOfHighestRolls > 1);

            if (isTie) { // is a tie

                int printedNameCounter = 0;

                System.out.print("It's a tie between: ");

                for (int playerNumber = 1; playerNumber <= numberOfPlayers; playerNumber++) {
                    int playerIndex = playerNumber - 1;
                    if (rolls[playerIndex] == highestRoll) {

                        System.out.print(playerNames[playerIndex]);
                        printedNameCounter++;

                        //is it the last name?
                        if (printedNameCounter == numberOfHighestRolls) {
                            System.out.print(".");
                        } else {
                            System.out.print(", ");
                        }
                    }
                }
            } else { //not a ties
                for (int playerNumber = 1; playerNumber <= numberOfPlayers; playerNumber++) {
                    int playerIndex = playerNumber - 1;
                    if (rolls[playerIndex] == highestRoll) {
                        System.out.println(playerNames[playerIndex] + " is a winner!");
                    }
                }
            }
        }

        catch (Exception e){
            System.out.println("Please enter a valid number between 1-4.");
        }
    }
}
