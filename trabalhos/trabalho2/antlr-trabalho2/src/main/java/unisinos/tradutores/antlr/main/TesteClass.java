package unisinos.tradutores.antlr.main;

import unisinos.tradutores.antlr.main.domain.Method;

public class TesteClass {

    boolean done = false;

    public Integer method1(int a, int b) {

        Method b1 = Method.builder()
                .name("")
                .name("")
                .command("")
                .command("")
                .build();

//        b1.getName();
        String abc = b1.getName();

        switch (abc) {
            case "A":
                break;
            case "B":
                break;
            case "C":
                break;
            default:
        }

        if (a > 10) {
            X();
        }
        if (b < 5) {
            Y();
        }
        while (!done) {
            Z();
        }
        return 0;
    }

    public void method2(int a, int b) {
        if (a > 10) {
            X();
            if (b < 5) {
                Y();
                while (!done)
                    Z();

            }
        }

        if (true) {
            if (true) {
                if (true) {
                    if (true) {
                        if (true) {
                            if (true) {

                            }
                        }
                    }
                }
            }
        }
    }


    public void X() {
        done = true;
    }

    public void Y() {
        done = true;
    }

    public void Z() {
        done = true;
    }

}

