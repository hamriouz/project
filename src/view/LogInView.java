package view;

import model.User;
import java.util.Scanner;

public class LogInView {

    private static LogInView instance = null;
    private User user;

    public LogInView(User user) {
    }

    public static LogInView getInstance(User user) {
        if (instance == null) instance = new LogInView(user);
        else instance.user = user;
        return instance;
    }



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
