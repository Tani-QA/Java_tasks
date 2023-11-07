package org.example.question;

//дочерний от AbstractQuestion
public class SQLQuestion extends AbstractQuestion {

    //конструктор, в котором нужно обязательно вызвать конструктор родительского класса
    //передаем вопрос
    public SQLQuestion() {
        super("Сколько в реляционных (SQL) базах данных существует типов связей между таблицами?");
    }

    //делаем реализацию родительского метода (каждый ответ на вопрос обрабытывается по разному)
    //проверка на правильность ответа
    @Override
    public boolean checkAnswer(String answer) { //получили ответ
        return answer.equals("3");  //сравниваем с правильным значением
    }
}
