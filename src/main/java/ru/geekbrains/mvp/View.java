package ru.geekbrains.mvp;

public interface View {

    int getValue(String message);

    int getOperation(String message);

    void print(String message);
}
