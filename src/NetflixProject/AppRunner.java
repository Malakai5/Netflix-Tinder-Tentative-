package NetflixProject;

import NetflixProject.AppOperations.MenuOperations;

public class AppRunner {
    MenuOperations operations = MenuOperations.getInstance();
    private int menuChoice = 0;
    User user = User.getInstance();
    boolean appBeingUsed = true;

    private void giveOptions(){
        boolean optionChosen = false;
        while(!optionChosen) {
            String optionTaken = operations.menuOptions();
            if (!optionTaken.equals("1") && !optionTaken.equals("2")
                    && !optionTaken.equals("3") && !optionTaken.equals("4"))
                System.out.println("Please choose one of the options above\n");
            else{
                menuChoice = Integer.parseInt(optionTaken);
                optionChosen = true;
            }
        }
    }

    private void useMenuOptions(int menuChoice){
        if (menuChoice == 1){
            operations.swipeThroughTitles();
        }
        if (menuChoice == 2){
            operations.showRecordList(user.profile.likedTitles);
        }
        if (menuChoice == 3){
            operations.compareLikedLists();
        }
        if (menuChoice == 4){
            System.out.println("Alright\nHave a good day!!");
            appBeingUsed = false;
        }
    }

    public void fullOperations(){
        operations.startOperations();
        while (appBeingUsed) {
            giveOptions();
            useMenuOptions(menuChoice);
        }
    }

    public static void main(String[] args) {
        AppRunner appRunner = new AppRunner();
        appRunner.fullOperations();
    }
}
