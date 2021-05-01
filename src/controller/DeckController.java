package controller;

import model.*;
import view.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeckController {
    private static DeckController instance = null;
    private User user;

    //TODO
    public boolean processCommand (String command){

    }

    private DeckController(User user) {
        this.user = user;
    }

    public static DeckController getInstance(User user) {
        if (instance == null) instance = new DeckController(user);
        else instance.user = user;
        return instance;
    }

    public void createDeck(String name) {
        if(this.user.getDeckByName(name) == null) {
            Deck deck = new Deck(name);
            this.user.addDeck(deck);
            DeckView.getInstance(this.user).printText("deck created successfully!");

        }
        else
            DeckView.getInstance(this.user).printText("deck with name " + name  + " already exists");

    }

    public void deleteDeck(String name) {
        if (this.user.getDeckByName(name) != null) {
            this.user.deleteDeck(name);
            DeckView.getInstance(this.user).printText("deck deleted successfully");

        }
        else
            DeckView.getInstance(this.user).printText("deck with name " + name + " does not exist");

    }

    public void activateDeck(String name) {
        if (this.user.getDeckByName(name) != null) {
            user.setActiveDeck(user.getDeckByName(name));
            DeckView.getInstance(this.user).printText("deck activated successfully");

        }
        else
            DeckView.getInstance(this.user).printText("deck with name " + name + " does not exist");

    }

    public void addCardToDeck(String cardName, String deckName, boolean isSide) {
        Card card = user.getCardByName(cardName);
        if (card != null){
            Deck deck = user.getDeckByName(deckName);
            if (deck != null) {
                if (isSide) {
                    if (deck.isValid()) {
                        //TODO 3 TA CARD TU DECK
                        deck.addCardToSideDeck(card);
                        DeckView.getInstance(this.user).printText("card added to deck successfully");
                    }
                    else
                        DeckView.getInstance(this.user).printText("side deck is full");
                } else {
                    if (deck.isValid()) {
                        //TODO 3 TA CARD TU DECK
                        deck.addCardToMainDeck(card);
                        DeckView.getInstance(this.user).printText("card added to deck successfully");

                    }
                    DeckView.getInstance(this.user).printText("main deck is full");
                }
            }
            else
                DeckView.getInstance(this.user).printText("deck with name " + cardName + " does not exist");
        }
        else
            DeckView.getInstance(this.user).printText("card with name " + deckName + " does not exist");


    }

    public void removeCardFromDeck(String cardName, String deckName, boolean isSide) {
        Deck deck = user.getDeckByName(deckName);
        if (deck != null) {
            Card card = user.getCardByName(cardName);
            if (card != null) {
                if (isSide) deck.removeCardFromSideDeck(card);
                else deck.removeCardFromMainDeck(card);
            }
            else
                if (isSide)
                DeckView.getInstance(this.user).printText("card with name " + deckName + " does not exist in side deck");
                else
                    DeckView.getInstance(this.user).printText("card with name " + deckName + " does not exist in main deck");
        }
        else
            DeckView.getInstance(this.user).printText("deck with name " + deckName + " does not exist");

    }

    public void showAllDecks() {
        String toPrint = "Decks:\nActive deck:\n";
        List<Deck> allDecks = this.user.getAllDecks();
        Deck activeDeck = null;
        for (Deck deck : allDecks) {
            if (deck.equals(user.getActiveDeck())) {
                toPrint += deck.getDeckName() + ": main deck " + deck.getMainDeck().size() + ", side deck " + deck.getSideDeck().size();
                if (deck.isValid()) toPrint += ", valid\n";
                else toPrint += ", invalid\n";
                activeDeck = deck;
            }
        }
        allDecks.remove(activeDeck);
        Comparator<Deck> deckComparator = Comparator.comparing(Deck::getDeckName);
        allDecks.sort(deckComparator);
        for (Deck deck : allDecks) {
            toPrint += deck.getDeckName() + ": main deck " + deck.getMainDeck().size() + ", side deck " + deck.getSideDeck().size();
            if (allDecks.get(allDecks.size() - 1).equals(deck)) {
                if (deck.isValid()) toPrint += ", valid";
                else toPrint += ", invalid";
            } else {
                if (deck.isValid()) toPrint += ", valid\n";
                else toPrint += ", invalid\n";
            }
        }
        DeckView.getInstance(this.user).printText(toPrint);
    }

    public String showDeck(String deckName, boolean isSide) {
        String toPrint = "Deck: " + deckName + "\n";
        if (isSide) toPrint += "Side deck:\nMonsters:\n";
        else toPrint += "Main deck:\nMonsters:\n";
        ArrayList<Card> monsterCards = new ArrayList<>();
        ArrayList<Card> spellAndTrapCards = new ArrayList<>();
        if (!isSide) {
            for (Card eachCard : this.user.getDeckByName(deckName).getMainDeck()) {
                if (eachCard instanceof MonsterCard) monsterCards.add(eachCard);
                else spellAndTrapCards.add(eachCard);
            }
        } else {
            for (Card eachCard : this.user.getDeckByName(deckName).getSideDeck()) {
                if (eachCard instanceof MonsterCard) monsterCards.add(eachCard);
                else spellAndTrapCards.add(eachCard);
            }
        }
        Comparator<Card> cardComparator = Comparator.comparing(Card::getNamePascalCase);
        monsterCards.sort(cardComparator);
        spellAndTrapCards.sort(cardComparator);
        for (Card eachCard : monsterCards) {
            toPrint += eachCard.getNamePascalCase() + ":" + eachCard.getDescription() + "\n";
        }
        toPrint += "Spell and Traps:";
        for (Card eachCard : spellAndTrapCards) {
            toPrint += "\n" + eachCard.getNamePascalCase() + ":" + eachCard.getDescription();
        }
        DeckView.getInstance(this.user).printText(toPrint);
        return toPrint;
    }

    public void showAllCards() {
        String toPrint = null;
        List<Card> allCards = user.getAllCards();
        Comparator<Card> cardComparator = Comparator.comparing(Card::getNamePascalCase);
        allCards.sort(cardComparator);
        for (Card card : allCards) {
            toPrint += card.getNamePascalCase() + ":" + card.getDescription() + "\n";
        }
        DeckView.getInstance(this.user).printText(toPrint);
    }


    //TODO
    private Matcher getCommandMatcher(String command, String regex){

    }

}
