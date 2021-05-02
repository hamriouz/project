package model;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static List<User> allUsers;
    private String username;
    private String password;
    private String nickname;
    private int score;
    private List<Card> allCards;
    private List<Deck> allDecks;
    private Deck currentActiveDeck;
    private int lifePoint;
    private Board board;
    private int money;

    public User(String username, String nickname, String password) {
        if (allUsers == null)
            allUsers = new ArrayList<>();
        allCards = new ArrayList<>();
        allDecks = new ArrayList<>();
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        setScore(0);
        setMoney(0);
    }

    public static User getUserByUsername(String username) {
        for (User allUser : allUsers) {
            if (allUser.getUsername().equals(username))
                return allUser;
        }
        return null;
    }

    public static User getUserByNickname(String nickname) {
        for (User allUser : allUsers) {
            if (allUser.getNickname().equals(nickname))
                return allUser;
        }
        return null;
    }


    //TODO get deck by name

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getScore() {
        return this.score;
    }

    public Deck getActiveDeck() {
        return this.currentActiveDeck;
    }

    public Board getBoard() {
        return this.board;
    }


    //TODO
    public int getLifePoint() {
        return this.lifePoint;
    }


    //TODO
    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }


    //TODO
    public void setScore(int score) {
        this.score = score;
    }


    //TODO
    public void setMoney(int money) {
        this.money = money;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setActiveDeck(Deck deck) {
        this.currentActiveDeck = deck;
    }

    public void increaseScore(int amount) {
        this.score += amount;
    }

    public void decreaseScore(int amount) {
        this.score -= amount;
    }

    public void increaseLifePoint(int amount) {
        this.lifePoint += amount;
    }

    public void decreaseLifePoint(int amount) {
        this.lifePoint -= amount;
    }

    //TODO in dotaro ezafe kardam
    public void increaseMoney(int amount){this.money -= amount;}

    public void decreaseMoney(int amount){this.money += amount;}

    public Deck getDeckByName(String name){
        for (Deck deck : allDecks) {
            if (deck.getDeckName().equals(name)){
                return deck;
            }
        }
        return null;
    }

    public int getMoney() {
        return money;
    }



    //TODO age lazem bood jaye pascalcase aadish kon
    public Card getCardByName(String name){
        for (Card card : allCards) {
            if (card.getNamePascalCase().equals(name)){
                return card;
            }
        }
        return null;
    }

    public List<Deck> getAllDecks() {
        return this.allDecks;
    }

    public List<Card> getAllCards() {
        return this.allCards;
    }

    public void deleteDeck(String name){
        // Todo man null boodanesh ro handle kardam vali nemidoonam age null bood che exceptioni bayad pass bedim
        Deck toBeDeleted = getDeckByName(name);
        if (!toBeDeleted.equals(null))
            allDecks.remove(toBeDeleted);
    }

    public void addDeck(Deck deck){
        allDecks.add(deck);
    }

    //TODO
    public void addCardToUsersAllCards(Card card){allCards.add(card);}
}
