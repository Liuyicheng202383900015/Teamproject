import java.util.Scanner;

public class GameTracker
{
    ScannerPro scannerPro = new ScannerPro();
    GameList gameList = new GameList();
    private void ShowMenu()
    {
        System.out.println("Game Menu(●'◡'●)");
        System.out.println("---------");
        System.out.println("     1. Add game");
        System.out.println("     2. List games played monthly");
        System.out.println("     3. Delete game");
        System.out.println("     4. Guess times of games");
        System.out.println("     5. Search game");
        System.out.println("     6. Exit");
        System.out.print(  "     ====>>>>╰(*°▽°*)╯ Please enter your choice(PS:Do not input the number which is not the six numbers otherwise the choices will appear again): ");
    }//construct a showMenu in order to introduce how to chooce it and provide the options

    private void addGame(){
        int times;
        System.out.println("Enter game name: ");
        String n = scannerPro.getString();
        System.out.println("Enter times played monthly: ");
        while ((times = scannerPro.getInt()) == Integer.MAX_VALUE){
            System.out.println("Wrong input Please input it again：");
        }
        gameList.addingGame(n, times);//"n" means name of the game and "t" means time played
    }

    private void listGame(){
        gameList.listGames();//list the array you want
    }

    private void deleteGame(){
    while (true) {
                   System.out.println("Enter game name to delete: ");//choose the game you want to delete
                   String deletingName = scannerPro.getString();//scan the game name
                   gameList.deleteGame(deletingName);//carry out the deletion command
                  }
    }

    private void guessTimes(){
        System.out.println("Which game do you want to guess times? ");
        String N = scannerPro.getString();//use N to store
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
            ScannerPro h=new ScannerPro();
            input= h.getInt();
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
    }

    private void searchGame() {
        /*
                    Before you search somethhing ,there are 2 modes now,completely or partly(blurrily),
                    you can choose one mode to search something
                     */
        while (true) {
            System.out.println("Which mode do you want to use(completely or partly) C/P ?  ");

            ScannerPro that = new ScannerPro();
            String opt = that.getString();

            ScannerPro it = new ScannerPro();

            if (opt.equals("C")) //judge if what you choose is Completely
            {
                System.out.println("Enter game name to search: ");
                String searchName = scannerPro.getString();
                Game findingGame = gameList.searchGamecompletely(searchName);
                if (findingGame != null) {
                    System.out.println(findingGame.getName() + " ----- " + findingGame.getTimesplayed() + " times played");
                    break;
                } else {
                    System.out.println("Game NOT FOUND 404");
                    break;
                }
            } else if (opt.equals("P")) //judge if what you choose is Paarly
            {
                System.out.println("Entre the part of the game name to search: ");
                String searchPartname = scannerPro.getString();
                Game foundGame = gameList.searchGamepartly(searchPartname);
                if (foundGame != null) {
                    System.out.println(foundGame.getName() + " ----- " + foundGame.getTimesplayed() + " times played");
                    break;
                } else {
                    System.out.println("Game NOT FOUND 404");
                    break;
                }
            } else {
                System.out.println("Please choose the correct option");
            }
        }
    }
    public void run(){
        System.out.println("Welcome to GameTracker Project!!!" );
        System.out.println("PS :The progamme is used to record times and kinds of the games which we have played)  Please click the enter");
        Scanner it = new Scanner(System.in);
        int number1;//"c"means choice
        it.nextLine();

        while (true)//use the procedure , you can always see the menu, the menu will exist all the time unless you exit by yourself
        {
            ShowMenu();

            while ((number1 = scannerPro.getInt()) == Integer.MAX_VALUE){
                System.out.print("Wrong input Please input it again：");
            }
            //get the number which you input from the scanner

            switch (number1)//use switch to choose the case you want
            {
                case 1:
                    addGame();
                    break;
                case 2:
                    listGame();
                    break;//finish this case
                case 3:
                    deleteGame();
                    break;//finish this cae
                case 4:
                    guessTimes();
                    break;
                case 5:
                    searchGame();
                    break;
                case 6:
                    System.out.println("Ending......................." +//exit from the programme
                            " Merry Christmas to David in advance!🎉🎉🎄🎄🎄🎉🎉");
                    break;
                default:
                    System.out.println("Wrong choice NOT FOUND 404,please choose again😊");//judge if you choose something wrong
            }
            if (number1 == 6)
            {
                break;
            }
        }

    }

    //Then this is the main body
    public static void main(String[] args)
    {
        GameTracker gameTracker = new GameTracker();
        gameTracker.run();
    }
}
