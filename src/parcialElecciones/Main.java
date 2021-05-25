package parcialElecciones;

import util.Scanner;

public class Main {
    public static void main(String[] args) {
        String p1 = "Partido 1";
        String p2 = "Partido 2";
        String p3 = "Partido 3";
        String p4 = "Partido 4";
        String p5 = "Partido 5";

        Simulator simulator = new Simulator(p1, p2, p3, p4, p5);

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
                case 4: simulator.action4();
                    break;
                case 5: simulator.action5();
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("1. Ingresar Votante a la Mesa");
        System.out.println("2. Ingresar Votante al Cuarto Oscuro");
        System.out.println("3. Sacar Votante del Cuarto Oscuro");
        System.out.println("4. Reponer Boletas");
        System.out.println("5. Terminar");
    }
}
