package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

//чат-бот telegtam для многопользовательского применения

public class App
{
    public static void main( String[] args ) throws TelegramApiException {
        //код запуска из API + обработчик ошибки без обработки
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());
    }
}
