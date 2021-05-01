package view;

import model.User;

import java.util.Scanner;

public class DualView {
    private User user;
    Scanner scanner = ScannerClassForView.setScanner();
    private void getCommandForDuel(){
        String input = scanner.nextLine();
        // TODO call kon
    }
    public void exitMenu(){
        //TODO MainView ro CALL KON
    }
    public void printException(Exception output){

    }
    public void printText(String output){
        System.out.println(output);
    }
    public String getCardForTribute(){

    }
    public String getAnswerForActivateSpellOrTrapInRivalsTurn(){

    }
    public void getBackForShowGraveYard(){

    }
}
