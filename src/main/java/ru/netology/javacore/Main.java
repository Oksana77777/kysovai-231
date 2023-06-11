package ru.netology.javacore;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Todos todos = new Todos();
        TodoServer server = new TodoServer(8989, todos);
        server.start();
    }
}
