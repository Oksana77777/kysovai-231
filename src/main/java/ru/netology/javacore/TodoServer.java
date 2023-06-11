package ru.netology.javacore;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@ToString
@AllArgsConstructor
public class TodoServer {

    @ToString
    static class Request {

        String type, task;

        public Request(String type, String task) {
            this.type = type;
            this.task = task;
        }
    }
    private final int port;
    private final Todos todos;

    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            System.out.println("\nStarting server at " + this.port + "... \nServer started...\n");
            while (true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    System.out.println("New connection accepted!");
                    System.out.println("Client address: " + clientSocket.getInetAddress() +
                            " , port: " + clientSocket.getPort());
                    String json = in.readLine();
                    System.out.println("Client message: " + json);
                    Request r = new Gson().fromJson(json, Request.class);
                    switch (r.type) {
                        case "ADD":
                            System.out.println("Add task '" + r.task + "' to TODO list");
                            todos.addTask(r.task);
                            break;
                        case "REMOVE":
                            System.out.println("Remove task '" + r.task + "' from TODO list");
                            todos.removeTask(r.task);
                            break;
                    }
                    System.out.println("Send TODO list to client... ");
                    out.println(todos.getTasks());
                    System.out.println("Done!\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Can't start server!");
            e.printStackTrace();
        }
    }
}
