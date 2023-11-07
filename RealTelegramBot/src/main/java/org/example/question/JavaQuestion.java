package org.example.question;

//дочерний от AbstractQuestion
public class JavaQuestion extends AbstractQuestion {

    //констурктор, в котором нужно обязательно вызвать конструктор родительского класса
    //передаем вопрос
    public JavaQuestion() {
        super("Сколько в языке программирования Java есть примитивов?");
    }

    //делаем реализацию родительского метода (каждый ответ на вопрос обрабытывается по разному)
    //проверка на правильность ответа
    @Override
    public boolean checkAnswer(String answer) { //получили ответ
        return answer.equals("8"); //сравниваем с правильным значением
    }
}
