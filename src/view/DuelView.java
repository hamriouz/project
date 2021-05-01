package view;

import model.User;

import java.util.Scanner;

public class DuelView {
    private User user;
    Scanner scanner = ScannerClassForView.getScanner();
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
return "1";
    }
    public String getAnswerForActivateSpellOrTrapInRivalsTurn(){
return "1";
    }
    public void getBackForShowGraveYard(){

    }
}
