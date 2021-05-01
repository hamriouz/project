public class ImportExportController {
    private User user;

    public static ImportExportController getInstance(User user) {

    }

    private ImportExportController(User user){
    this.user = user;
    }

    public boolean processCommand(String command){

    }

    private Matcher getCommandMatcher(String command, String regex){

    }

    private void importCard(Card card){

    }

    private void exportCard(Card card){

    }

}
