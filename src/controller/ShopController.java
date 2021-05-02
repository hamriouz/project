package controller;

import model.Card;
import model.User;
import view.ShopView;


import java.util.regex.Matcher;

public class ShopController {

    //todo get instance
    private static ShopController instance = null;
    private User user;

    private ShopController(User user) {
        this.user = user;
    }


    private void buyCard(String name) {
        Card card = user.getCardByName(name);
        if (card != null) {
            if (user.getMoney() >= card.getPrice()) {
                user.decreaseMoney(card.getPrice());
                user.addCardToUsersAllCards(card);
            } else
                ShopView.getInstance(this.user).printText("not enough money");
        } else
            ShopView.getInstance(this.user).printText("there is no card with this name");

    }

    //TODO arraylist bezarim?
    private void showAll() {

    }


    //TODO nemidunam ino chejuri bayad bezanam
    private void logOUtUser() {

    }
}
