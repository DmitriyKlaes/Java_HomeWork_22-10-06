package ru.geekbrains.mvp;

public class Model {

    private int first;

    private int second;

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getSum() {
        return first + second;
    }

    public int getDiff() {
        return first - second;
    }

    public int getMulti() {
        return first * second;
    }

    public double getQuot() {
        return (double)first / second;
    }

    public static void main(String[] args) {
        Model model = new Model();

        model.setFirst(1);
        model.setSecond(1);
        if (model.getSum() != 2 || model.getDiff() != 0 || model.getMulti() != 1 || model.getQuot() != 1.0) {
            throw new AssertionError("Incorrect test result");
        }

        model.setFirst(1);
        model.setSecond(2);
        if (model.getSum() != 3 || model.getDiff() != -1 || model.getMulti() != 2 || model.getQuot() != 0.5) {
            throw new AssertionError("Incorrect test result");
        }

        model.setFirst(2);
        model.setSecond(4);
        if (model.getSum() != 6 || model.getDiff() != -2 || model.getMulti() != 8 || model.getQuot() != 0.5) {
            throw new AssertionError("Incorrect test result");
        }
    }
}
