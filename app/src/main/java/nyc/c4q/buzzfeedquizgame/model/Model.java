package nyc.c4q.buzzfeedquizgame.model;


import android.support.annotation.DrawableRes;
import android.widget.Button;

public class Model {
    private String question;
    private boolean answerCorrect;

    @DrawableRes
    private int image;

    public Model(String question, boolean answerCorrect, @DrawableRes int image) {
        this.question = question;
        this.image = image;
        this.answerCorrect = answerCorrect;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(boolean answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
