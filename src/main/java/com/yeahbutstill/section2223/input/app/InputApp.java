package com.yeahbutstill.section2223.input.app;

import java.util.Scanner;

public class InputApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
    }

}
