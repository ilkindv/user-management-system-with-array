package util;

import java.util.Scanner;

    public class InputUtil {
        private static InputUtil instance;
        private InputUtil(){}

        public static InputUtil getInstance() {
            return instance == null ? instance = new InputUtil() : instance;
        }

        public byte inputByte (String title){
            Scanner scanner = new Scanner(System.in);
            System.out.print(title);
            return scanner.nextByte();
        }
        public int inputInt (String title){
            Scanner scanner = new Scanner(System.in);
            System.out.print(title);
            return scanner.nextInt();
        }
        public long inputLong (String title){
            Scanner scanner = new Scanner(System.in);
            System.out.print(title);
            return scanner.nextLong();
        }
        public Double inputDouble (String title){
            Scanner scanner = new Scanner(System.in);
            System.out.print(title);
            return scanner.nextDouble();
        }
        public String inputString (String title){
            Scanner scanner = new Scanner(System.in);
            System.out.print(title);
            return scanner.nextLine();
        }
    }

