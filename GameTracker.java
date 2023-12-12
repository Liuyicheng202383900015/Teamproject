import java.util.Scanner;//use scanner to get the input
public class GameTracker
{
    private static void ShowMenu()
    {
        System.out.println("Game Menu(●'◡'●)");
        System.out.println("---------");
        System.out.println("     1. Add game");
        System.out.println("     2. List games");
        System.out.println("     3. Delete game");
        System.out.println("     4. Guess times of games played this month");
        System.out.println("     5. Search game");
        System.out.println("     6. Exit");
        System.out.print(  "     ====>>>>╰(*°▽°*)╯ Please enter your choice(PS:Do not input the number which is not the six numbers otherwise the choices will appear again): ");
    }//construct a showMenu in order to introduce how to chooce it and provide the options

//Then this is the main body
    public static void main(String[] args)
    {
        System.out.println("Welcome to GameTracker Project!!!" );
        System.out.println("PS :The progamme is used to record times and kinds of the games which we have played)  Please click the enter  ");
        GameList gameList = new GameList();
        Scanner it = new Scanner(System.in);
        int c;//"c"means choice
        it.nextLine();//use enter to open the menu
        while (true)//use the procedure , you can always see the menu, the menu will exist all the time unless you exit by yourself
        {
            ShowMenu();
            while (!it.hasNextInt())
            {// I am sorry David, the code is which I learn from the Internet, and this is used to return if the choice is not an integer,it can confirm if you choose the right one
                System.out.println("Wrong input. Please enter the correct number.");
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
