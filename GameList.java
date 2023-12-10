import java.util.Scanner;

//another class
class GameList {
    private Game[] games;
    private int numberOfgames;//wrap the arrays and the number of games attributes

    public GameList() {
        games = new Game[100];
        numberOfgames = 0;//originate the array
    }

    public void addingGame(String name, int timesPlayed)//set procedure to add games
    {
        Game existingGame = searchGamecompletely(name);
        if (existingGame != null) {
            System.out.println("Game with the same name already exists: " + existingGame.getName());
            System.out.print("Would you like to replace it? (Yes/No) Y/N : ");
            Scanner it = new Scanner(System.in);
            String replacementChoice = it.next();//judge if the adding things have existed and ask if you want to replace it by arrays
/*
the procedure also uses the function of searching
 */
            if (replacementChoice.equals("Y")) {
                existingGame.setTimesPlayed(timesPlayed);
                System.out.println("Replacing existing game successfully");
                return;
            } else {
                System.out.println("The game was not replaced, it still exists.");
                return;
            }//replace something or not, it is of great significance
        } else {
            Game newGame = new Game(name, timesPlayed);
            games[numberOfgames] = newGame;
            numberOfgames++;
            System.out.println("Adding successfully");//if it is not the repetition of the one before
        }

    }

    public void listGames() {
        if (numberOfgames == 0) //if the number of the games in the array is 0, print NO games
        {
            System.out.println("No games are in the list.");
        } else {
            for (int i = 0; i < numberOfgames; i++) {
                System.out.println(games[i].getName() + " ----- " + games[i].getTimesplayed() + " times played");
            }
        }//use the circulation to print all the name in the array and use the array to output times
    }


    public void deleteGame(String name) {
        for (int i = 0; i < numberOfgames; i++) {
            if (games[i].getName().equals(name)) {
                for (int j = i; j < numberOfgames - 1; j++) {
                    games[j] = games[j + 1];
                }
                numberOfgames--;
                break;
            }//use "for" search for the objective in every location in order to find which I want to delete
        }
    }

    public Game searchGamecompletely(String name) {
        for (int i = 0; i < numberOfgames; i++) {
            if (games[i].getName().equals(name)) {
                return games[i];
            }
        }
        return null;
    }//the complete searching, it is as the same as the deleting command

    public Game searchGamepartly(String name) {
        for (int i = 0; i < numberOfgames; i++) {
            if (games[i].getName().contains(name)) {
                return games[i];
            }
        }
        return null;//use contain rather than match, it is the knowledge I learn from the reference books and the Internet, "contain" can also search the part of the object in the array
    }
}
