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
            System.out.print("Wrong option Please input it again：");
        }
        gameList.addingGame(n, times);//"n" means name of the game and "t" means time played
    }

    private void listGame(){
        gameList.listGames();//list the array you want
    }

    private void deleteGame() {
        boolean continueDeleting = true;

        while (continueDeleting) {
            System.out.println("Enter game name to delete: ");
            String deletingName = scannerPro.getString();
            boolean isDeleted = gameList.deleteGame(deletingName);

            if (isDeleted) {
                System.out.println("Game deleted successfully.");
            } else {
                System.out.println("Game not found.");
            }
            if (gameList.getNumberOfgames() == 0) {
                System.out.println("No more games to delete. Let us return to menu.");
                break;
            }
            else {
                System.out.println("Do you want to continue deleting games? (Y/N)");
            }
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
                while (input != m) {
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


    private void searchGame() {
        /*
                    Before you search somethhing ,there are 2 modes now,completely or partly(blurrily),
                    you can choose one mode to search something
                     */
        System.out.println("Which mode do you want to use(completely or partly) C/P ?  ");
        while (true) {

            ScannerPro that = new ScannerPro();
            String opt = that.getString();

            ScannerPro it = new ScannerPro();

            if (opt.equalsIgnoreCase("C")) //judge if what you choose is Completely
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
            } else if (opt.equalsIgnoreCase("P")) //judge if what you choose is Paarly
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
                System.out.print("Please choose the correct option: ");
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
            //get the number which you input from the scanner
            number1=scannerPro.getInt();
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


