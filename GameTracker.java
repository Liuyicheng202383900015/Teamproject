import java.util.Random;//use random
import java.util.Scanner;//use some scanner although I use scannerpro mostly

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
        Random random = new Random();
        int randomNumber = random.nextInt(101);//use random to generate a number which is between 0 and 100 (【0，101）
        System.out.println("Enter game name: ");
        String n = scannerPro.getString();
        gameList.addingGame(n, randomNumber);//"n" means name of the game and "t" means time played
    }

    private void listGame(){
        gameList.listGames();//list the array you want
    }

    private void deleteGame() {
        boolean continueDeleting = true;//define the continueDeleting is true

        while (continueDeleting) {//if it is ture ， it carries out again
            System.out.println("Enter game name to delete: ");
            String deletingName = scannerPro.getString();//use scanner
            boolean isDeleted = gameList.deleteGame(deletingName);

            if (isDeleted) {
                System.out.println("Game deleted successfully.");
            } else {
                System.out.println("Game not found.");
            }
            if (gameList.getNumberOfgames() == 0) {
                System.out.println("No more games to delete. Let us return to menu.");
                break;//find no games,return to menu
            }
            else {
                System.out.println("Do you want to continue deleting games? (Y/N)");
            }//determine if you want to continue 
            String choice = scannerPro.getString();
            if (!choice.equalsIgnoreCase("Y")) {
                continueDeleting = false;
            }
        }
    }

    private void guessTimes() {

        System.out.println("Which game do you want to guess times? ");
        Game g ;//"g"means game
        while ((g=gameList.searchGamecompletely(scannerPro.getString()))==null){
            System.out.println("Game NOT FOUND 404");
            System.out.print("Please input the correct name: ");
        }
        int m = g.getTimesplayed();//carry out the "getTimesplayed()"command, get the times
        int input = 0;//originate the value of input
        int attempt = 0;//originate the value of attempt
                    /*This is a guessing games to guess the times of the game that other teammembers have played
                    use while and if code
                     */
        System.out.println("Which times? ");
        while (input != m)
        {
            attempt++;
            ScannerPro h = new ScannerPro();
            input = h.getInt();
            if (input > m) {
                System.out.println("too large, try again");
            } else if (input < m) {
                System.out.println("too small try again");
            } else {
                System.out.println("Good job, well done");
                break;
            }
            if (attempt >= 10) {
                System.out.println("Sorry, your attempts are over 10 times, game over");
                break;
            }
        }
        System.out.println("Your final times number is " + attempt);

    }


    private void searchGame2(){// the total search
        System.out.println("Which mode do you want to use(completely or partly) C/P ?  ");
        String opt = scannerPro.getString();

        while (true){
            if (opt.equalsIgnoreCase("C") || opt.equalsIgnoreCase("P")) break;//determine if you choose P/C if you choose others, it will tell you to input again
            else{
                System.out.println("Game NOT FOUND 404");
                System.out.print("Please input the correct Game: ");
                opt = scannerPro.getString();
            }
        }

        if (opt.equalsIgnoreCase("C")){
            searchGameC();
        }else {
            searchGameP();
        }

    }
    private void searchGameC(){//the complete search
        String gameName;
        Game findingGame;
        while (true){
            System.out.print("Enter game name to search[N]: ");
            gameName = scannerPro.getString();
            if (gameName.equalsIgnoreCase("N")) break;
            findingGame = gameList.searchGamecompletely(gameName);
            if (findingGame == null) {
                System.out.println("Game NOT FOUND 404");
                System.out.print("Enter game name to search[N](if you choose N/n it will end at last): ");
                continue;
            }
                System.out.println(findingGame.getName() + " ----- " + findingGame.getTimesplayed() + " times played");
        }
    }
    private void searchGameP(){// the partial search
        String gameName;
        Game findingGame;
        while (true){
            System.out.print("Enter game name to search[N](if you choose N/n it will end at last): ");//determine if you want to end search 
            gameName = scannerPro.getString();
            if (gameName.equalsIgnoreCase("N")) break;
            findingGame = gameList.searchGamepartly(gameName);
            if (findingGame == null) {
                System.out.println("Game NOT FOUND 404");
                System.out.print("Enter game name to search[N](if you choose N/n it will end at last): ");//determine if you want end search
                continue;//to end this time of circulation
            }
            System.out.println(findingGame.getName() + " ----- " + findingGame.getTimesplayed() + " times played");
        }
    }
    public void run(){//use run to simplify the "main" way
         System.out.println("Welcome to GameTracker Project!!!" );
        System.out.println("PS :The progamme is used to record times and kinds of the games which we have played)  Please click the enter");
        Scanner it = new Scanner(System.in);
        int number1;//"number1"means choice
        it.nextLine();

        while (true)//use the procedure , you can always see the menu, the menu will exist all the time unless you exit by yourself
        {
            ShowMenu();
            //get the number1 which you input from the scannerpro
            number1=scannerPro.getInt();//number1 means choice
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
                    break;//finish the circulation
                case 5:
                    searchGame2();
                    break;
                case 6:
                    System.out.println("Ending......................." +//exit from the programme
                            " Merry Christmas to David in advance!🎉🎉🎄🎄🎄🎉🎉");//some celeberation to David
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
        GameTracker gameTracker = new GameTracker();//use the class GameTracker
        gameTracker.run();//use run to simplify the “main” way, it may be more simple
    }
}


