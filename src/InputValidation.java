import java.util.Scanner;

public class InputValidation {
    private final Scanner scanner;
    InputValidation(Scanner scanner){
        this.scanner = scanner;
    }
    public int checkInt(){
        while(true){
            try{
                return Integer.parseInt(scanner.nextLine().trim());
            }
            catch(NumberFormatException e){
                System.out.print("Invalid Input, please try again: ");
            }
        }
    }
    public int checkRange(int min, int max){
        while(true){
            int value = checkInt();
            if(value >= min && value <= max){
                return value;
            }
            else{
                System.out.println("Invalid input");
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            }
        }
    }
    public String checkString(String text){
        while(true){
            try{
                return scanner.nextLine().trim();
            }
            catch(IllegalArgumentException e){
                System.out.println("Wrong input, please try again: ");
            }
            catch(Exception e){
                System.out.println("Something went wrong. Please try again: ");
            }
        }
    }
}