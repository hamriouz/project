public class ProfileController {
    private User user;

    public static ProfileController getInstance (User user){
    //TODO
    }

    private ProfileController(User user){
        this.user = user;
    }

    public boolean processCommand(String command){
        //TODO
    }

    private void changeNickname (String nickname){

    }

    private void changePassword (String oldPassword, String newPassword){

    }

    private Matcher getCommandMatcher (String command, String regex){

    }



}
