package ru.geekbrains.mvp;

public class Presenter {

    private final Model model;

    private final View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void execute() {
        model.setFirst(view.getValue("Введите первое число "));
        model.setSecond(view.getValue("Введите второе число "));
        int operation = view.getOperation("Выберете операцию");
        switch (operation) {
            case 1:
                view.print("Сумма = " + model.getSum());
                break;
            case 2:
                view.print("Разность = " + model.getDiff());
                break;
            case 3:
                view.print("Произведение = " + model.getMulti());
                break;
            case 4:
                view.print("Частное = " + model.getQuot());
                break;
            default:
                System.out.println("Выбрана несуществующая операция");
        }
    }

    private static class MockView implements View {

        private int count = 0;

        private int operation;

        public MockView(int operation) {
            this.operation = operation;
        }

        @Override
        public int getValue(String message) {
            count++;
            return operation;
        }

        @Override
        public int getOperation(String message) {
            return operation;
        }

        @Override
        public void print(String message) {
            switch (this.operation) {
                case 1:
                    if (!message.equals("Сумма = 2")) throw new AssertionError("Incorrect sum");
                    break;
                case 2:
                    if (!message.equals("Разность = 0")) throw new AssertionError("Incorrect diff");
                    break;
                case 3:
                    if (!message.equals("Произведение = 9")) throw new AssertionError("Incorrect multi");
                    break;
                case 4:
                    if (!message.equals("Частное = 1.0")) throw new AssertionError("Incorrect quot");
                    break;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        MockView mockViewSum = new MockView(1);
        MockView mockViewDiff = new MockView(2);
        MockView mockViewMulti = new MockView(3);
        MockView mockViewQuot = new MockView(4);
        Presenter presenterSum = new Presenter(model, mockViewSum);
        Presenter presenterDiff = new Presenter(model, mockViewDiff);
        Presenter presenterMulti = new Presenter(model, mockViewMulti);
        Presenter presenterQuot = new Presenter(model, mockViewQuot);

        presenterSum.execute();
        presenterDiff.execute();
        presenterMulti.execute();
        presenterQuot.execute();
        if (mockViewSum.getCount() != 2 ||
                mockViewDiff.getCount() != 2 ||
                mockViewMulti.getCount() != 2 ||
                mockViewQuot.getCount() != 2) {
            throw new AssertionError("Incorrect call of getValue()");
        }
    }
}
