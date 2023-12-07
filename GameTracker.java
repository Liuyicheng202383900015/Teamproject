import java.util.Scanner;

public class GameTracker
{
    public static void ShowMenu()
    {

        System.out.println("Game Menu(●'◡'●)");
        System.out.println("---------");
        System.out.println("    1. Add game");
        System.out.println("    2. List games");
        System.out.println("    3. Delete game");
        System.out.println("    4. Play game");
        System.out.println("    5. Search game");
        System.out.println("    6. Exit");
        System.out.print("====>>>>╰(*°▽°*)╯ Please enter your choice(Do not input the number which is not the six numbers otherwise the choices will appear again): ");
    }
    public static void main(String[] args)
    {
        GameList gameList = new GameList();
        Scanner it = new Scanner(System.in);
        int choice;

        while (true)
        {
            ShowMenu();

            while (!it.hasNextInt()) {// I am sorry David, the code is from the Internet, and this is used to return if the choice is not an integer
                System.out.println("Wrong input. Please enter a correct number in order to restore it.");
                it.next();
            }
            choice = it.nextInt();



            switch (choice)
            {
                case 1:
                    System.out.print("Enter game name: ");
                    String name = it.next();
                    System.out.print("Enter times played: ");

                    while (!it.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        it.next();
                    }

                    int timesPlayed = it.nextInt();
                    gameList.addGame(name, timesPlayed);
                    break;
                case 2:
                    gameList.listGames();
                    break;
                case 3:
                    System.out.print("Enter game name to delete: ");
                    String deleteName = it.next();
                    gameList.deleteGame(deleteName);
                    break;
                case 4:
                    System.out.println("Enter game name to play: ");
                    String playName = it.next();
                    Game game = gameList.searchGame(playName);
                    if (game != null) {
                        game.playGame();
                    } else {
                        System.out.println("Game not found");
                    }
                    break;
                case 5:
                    System.out.print("Enter game name to search: ");
                    String searchName = it.next();
                    Game foundGame = gameList.searchGame(searchName);
                    if (foundGame != null) {
                        System.out.println(foundGame.getName() + " - " + foundGame.getTimesPlayed() + " times played");
                    } else {
                        System.out.println("Game not found");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Wrong choice NOT FOUND 404,please choose again😊");
            }

            if (choice == 6)
            {
                break;
            }
        }
    }
}


class Game {
    private String name;
    private int timesPlayed;

    public Game(String name, int timesPlayed) {
        this.name = name;
        this.timesPlayed = timesPlayed;
    }

    public String getName() {
        return name;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void playGame() {
        timesPlayed++;
    }
}

class GameList {
    private Game[] games;
    private int numGames;

    public GameList() {
        games = new Game[100];
        numGames = 0;
    }

    public void addGame(String name, int timesPlayed) {
        Game newGame = new Game(name, timesPlayed);
        games[numGames] = newGame;
        numGames=numGames+1;
    }

    public void listGames()
    {
        for (int i = 0; i < numGames; i=i+1) {
            System.out.println(games[i].getName() + " - " + games[i].getTimesPlayed() + " times played");
        }
    }

    public void deleteGame(String name)
    {
        for (int i = 0; i < numGames; i++) {
            if (games[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < numGames - 1; j++) {
                    games[j] = games[j + 1];
                }
                numGames=numGames-1;
                break;
            }
        }
    }

    public Game searchGame(String name)
    {
        for (int i = 0; i < numGames; i++)
        {
            if (games[i].getName().toLowerCase().contains(name.toLowerCase()))
            {
                return games[i];
            }
        }
        return null;
    }
}