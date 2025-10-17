package facade;

import devices.Device;
import utils.Logger;

public class HomeAutomationFacade {
    private Device light;
    private Device music;
    private Device thermostat;
    private Device camera;

    public HomeAutomationFacade(Device light, Device music, Device thermostat, Device camera) {
        this.light = light;
        this.music = music;
        this.thermostat = thermostat;
        this.camera = camera;
    }

    public void turnOnLight() {
        light.turnOn();
        Logger.log("Facade: light turned on");
    }

    public void turnOffLight() {
        light.turnOff();
        Logger.log("Facade: light turned off");
    }

    public void turnOnMusic() {
        music.turnOn();
        Logger.log("Facade: music turned on");
    }

    public void turnOffMusic() {
        music.turnOff();
        Logger.log("Facade: music turned off");
    }

    public void setMusicVolume(int v) {
        music.setVolume(v);
        Logger.log("Facade: music volume set to " + v);
    }

    public void setThermostatTemperature(double t) {
        thermostat.setTemperature(t);
        Logger.log("Facade: thermostat temp set to " + t);
    }

    public void enableThermostatEco() {
        thermostat.enableEcoMode();
        Logger.log("Facade: thermostat eco mode enabled");
    }

    public void armCamera() {
        camera.arm();
        Logger.log("Facade: camera armed");
    }

    public void disarmCamera() {
        camera.disarm();
        Logger.log("Facade: camera disarmed");
    }

    public void startPartyMode() {
        System.out.println("\n🎉 [Facade] Party Mode starting...");
        light.turnOn();
        music.turnOn();
        music.setVolume(80);
        thermostat.setTemperature(23);
        Logger.log("Facade: party mode");
    }

    public void activateNightMode() {
        System.out.println("\n🌙 [Facade] Night Mode activating...");
        light.turnOff();
        thermostat.enableEcoMode();
        camera.arm();
        Logger.log("Facade: night mode");
    }

    public void leaveHome() {
        System.out.println("\n🚪 [Facade] Leave Home...");
        light.turnOff();
        music.turnOff();
        thermostat.enableEcoMode();
        camera.arm();
        Logger.log("Facade: leave home");
    }

    public void showStatus() {
        System.out.println("\n--- Home Status ---");
        light.operate();
        music.operate();
        thermostat.operate();
        camera.operate();
    }
}
