package ui;

import facade.HomeAutomationFacade;
import utils.Logger;

import java.util.Scanner;

public class CommandHandler {
    private final HomeAutomationFacade facade;
    private final VoiceControlSimulator voice;
    private final Scanner sc;

    public CommandHandler(HomeAutomationFacade facade, Scanner sc) {
        this.facade = facade;
        this.voice = new VoiceControlSimulator(facade);
        this.sc = sc;
    }

    public void handleRawInput(String raw) {
        if (raw == null) return;
        String trimmed = raw.trim();
        if (trimmed.isEmpty()) return;

        if (trimmed.equalsIgnoreCase("help")) {
            SmartHomeHelper.printHelp();
            return;
        }

        if (trimmed.equalsIgnoreCase("status")) {
            facade.showStatus();
            return;
        }

        if (trimmed.toLowerCase().startsWith("say ")) {
            String phrase = trimmed.substring(4);
            voice.processSay(phrase);
            return;
        }

        if (trimmed.toLowerCase().startsWith("clap ")) {
            String num = trimmed.substring(5).trim();
            try {
                int count = Integer.parseInt(num);
                voice.processClap(count);
            } catch (NumberFormatException e) {
                System.out.println("Invalid clap count. Use: clap 1 or clap 2");
            }
            return;
        }

        System.out.println("Unknown command (type 'help' for suggestions).");
    }

    public boolean handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> facade.turnOnLight();
            case 2 -> facade.turnOffLight();
            case 3 -> facade.turnOnMusic();
            case 4 -> facade.turnOffMusic();
            case 5 -> {
                System.out.print("Enter volume (0-100): ");
                int vol = readIntSafe();
                if (vol >= 0 && vol <= 100) facade.setMusicVolume(vol);
                else System.out.println("Invalid volume range.");
            }
            case 6 -> {
                System.out.print("Enter temperature (10-30°C): ");
                double t = readDoubleSafe();
                if (t >= 10 && t <= 30) facade.setThermostatTemperature(t);
                else System.out.println("Invalid temperature range.");
            }
            case 7 -> {
                System.out.print("1 - Arm, 2 - Disarm: ");
                int opt = readIntSafe();
                if (opt == 1) facade.armCamera();
                else if (opt == 2) facade.disarmCamera();
                else System.out.println("Invalid option.");
            }
            case 8 -> facade.startPartyMode();
            case 9 -> facade.activateNightMode();
            case 10 -> facade.leaveHome();
            case 11 -> facade.showStatus();
            case 12 -> SmartHomeHelper.printHelp();
            case 0 -> { System.out.println("Exiting..."); return false; }
            default -> System.out.println("Invalid option.");
        }
        return true;
    }

    private int readIntSafe() {
        try {
            String s = sc.nextLine();
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            System.out.println("Invalid number.");
            return -1;
        }
    }

    private double readDoubleSafe() {
        try {
            String s = sc.nextLine();
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            System.out.println("Invalid number.");
            return -1;
        }
    }
}
