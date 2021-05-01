package view;

import model.User;
import java.util.Scanner;

public class LogInView {

    Scanner scanner = ScannerClassForView.getScanner();
    private void getCommandForLogin(){
        String input = scanner.nextLine();
        // TODO call kon
    }
    public void printException(Exception output){

    }
    public void printText(String output){
        System.out.println(output);
    }
    public void goToMainMenu(User user){

    }
    public void exit(){
       System.exit(0);
    }
}
