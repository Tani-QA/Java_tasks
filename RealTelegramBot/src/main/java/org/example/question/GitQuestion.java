package org.example.question;

//дочерний от AbstractQuestion
public class GitQuestion extends AbstractQuestion {

    //конструктор, в котором нужно обязательно вызвать конструктор родительского класса
    //передаем вопрос
    public GitQuestion() {
        super("С помощью какой команды в системе контроля версий Git можно просмотреть " +
                "авторов различных срок в одном файле?");
    }

    //делаем реализацию родительского метода (каждый ответ на вопрос обрабытывается по разному)
    //проверка на правильность ответа
    @Override
    public boolean checkAnswer(String answer) { //получили ответ
        return answer.toLowerCase().contains("blame");         //привели к нижнему регистру toLowerCase и проверили на совпадение
    }
}
