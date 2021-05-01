package controller;

import model.User;

import java.util.regex.Matcher;

public class MainController {
    private User user;

    public static MainController getInstance (User user){
    //TODO
    }

    private MainController(User user){
        this.user = user;
    }

    public boolean processCommand(String command){
        //TODO
        return true;
    }

    private void logOutUser(){
        //todo
    }

    private void newDuel (String username, int roundNumber){
        //todo
    }

    /*private Matcher getCommandMatcher (String command, String regex){
        //todo
    }*/

    private void goToMenu(String menu){
        //todo
    }

}
