package ru.netology.javacore;

import lombok.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Data
public class Todos {

    private List<String> tasks;

    public Todos() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        this.tasks.add(task);
    }

    public void removeTask(String task) {
        this.tasks.remove(task);
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public String getTasks() {
        Collections.sort(this.tasks);
        StringBuilder sb = new StringBuilder();
        for (String task : this.tasks) {
            sb.append(task);
            sb.append(" ");
        }
        return sb.toString();
    }

    public List<String> getAllTasksAsList() {
        return this.tasks;
    }
}
