package com.xiaolingyun.lab3.lab1;
/**
 * Created by xiaolingyun on 18.06.19.
 * Данный класс содержит main метод, основная цель которого – это запустить веб- сервис.
 * Данный код нужен только для запуска сервиса как standalone-приложение.
 * Для запуска веб-сервисов используется класс Endpoint, со статическими методами publish.
 * Данный метод принимает на вход URL, по которому сервис будет доступен, а также класс-реализацию веб-сервиса.
 */

import javax.xml.ws.Endpoint;

public class App {
        public static void main(String[] args) {
            System.out.println("Start");
            System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace",
                    "false");
            String url = "http://localhost:8080/BeautyProductService";
            Endpoint.publish(url, new BeautyProductWebService());
        }
}
