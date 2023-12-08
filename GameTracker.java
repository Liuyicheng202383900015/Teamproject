import java.util.Scanner;

public class GameTracker
{
    public static void ShowMenu()
    {

        System.out.println("Game Menu(●'◡'●)");
        System.out.println("---------");
        System.out.println("     1. Add game");
        System.out.println("     2. List games");
        System.out.println("     3. Delete game");
        System.out.println("     4. Play game");
        System.out.println("     5. Search game");
        System.out.println("     6. Exit");
        System.out.print("====>>>>╰(*°▽°*)╯ Please enter your choice(Do not input the number which is not the six numbers otherwise the choices will appear again): ");
    }
    public static void main(String[] args)
    {
        System.out.println("GameTracker Project(the progamme is used to record times and kinds of the games which we have played)");
        GameList gameList = new GameList();
        Scanner it = new Scanner(System.in);
        int c;//"c"means choice

        while (true)
        {
            ShowMenu();

            while (!it.hasNextInt()) {// I am sorry David, the code is from the Internet, and this is used to return if the choice is not an integer
                System.out.println("Wrong input. Please enter a correct number in order to restore it.");
                it.next();
            }
            c = it.nextInt();



            switch (c)
            {
                case 1:
                    System.out.println("Enter game name: ");
                    String n = it.next();

                    System.out.println("Enter times played: ");

                    while (!it.hasNextInt())
                    {
                        System.out.println("Wrong input. Please enter a number.");
                        it.next();
                    }

                    int t= Integer.parseInt(it.nextLine());
                    gameList.addGame(n, t);//"n"means name of the play and "t"means times played

                    System.out.println("Adding successfully");

                    break;
                case 2:
                    gameList.listGames();
                    break;
                case 3:
                    System.out.println("Enter game name to delete: ");
                    String deleteName = it.next();
                    gameList.deleteGame(deleteName);
                    break;
                case 4:
                    System.out.println("Enter game name to play: ");
                    String Name = it.next();
                    Game g = gameList.searchGame(Name);//"g"means game
                    if (g != null)
                    {
                        g.playGame();
                    } else {
                        System.out.println("Game not found");
                    }
                    break;
                case 5:
                    System.out.println("Enter game name to search: ");
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

            if (c == 6)
            {
                break;
            }
        }
    }
}


class Game
{
    private String name;
    private int timesPlayed;

    public Game(String name, int timesPlayed)
    {
        this.name = name;
        this.timesPlayed = timesPlayed;
    }

    public String getName()
    {

        return name;
    }

    public int getTimesPlayed()
    {
        return timesPlayed;
    }

    public void playGame()
    {
        timesPlayed++;
    }
}

class GameList
{
    private Game[] games;
    private int numGames;

    public GameList()
    {
        games = new Game[100];
        numGames = 0;
    }

    public void addGame(String name, int timesPlayed)
    {
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
            if (games[i].getName().equalsIgnoreCase(name))
            {
                for (int j = i; j < numGames - 1; j++)
                {
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
