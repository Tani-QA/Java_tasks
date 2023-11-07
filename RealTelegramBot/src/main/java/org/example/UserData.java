package org.example;

//храним инфу о номерах вопросов, набранных очках
public class UserData {
    private int questionNumber; //номер вопроса
    private int score; //накопленные очки


    //конструктор для получения приватных полей
    public UserData() {
        this.questionNumber = 0;
        this.score=0;
    }

    //геттеры+сеттеры
    public int getQuestionNumber() {
        return questionNumber;
    }
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

}
