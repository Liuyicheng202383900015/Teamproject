import java.util.Scanner;
public class GameTracker
{
    private static void ShowMenu()
    {
        System.out.println("Game Menu(●'◡'●)");
        System.out.println("---------");
        System.out.println("     1. Add game");
        System.out.println("     2. List games");
        System.out.println("     3. Delete game");
        System.out.println("     4. Guess times of games");
        System.out.println("     5. Search game");
        System.out.println("     6. Exit");
        System.out.print(  "   ====>>>>╰(*°▽°*)╯ Please enter your choice(PS:Do not input the number which is not the six numbers otherwise the choices will appear again): ");
    }//construct a showMenu in order to introduce how to chooce it and provide the options

//Then this is the main body
    public static void main(String[] args)
    {
        System.out.println("Welcome to GameTracker Project(the progamme is used to record times and kinds of the games which we have played) Please click the enter");
        GameList gameList = new GameList();
        Scanner it = new Scanner(System.in);
        int c;//"c"means choice
        it.nextLine();
        while (true)//use the procedure , you can always see the menu, the menu will exist all the time unless you exit by yourself
        {
            ShowMenu();

            while (!it.hasNextInt()) {// I am sorry David, the code is which I learn from the Internet, and this is used to return if the choice is not an integer,it can confirm if you choose the right one
                System.out.println("Wrong input. Please enter a correct number in order to restore it.");
                it.next();
            }
            c = it.nextInt();//get the number which you input from the scanner

            switch (c)//use switch to choose the case you want
            {
                case 1:
                    System.out.println("Enter game name: ");
                    String n = it.next();
                    System.out.println("Enter times played: ");
                    while (!it.hasNextInt()) {
                        System.out.println("Wrong input. Please enter a number.");
                        it.next();//judge whether you input a right number choice
                    }
                    int t= it.nextInt();//store the value of the number that you input in "t"
                    gameList.addingGame(n, t);//"n" means name of the game and "t" means times played
                    break;
                case 2:
                    gameList.listGames();//list the array you want

                    break;//finish this case
                case 3:
                    System.out.println("Enter game name to delete: ");//choose the game you want to delete
                    String deletingName = it.next();//scan the game name
                    gameList.deleteGame(deletingName);//carry out the deletion command
                    break;//finish this cae
                case 4:
                    System.out.println("Which game do you want to guess times? ");
                    String N = it.next();//use N to store
                    Game g = gameList.searchGamecompletely(N);//"g"means game
                    int m= g.getTimesplayed();//carry out the "getTimesplayed()"command, get the times
                    int input=0;//originate the value of input
                    int attempt=0;//originate the value of attempt
                    /*This is a guessing games to guess the times of the game that other teammembers have played
                    use while and if code
                     */
                    System.out.println("Which times? ");
                    if (g != null)
                    {while (input!=m){
                        attempt++;
                        Scanner h=new Scanner(System.in);
                        input= h.nextInt();
                        if (input > m) {
                            System.out.println("too large, try again");
                        }
                        else if (input < m)
                        {
                            System.out.println("too small try again");
                        }
                        else
                        {
                            System.out.println("Good job, well done");
                            break;
                        }
                        if (attempt>=10){
                            System.out.println("Sorry, your attempts are over 10 times, game over");
                            break;
                        }
                    }
                        System.out.println("Your final times number is "+attempt);

                    } else
                    {
                        System.out.println("Game not found 404");//if there are not games , output this sentence
                    }
                    break;
                case 5:
                    /*
                    Before you search somethhing ,there are 2 modes now,completely or partly(blurrily),
                    you can choose one mode to search something
                     */
                    System.out.println("Which mode do you want to use(completely or partly) C/P ?  ");
                    Scanner that=new Scanner(System.in);
                    String opt=that.nextLine();
                    if (opt.equals("C")) //judge if what you choose is Completely
                    {
                        System.out.println("Enter game name to search: ");
                        String searchName = it.next();
                        Game findingGame = gameList.searchGamecompletely(searchName);
                    if (findingGame != null)
                    {
                        System.out.println(findingGame.getName() + " ----- " + findingGame.getTimesplayed() + " times played");
                    } else
                    {
                        System.out.println("Game NOT FOUND 404");
                    }
                    break;
                    }
                    else if (opt.equals("P")) //judge if what you choose is Paarly
                    {
                        System.out.println("Entre the part of the game name to search: ");
                        String searchPartname=it.next();
                        Game foundGame =gameList.searchGamepartly(searchPartname);
                        if (foundGame != null)
                        {
                            System.out.println(foundGame.getName() + " ----- " + foundGame.getTimesplayed() + " times played");
                        }else
                        {
                            System.out.println("Game NOT FOUND 404");
                        }
                        break;}

                case 6:
                    System.out.println("Ending......................." +//exit from the programme
                                       " Merry Christmas to David in advance!🎉🎉🎄🎄🎄🎉🎉");
                    break;
                default:
                    System.out.println("Wrong choice NOT FOUND 404,please choose again😊");//judge if you choose something wrong
            }
            if (c == 6)
            {
                break;
            }
        }
    }
}


class Game//This is the game class
{
    private String name;
    private int timesPlayed;//wrap some attributes

    public Game(String name, int timesPlayed)
    {
        this.name = name;
        this.timesPlayed = timesPlayed;
    }//set the access location for the 2 attributes

    public String getName()
    {
        return name;
    }
    public int getTimesplayed()
    {
        return timesPlayed;
    }//set the access location
    public void setTimesPlayed(int timesPlayed)
    {
        this.timesPlayed = timesPlayed;
    }//set the access location

}

//another class
class GameList
{
    private Game[] games;
    private int numberOfgames;//wrap the arrays and the number of games attributes

    public GameList()
    {
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
            if (replacementChoice.equals("Y"))
            {
                existingGame.setTimesPlayed(timesPlayed);
                System.out.println("Replacing existing game successfully");
                return;
            } else
            {
                System.out.println("The game was not replaced, it still exists.");
                return;
            }//replace something or not, it is of great significance
        }
           else
        {
            Game newGame = new Game(name, timesPlayed);
            games[numberOfgames] = newGame;
            numberOfgames++;
            System.out.println("Adding successfully");//if it is not the repetition of the one before
        }

    }
    public void listGames()
    {
        if (numberOfgames == 0) //if the number of the games in the array is 0, print NO games
    {
        System.out.println("No games are in the list.");
    }
    else
    {
        for (int i = 0; i < numberOfgames; i++)
        {
            System.out.println(games[i].getName() + " ----- " + games[i].getTimesplayed() + " times played");
        }
    }//use the circulation to print all the name in the array and use the array to output times
    }



    public void deleteGame(String name)
    {
        for (int i = 0; i < numberOfgames; i++)
        {
            if (games[i].getName().equals(name))
            {
                for (int j = i; j < numberOfgames - 1; j++)
                {
                    games[j] = games[j + 1];
                }
                numberOfgames--;
                break;
            }//use "for" search for the objective in every location in order to find which I want to delete
        }
    }

    public Game searchGamecompletely(String name)
    {
        for (int i = 0; i < numberOfgames; i++)
        {
            if (games[i].getName().equals(name))
            {
                return games[i];
            }
        }
        return null;
    }//the complete searching, it is as the same as the deleting command

    public Game searchGamepartly(String name)
    {
        for (int i = 0; i < numberOfgames; i++)
        {
            if (games[i].getName().contains(name))
            {
                return games[i];
            }
        }
        return null;//use contain rather than match, it is the knowledge I learn from the reference books and the Internet, "contain" can also search the part of the object in the array
    }
}
