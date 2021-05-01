package controller;

import model.Card;
import model.User;
import view.ShopView;


import java.util.regex.Matcher;

public class ShopController {
    private static ShopController instance = null;
    private User user;

    private ShopController(User user){ this.user = user; }

    public static ShopController getInstance(User user){
        if (instance == null) instance = new ShopController(user);
        else instance.user = user;
        return instance;
    }



    public boolean processCommand (String command){

    }

    private void buyCard(String name){
        Card card = user.getCardByName(name);
        if (card != null){

        }
        else
            ShopView.

    }

    private void showAll(){

    }

    private Matcher getCommandMatcher(String command, String regex){

    }

    //TODO nemidunam ino chejuri bayad bezanam
    private void logOUtUser(){

    }
}
