package ui;

import devices.*;
import facade.HomeAutomationFacade;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SmartHomeUI {
    private Light light;
    private MusicSystem music;
    private Thermostat thermostat;
    private SecurityCamera camera;
    private HomeAutomationFacade facade;
    private Scanner sc = new Scanner(System.in);

    public SmartHomeUI(Light light, MusicSystem music, Thermostat thermostat, SecurityCamera camera, HomeAutomationFacade facade) {
        this.light = light;
        this.music = music;
        this.thermostat = thermostat;
        this.camera = camera;
        this.facade = facade;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n====== Welcome to Smart Home Automation System! ======");
            System.out.println("1. Turn ON Light");
            System.out.println("2. Turn OFF Light");
            System.out.println("3. Turn ON Music");
            System.out.println("4. Turn OFF Music");
            System.out.println("5. Set Music Volume");
            System.out.println("6. Set Thermostat Temperature");
            System.out.println("7. Enable/Disable Camera");
            System.out.println("8. Activate Party Mode");
            System.out.println("9. Activate Night Mode");
            System.out.println("10. Leave Home");
            System.out.println("11. Show Status");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = getIntInput();
            switch (choice) {
                case 1 -> light.turnOn();
                case 2 -> light.turnOff();
                case 3 -> music.turnOn();
                case 4 -> music.turnOff();
                case 5 -> setVolume();
                case 6 -> setTemperature();
                case 7 -> toggleCamera();
                case 8 -> facade.startPartyMode();
                case 9 -> facade.activateNightMode();
                case 10 -> facade.leaveHome();
                case 11 -> facade.showStatus();
                case 0 -> running = false;
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        }
        System.out.println("👋 Exiting Smart Home...");
    }

    private void setVolume() {
        System.out.print("Enter volume (0-100): ");
        int vol = getIntInput();
        if (vol >= 0 && vol <= 100) music.setVolume(vol);
        else System.out.println("⚠️ Invalid volume. Must be between 0-100.");
    }

    private void setTemperature() {
        System.out.print("Enter temperature (10-30°C): ");
        double temp = getDoubleInput();
        if (temp >= 10 && temp <= 30) thermostat.setTemperature(temp);
        else System.out.println("⚠️ Invalid temperature range.");
    }

    private void toggleCamera() {
        System.out.println("1. Arm camera  2. Disarm camera");
        int option = getIntInput();
        if (option == 1) camera.arm();
        else if (option == 2) camera.disarm();
        else System.out.println("⚠️ Invalid choice.");
    }

    private int getIntInput() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("⚠️ Invalid input. Please enter a number.");
            return -1;
        }
    }

    private double getDoubleInput() {
        try {
            return sc.nextDouble();
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("⚠️ Invalid input. Please enter a number.");
            return -1;
        }
    }
}
