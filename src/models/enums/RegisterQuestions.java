package models.enums;

public enum RegisterQuestions {
    Your_Best_Friend("What is your best friend's name?"),
    Your_Pet("What is your pet's name?"),
    Your_Favorite_Tank("What is your favorite tank in WW2?"),
    Your_Favorite_Food("What is your favorite food?"),
    Your_Favorite_Part_Of_Body("What is your favorite part of body?");
    public final String question;

    RegisterQuestions(String question) {
        this.question = question;
    }
}
