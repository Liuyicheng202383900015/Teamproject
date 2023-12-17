import java.util.Scanner;
class ScannerPro{
    private Scanner Scan;

    public String getString(){
        Scan = new Scanner(System.in);
        return Scan.nextLine();
    }

    public int getInt(){
        Scan = new Scanner(System.in);
        try {
            String temp = getString();
            return Integer.parseInt(temp);
        }catch (NumberFormatException e){ return Integer.MAX_VALUE;}
    }

    public int getInt(String message){
        Scan = new Scanner(System.in);
        while (true){
            try {
                String temp = getString();
                return Integer.parseInt(temp);
            }catch (NumberFormatException ignored){
                System.out.print(message);
            }
        }
    }

    public double getDouble(){
        Scan = new Scanner(System.in);
        try {
            String temp = getString();
            return Double.parseDouble(temp);
        }catch (NumberFormatException e){ return Double.MAX_VALUE;}
    }

    public double getDouble(String message){
        Scan = new Scanner(System.in);
        while (true){
            try {
                String temp = getString();
                return Double.parseDouble(temp);
            }catch (NumberFormatException ignored){
                System.out.print(message);
            }
        }
    }
}

