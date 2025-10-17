package ui;

import facade.HomeAutomationFacade;

import java.util.Scanner;

public class SmartHomeUI {
    private final HomeAutomationFacade facade;
    private final CommandHandler handler;
    private final Scanner sc = new Scanner(System.in);

    public SmartHomeUI(HomeAutomationFacade facade) {
        this.facade = facade;
        this.handler = new CommandHandler(facade, sc);
    }

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            String input = sc.nextLine().trim();

            if (input.matches("^\\d+$")) {
                int choice = Integer.parseInt(input);
                running = handler.handleMenuChoice(choice);
            } else {
                handler.handleRawInput(input);
            }
        }
    }

    private void printMenu() {
        System.out.println("\n====== Welcome to Smart Home Automation System! ======");
        System.out.println("Type a menu number or a text command (type 'help' for guide).");
        System.out.println("1. Turn ON Light");
        System.out.println("2. Turn OFF Light");
        System.out.println("3. Turn ON Music");
        System.out.println("4. Turn OFF Music");
        System.out.println("5. Set Music Volume");
        System.out.println("6. Set Thermostat Temperature");
        System.out.println("7. Enable/Disable Camera (Arm/Disarm)");
        System.out.println("8. Activate Party Mode");
        System.out.println("9. Activate Night Mode");
        System.out.println("10. Leave Home");
        System.out.println("11. Show Status");
        System.out.println("12. Help");
        System.out.println("0. Exit");
        System.out.print("Choose option or type command: ");
    }
}
