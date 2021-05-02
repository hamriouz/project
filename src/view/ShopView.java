package view;
import controller.ShopController;
import model.*;
import model.User;


public class ShopView {

    //TODO inja instance gozashtam ke bara chap estefade konam
    private static ShopView instance = null;
    private User user;

    public ShopView(User user) {
        this.user = user;
    }

    public static ShopView getInstance(User user) {
        if (instance == null) instance = new ShopView(user);
        else instance.user = user;
        return instance;
    }



    private void getCommandForShop(){

    }

    public void showMenu(){

    }

    public void exitMenu(){

    }

    public void printException(Exception output){

    }

    public void printText(String output){
        System.out.println(output);
    }
}
