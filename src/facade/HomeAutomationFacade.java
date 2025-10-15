package facade;

import devices.*;

public class HomeAutomationFacade {
    private Light light;
    private MusicSystem musicSystem;
    private Thermostat thermostat;
    private SecurityCamera camera;

    public HomeAutomationFacade(Light light, MusicSystem musicSystem,
                                Thermostat thermostat, SecurityCamera camera) {
        this.light = light;
        this.musicSystem = musicSystem;
        this.thermostat = thermostat;
        this.camera = camera;
    }

    public void startPartyMode() {
        System.out.println("\n🎉 Starting Party Mode...");
        light.turnOn();
        musicSystem.turnOn();
        musicSystem.setVolume(80);
        thermostat.setTemperature(23);
    }

    public void activateNightMode() {
        System.out.println("\n🌙 Activating Night Mode...");
        light.turnOff();
        thermostat.enableEcoMode();
        camera.arm();
    }

    public void leaveHome() {
        System.out.println("\n🚪 Leaving Home...");
        light.turnOff();
        musicSystem.turnOff();
        thermostat.enableEcoMode();
        camera.arm();
    }

    public void showStatus() {
        System.out.println("\n--- Home Status ---");
        light.operate();
        musicSystem.operate();
        thermostat.operate();
        camera.operate();
    }
}
