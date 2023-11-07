package org.example.question;

//родительский класс
//abstract - нет реализации внутри
public abstract class AbstractQuestion {
    private String question; //вопрос

    //конструктор запоминания вопроса
    public AbstractQuestion(String question){
        this.question=question;
    }

    //возвращаем вопрос
    public String getQuenstion(){
        return question;
    }

    //возвраем ответ
    //но так как методика проверки ответа у каждого вопроса своя, то описывать её будем в дочерних клаасах
    public abstract boolean checkAnswer(String answer);

}
