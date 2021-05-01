package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private String deckName;
    private List<Card> mainDeck;
    private List<Card> sideDeck;

    public Deck(String deckName) {
        this.deckName = deckName;
        mainDeck = new ArrayList<>();
        sideDeck = new ArrayList<>();
    }

    public void addCardToMainDeck(Card card) {
        this.mainDeck.add(card);
    }

    public void addCardToSideDeck(Card card) {
        this.sideDeck.add(card);
    }

    public void removeCardFromMainDeck(Card card) {
        this.mainDeck.remove(card);
    }

    public void removeCardFromSideDeck(Card card) {
        this.sideDeck.remove(card);
    }

    public List<Card> getMainDeck() {
        return this.mainDeck;
    }

    public List<Card> getSideDeck() {
        return this.sideDeck;
    }

    public boolean isValid() {
        return ((this.mainDeck.size() >= 40) &&
                (this.mainDeck.size() <= 60) &&
                (this.sideDeck.size() <= 15));
    }

    public String toStringForMainDeck() {
        String toBeReturned = "Deck: " + this.deckName + "\nMain deck:\nMonsters:\n";
        ArrayList<String> monsters = new ArrayList<>();
        ArrayList<String> spellAndTraps = new ArrayList<>();
        for (Card card : mainDeck) {
            if (card instanceof MonsterCard)
                monsters.add(card.getNamePascalCase() + ": " + card.getDescription());
            else if((card instanceof SpellCard) || (card instanceof TrapCard))
                spellAndTraps.add(card.getNamePascalCase() + ": " + card.getDescription());
        }
        Collections.sort(monsters);
        Collections.sort(spellAndTraps);
        for (String eachMonster: monsters) {
            toBeReturned += eachMonster + "\n";
        }
        toBeReturned += "Spell and Traps:\n";
        for (String eachSpellAndTrap: spellAndTraps) {
            toBeReturned += eachSpellAndTrap + "\n";
        }
        return toBeReturned;
    }

    public String getDeckName() {
        return this.deckName;
    }

    public String toStringForSideDeck() {
        String toBeReturned = "Deck: " + this.deckName + "\nSide deck:\nMonsters:\n";
        ArrayList<String> monsters = new ArrayList<>();
        ArrayList<String> spellAndTraps = new ArrayList<>();
        for (Card card : sideDeck) {
            if (card instanceof MonsterCard)
                monsters.add(card.getNamePascalCase() + ": " + card.getDescription());
            else if((card instanceof SpellCard) || (card instanceof TrapCard))
                spellAndTraps.add(card.getNamePascalCase() + ": " + card.getDescription());
        }
        Collections.sort(monsters);
        Collections.sort(spellAndTraps);
        for (String eachMonster: monsters) {
            toBeReturned += eachMonster + "\n";
        }
        toBeReturned += "Spell and Traps:\n";
        for (String eachSpellAndTrap: spellAndTraps) {
            toBeReturned += eachSpellAndTrap + "\n";
        }
        return toBeReturned;
    }

    @Override
    public String toString(){
        return this.deckName + ": main deck " + this.mainDeck.size() + ", side deck" + this.sideDeck.size() + ", " + this.isValid();
    }

}
