package AP.group30.StardewValley.models.Users;

import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public enum RegisterQuestions {
    Your_Best_Friend("What is your best friend's name?"),
    Your_Pet("What is your pet's name?"),
    Your_Favorite_Tank("Whose your favorite God from ancient greek?"),
    Your_Favorite_Food("Whose your favorite leader in WW2?"),
    Your_Favorite_Part_Of_Body("What is your favorite part of body?");

    private final String question;

    RegisterQuestions(String question) {
        this.question = question;
    }

    public String getQuestion() {return question;}

    public static Array<String> getQuestions() {
        Array<String> questions = new Array<String>();
        for (RegisterQuestions question : RegisterQuestions.values()) {
            questions.add(question.getQuestion());
        }
        return questions;
    }

    public static RegisterQuestions getQuestion(String question) {
        for (RegisterQuestions questions : RegisterQuestions.values()) {
            if (question.equals(questions.getQuestion())) {
                return questions;
            }
        }

        return null;
    }
}
