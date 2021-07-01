package NetflixProject;

import NetflixProject.AppOperations.MenuOperations;

public class AppRunner {
    MenuOperations operations = MenuOperations.getInstance();

    public void beginOperations(){
        operations.startOperations();
    }

    public void operateMenu(){
        boolean appStillInUse = true;
       String menuChoice = operations.menuOptions();
       if (!menuChoice.equals("1") && !menuChoice.equals("2")
               && !menuChoice.equals("3") && !menuChoice.equals("4"))
        System.out.println("Please choose one of the options above\n");
    }

    public static void main(String[] args) {
        AppRunner appRunner = new AppRunner();
        appRunner.beginOperations();
        appRunner.operateMenu();
    }
}
