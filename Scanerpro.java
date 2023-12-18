import java.util.Scanner;//use scanner
class ScannerPro{//I want to create a new way to scan
    private Scanner Scan;

    public String getString(){
        Scan = new Scanner(System.in);
        return Scan.nextLine();
    } //use scan to store some

    public int getInt(){
        Scan = new Scanner(System.in);
        try {
            String temp = getString();
            return Integer.parseInt(temp);
        }catch (NumberFormatException e){ return Integer.MAX_VALUE;}
    }//use try catch to catch something wrong

    public int getInt(String message){
        Scan = new Scanner(System.in);
        while (true){//use while
            try {
                String temp = getString();
                return Integer.parseInt(temp);
            }catch (NumberFormatException ignored){
                System.out.print(message);
            }//another way to choose the right number to input it
        }
    }

    public double getDouble(){
        Scan = new Scanner(System.in);
        try {
            String temp = getString();
            return Double.parseDouble(temp);
        }catch (NumberFormatException e){ return Double.MAX_VALUE;}
    }//the way to get types of double

    public double getDouble(String message){
        Scan = new Scanner(System.in);
        while (true){
            try {
                String temp = getString();
                return Double.parseDouble(temp);
            }catch (NumberFormatException ignored){
                System.out.print(message);
            }//use message to store the sentence"wrong input........
        }
    }
}
