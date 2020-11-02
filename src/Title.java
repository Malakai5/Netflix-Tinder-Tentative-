import java.io.*;


class Title{
    String titleName;
    int titleId;
    int[] titleIdList;
    int listQuantity = titleIdList.length;
    String genre;
    int yearMade;
    String tvRating;
    int score;


    //Constructor for title class
    public Title(String titleName, int titleId, String genre,int yearMade, String tvRating, int score){
        this.titleId = titleId;
        this.titleIdList = titleIdList;
        this.titleName = titleName;
        this.yearMade = yearMade;
        this.genre = genre;
        this.tvRating = tvRating;
        this.score = score;
    }


    //Will increase the listQuantity Int.
    public void increaseListQuantity(){
        listQuantity = listQuantity++;
    }

    //Adds a selected title to the list of title Ids
    public void addTitleId(int titleId){
        if (listQuantity == 0){
            titleIdList[0] = titleId;
        }
        else {
            titleIdList[listQuantity + 1] = titleId;
            increaseListQuantity();
        }

    }


    }

