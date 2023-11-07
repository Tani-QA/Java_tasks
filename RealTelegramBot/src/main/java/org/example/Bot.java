package org.example;

import org.example.question.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.AbstractList;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.HashMap;

//наследуем класс телеграмма и можем дополнять его
public class Bot extends TelegramLongPollingBot {

    //коллекция - чтобы хранить значения пользователь-номер вопроса, при многопользовательском режиме
    private HashMap<Long,UserData> users;

    //коллекция - хранить вопросы, у которых есть как минимум 2 метода класса AbstractQuestion
    private ArrayList<AbstractQuestion> questions;

    //констурктор, чтобы хранить пользователей и номера вопросов (соответсвия для разных юзеров)
    public Bot(){
        users =new HashMap<>();
        questions=new ArrayList<>();
        questions.add(new JavaQuestion());
        questions.add(new SQLQuestion());
        questions.add(new GitQuestion());
        questions.add(new HttpQuestion());
    }

    //название чат-бота
    @Override
    public String getBotUsername() { //название бота подставляем
        return "JavaSpecialSkilTestBot";
    }

    //доступ
    @Override
    public String getBotToken() { //сформироанный токен подставляем
        return "6767193842:AAGbmM70tQT0wgiRT2TCoxvLwrsDLsR2i-o";
    }

    //отправить текст пользователю (из API, без изменений)
    public void sendText(Long who, String what){ //кому, текст сообщения
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    //как будет реагировать бот, когда в него кто-то будет писать
    @Override
    public void onUpdateReceived(Update update) {
//        System.out.println(update);
        Message message = update.getMessage(); //введенный текст в чате
        String text = message.getText();

        long userId=message.getFrom().getId(); //получить идентификатор пользователя

        if(text.equals("/start")){
            sendText(userId, "Привет! Это тест навыков по Java. Итак, начнем :)"); //бот говорит
            users.put(userId,new UserData()); //добавляем юзера с вопросом1
            String question = questions.get(0).getQuenstion(); //задаем вопрос
            sendText(userId,question);
        }else if(users.get(userId).getQuestionNumber()== questions.size()) { //если юзер ответил на все вопросы и написал что-то еще
            sendText(userId,"Вы уже ответили на все вопросы");
            sendText(userId, "Для перезапуска бота используйте команду /start");
        } else { //какой номер ответы мы получили?
            UserData userData = users.get(userId); //получили
            int questionNumer= userData.getQuestionNumber();
            boolean result = questions.get(questionNumer).checkAnswer(text);

            //если ответ на вопрос неверный
            if (!result){
                sendText(userId,"Ответ неверный");
            }

            int score = userData.getScore();  //очки
            int nextQuestion =questionNumer+1;
            userData.setScore(score+(result ? 1:0));
            userData.setQuestionNumber(nextQuestion);
//            sendText(userId, result ? "Всё верно" : "Неверно :("); //аналогия if (result==true)

            if(nextQuestion==questions.size()) {
                sendText(userId, "Ваш рейтинг: " + users.get(userId).getScore() + " из " + questions.size());
            } else {
                String question = questions.get(nextQuestion).getQuenstion(); //задаем вопрос
                sendText(userId, question);
            }
        }

        }
}
