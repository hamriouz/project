package model;
import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Card> cardsInHand;
    List<Card> cardsInGraveyard ;
    Card[] spellsAndTraps;
    String[] spellsAndTrapsCondition;
    MonsterCard[] monsters;
    String[] monstersCondition;
    Card fieldZone;
    public Board(){
        this.cardsInHand = new ArrayList<>();
        this.cardsInGraveyard = new ArrayList<>();
        this.spellsAndTraps = new Card[5];
        this.spellsAndTrapsCondition =  new String[5];
        this.monsters = new MonsterCard[5];
        this.monstersCondition = new String[5];
        this.fieldZone = null;
    }

    public List<Card> getCardsInHand(){
        return this.cardsInHand;
    }

    public Card getFieldZone(){
        return this.fieldZone;
    }

    public void removeCardFromHand(Card card){
        this.cardsInHand.remove(card);
    }

    public void addCardToHand(Card card){
        this.cardsInHand.add(card);
    }

    public void putMonster(MonsterCard monsterCard,String condition){
        for(int i=0;i<4;i++){
            if(!this.monsters[i].equals(null)){
                this.monsters[i] = monsterCard;
                this.monstersCondition[i] = condition;
            }
        }
    }

    public void removeMonster(MonsterCard monsterCard){
        for(int i=0;i<5;i++){
            if(this.monsters[i].equals(monsterCard)){
                this.monsters[i] = null;
                this.monstersCondition[i] = null;
            }
        }
    }

    public void putSpellOrTrap(Card card,String condition){
        for(int i=0;i<5;i++){
            if(!this.spellsAndTraps[i].equals(null)){
                this.spellsAndTraps[i] = card;
                this.spellsAndTrapsCondition[i] = condition;
            }
        }
    }

    public void removeSpellOrTrap(Card card){
        for(int i=0;i<5;i++){
            if(this.spellsAndTraps[i].equals(card)){
                this.spellsAndTraps[i] = null;
                this.spellsAndTrapsCondition[i] = null;
            }
        }
    }

    public void putInFieldZone(Card card){
        this.fieldZone = card;
    }

    public void removeFromFieldZone(){
        this.fieldZone=null;
    }

    public void putInGraveYard(Card card){
        this.cardsInGraveyard.add(card);
    }

    public void removeFromGraveYard(Card card){
        this.cardsInGraveyard.remove(card);
    }

    public boolean existsOnBoard(Card card){
        for(int i=0;i<5;i++){
            if(this.monsters[i].equals(card)) return true;
            if(this.spellsAndTraps[i].equals(card)) return true;
        }
        return false;
    }
}
