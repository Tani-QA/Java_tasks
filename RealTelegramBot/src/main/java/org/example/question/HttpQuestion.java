package org.example.question;

//дочерний от AbstractQuestion
public class HttpQuestion extends AbstractQuestion {
    private String[] methods={"get","post","put","patch","delete"}; //ответы в виде массива

    //конструктор, в котором нужно обязательно вызвать конструктор родительского класса
    //передаем вопрос
    public HttpQuestion() {
        super("Какие методы HTTP-запросов вы знаете?");
    }

    //делаем реализацию родительского метода (каждый ответ на вопрос обрабытывается по разному)
    //проверка на правильность ответа
    @Override
    public boolean checkAnswer(String answer) { //получили ответ
        answer=answer.toLowerCase();          //привели к нижнему регистру toLowerCase
        for(String method : methods){        //прогянем массив
            if(!answer.contains(method)){    //если есть хотя бы одно несовпадение - завершаемся
                return false;
            }
        }
        return true;                           //если всё совпало
    }
}
