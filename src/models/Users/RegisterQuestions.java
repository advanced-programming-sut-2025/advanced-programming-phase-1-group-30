package models.Users;

public enum RegisterQuestions {
    Your_Best_Friend("What is your best friend's name?"),
    Your_Pet("What is your pet's name?"),
    Your_Favorite_Tank("Whose your favorite God from ancient greek?"),
    Your_Favorite_Food("Whose your favorite leader in WW2?"),
    Your_Favorite_Part_Of_Body("What is your favorite part of body?");
    public final String question;

    RegisterQuestions(String question) {
        this.question = question;
    }
}
