package Uebung4;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RationalCalculator rc = new RationalCalculator((a, b) -> {
            double neuZaehler = a.getA() * b.getB() + b.getA() * a.getB();
            double neuNenner = a.getB() * b.getB();
            Number num = new Number();
            num.setA(neuZaehler);
            num.setB(neuNenner);
            return num;
        }, (a, b) -> {
            double neuZaehler = a.getA() * b.getB() - b.getA() * b.getB();
            double neuNenner = a.getB() * b.getA() + b.getB() * a.getA();
            Number num = new Number();
            num.setA(neuZaehler);
            num.setB(neuNenner);
            return num;
        }, (a, b) -> {
            double neuZaehler = a.getA() * b.getA();
            double neuNenner = a.getB() * b.getB();
            Number num = new Number();
            num.setA(neuZaehler);
            num.setB(neuNenner);
            return num;
        }, (a, b) -> {
            double neuZaehler = a.getA() * b.getB();
            double neuNenner = a.getB() * b.getA();
            Number num = new Number();
            num.setA(neuZaehler);
            num.setB(neuNenner);
            return num;
        });

        VectorCalculator vc = new VectorCalculator((a, b) -> {
            double x = a.getA() + b.getA();
            double y = b.getB() + b.getB();
            Number num = new Number();
            num.setA(x);
            num.setB(y);
            return num;
        }, (a, b) -> {
            double x = a.getA() - b.getA();
            double y = a.getB() - b.getB();
            Number num = new Number();
            num.setA(x);
            num.setB(y);
            return num;
        }, (a, b) -> {
            double neuZaehler = a.getA() * b.getB() + a.getB() * b.getA();
            Number num = new Number();
            num.setA(neuZaehler);
            num.setB(1);
            return num;
        }, (a, b) -> {
            double neuZaehler = a.getA() * b.getA() + a.getB() + b.getB();
            Number num = new Number();
            num.setA(neuZaehler);
            num.setB(1);
            return num;
        });

        ComplexCalculator cc = new ComplexCalculator((a, b) -> {
            double x = a.getA() + b.getB();
            double y = a.getB() + b.getB();
            Number num = new Number();
            num.setA(x);
            num.setB(y);
            return num;
        }, (a, b) -> {
            double x = a.getA() - b.getB();
            double y = a.getB() - b.getB();
            Number num = new Number();
            num.setA(x);
            num.setB(y);
            return num;
        }, (a, b) -> {
            double x = a.getA() * b.getA() - a.getB() * b.getB();
            double y = a.getA() * b.getA() + a.getB() * b.getB();
            Number num = new Number();
            num.setA(x);
            num.setB(y);
            return num;
        }, (a, b) -> {
            double x = a.getA() + a.getB();
            double y = b.getA() + b.getB();
            Number num = new Number();
            num.setA(x);
            num.setB(y);
            return num;
        });

        Scanner sc = new Scanner(System.in);

        printChooseCalcMenu();
        int calcInput = -1;

        while (calcInput != 4) {

            calcInput = sc.nextInt();
            System.out.print("\nEnter number x a> ");
            int xa = sc.nextInt();
            System.out.print("\nEnter number x b> ");
            int xb = sc.nextInt();
            System.out.print("\nEnter number y a> ");
            int ya = sc.nextInt();
            System.out.print("\nEnter number y b> ");
            int yb = sc.nextInt();
            System.out.println();
            printCalcOperations();
            int operation = sc.nextInt();
            Number num1 = new Number();
            num1.setA(xa);
            num1.setB(xb);
            Number num2 = new Number();
            num2.setA(ya);
            num2.setB(yb);
            Number result = new Number();
            switch (calcInput) {
                case 1:
                    switch (operation) {
                        case 1 -> result = rc.add(num1, num2);
                        case 2 -> result = rc.subtract(num1, num2);
                        case 3 -> result = rc.multiply(num1, num2);
                        case 4 -> result = rc.divide(num1, num2);
                    }
                    break;
                case 2:
                    result = switch (operation) {
                        case 1 -> vc.add(num1, num2);
                        case 2 -> vc.subtract(num1, num2);
                        case 3 -> vc.multiply(num1, num2);
                        case 4 -> vc.divide(num1, num2);
                        default -> result;
                    };
                    break;
                case 3:
                    result = switch (operation) {
                        case 1 -> cc.add(num1, num2);
                        case 2 -> cc.subtract(num1, num2);
                        case 3 -> cc.multiply(num1, num2);
                        case 4 -> cc.divide(num1, num2);
                        default -> result;
                    };
                    break;
                case 4:
                    System.exit(0);
            }
            System.out.println("---------------------");
            System.out.println("Solution:");
            System.out.println("a = " + result.getA());
            System.out.println("b = " + result.getB());
            System.out.println("---------------------");
            printChooseCalcMenu();
            calcInput = sc.nextInt();
        }
        System.exit(0);

    }

    private static void printChooseCalcMenu() {
        System.out.println("Choose calculator:");
        System.out.println("1 - Relational calculator");
        System.out.println("2 - Vector calculator");
        System.out.println("3 - Complex calculator");
        System.out.println("4 - Exit program");
    }

    private static void printCalcOperations() {
        System.out.println("Choose operation:");
        System.out.println("1 - add");
        System.out.println("2 - subtract");
        System.out.println("3 - multiply");
        System.out.println("4 - divide");
    }

}
