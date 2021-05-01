package view;

import controller.DeckController;
import model.Deck;
import model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeckView {
    private static DeckView instance = null;
    private User user;

    public static DeckView getInstance(User user) {
        if (instance == null) instance = new DeckView(user);
        else instance.user = user;
        return instance;
    }

    private DeckView(User user) {
        this.user = user;
    }

    private void getCommandForDeck() {
        String command;
        while (true) {
            command = ScannerClassForView.getScanner().nextLine();
            if (processCommand(command)) break;
        }
    }

    private boolean processCommand(String command) {
        Matcher matcher;
        DeckController deckController = DeckController.getInstance(this.user);
        matcher = getCommandMatcher(command, "deck create ([\\w]+)");
        if (matcher.matches()) {
            deckController.createDeck(matcher.group(1));
            return false;
        }
        matcher = getCommandMatcher(command, "deck delete ([\\w]+)");
        if (matcher.matches()) {
            deckController.deleteDeck(matcher.group(1));
            return false;
        }
        matcher = getCommandMatcher(command, "deck set-activate ([\\w]+)");
        if (matcher.matches()) {
            deckController.activateDeck(matcher.group(1));
            return false;
        }
        matcher = getCommandMatcher(command, "deck add-card --(card|c) ([\\w]+) --(deck|d) ([\\w]+)( --side)*");
        if (matcher.matches()) {
            if (matcher.groupCount() == 5)
                deckController.addCardToDeck(matcher.group(2), matcher.group(4), true);
            else
                deckController.addCardToDeck(matcher.group(2), matcher.group(4), false);
            return false;
        }
        if (command.startsWith("deck add-card ")) {
            Matcher matcher1 = getCommandMatcher(command, "--(card|c) ([\\w]+)");
            Matcher matcher2 = getCommandMatcher(command, "--(deck|d) ([\\w]+)");
            if (matcher1.find() && matcher2.find()) {
                Matcher matcher3 = getCommandMatcher(command, " --side");
                deckController.addCardToDeck(matcher1.group(2), matcher2.group(2), matcher3.find());
            }
        }
        matcher = getCommandMatcher(command, "deck rm-card --(card|c) ([\\w]+) --(deck|d) ([\\w]+)( --side)*");
        if (matcher.matches()) {
            if (matcher.groupCount() == 5)
                deckController.removeCardFromDeck(matcher.group(2), matcher.group(4), true);
            else
                deckController.removeCardFromDeck(matcher.group(2), matcher.group(4), false);
            return false;
        }
        matcher = getCommandMatcher(command, "deck show --all");
        if (matcher.matches()) {
            deckController.showAllDecks();
            return false;
        }
        matcher = getCommandMatcher(command, "deck show --(deck|d)-(name|n) ([\\w]+)( --side)*");
        if (matcher.matches()) {
            if (matcher.groupCount() == 4)
                deckController.showDeck(matcher.group(3), true);
            else
                deckController.showDeck(matcher.group(3), false);
            return false;
        }
        matcher = getCommandMatcher(command, "deck show --cards");
        if (matcher.matches()) {
            deckController.showAllCards();
            return false;
        }
        matcher = getCommandMatcher(command, "menu show-current");
        if (matcher.matches()) {
            DeckView.getInstance(this.user).printText("Deck");
            return false;
        }
        matcher = getCommandMatcher(command, "menu exit");
        if (matcher.matches()) {
            deckController.showAllCards();
//            MainController.getInstance(this.user). // todo balad nistam chetori beram to main
            return true;
        }
        DeckView.getInstance(this.user).printText("invalid command");
        return false;
    }


    public void showMenu() {

    }

    public void exitMenu() {

    }

    public void printException(Exception output) {

    }

    public void printText(String output) {
        System.out.println(output);
    }

    public Matcher getCommandMatcher(String command, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(command);
    }
}
