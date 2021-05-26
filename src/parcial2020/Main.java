package parcial2020;

import util.Scanner;

public class Main {
    public static void main(String[] args) {
        Simulator simulator = new Simulator(8, 50, 15);

        while(true){
            printMenu();
            int choice = Scanner.getInt("--> ");
            switch (choice){
                case 1: simulator.action1();
                    break;
                case 2: simulator.action2();
                    break;
                case 3: simulator.action3();
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Avanzar 1 min");
        System.out.println("2. Ver tiempo de espera");
        System.out.println("3. Terminar y ver resultados");

    }
}
