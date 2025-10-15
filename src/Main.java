import devices.*;
import decorators.*;
import facade.*;
import ui.SmartHomeUI;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        MusicSystem music = new MusicSystem();
        Thermostat thermostat = new Thermostat();
        SecurityCamera camera = new SecurityCamera();

        Device smartLight = new VoiceControlDecorator(new EnergySavingDecorator(light));
        Device smartMusic = new RemoteAccessDecorator(new EnergySavingDecorator(music));

        HomeAutomationFacade facade = new HomeAutomationFacade(light, music, thermostat, camera);

        // UI
        SmartHomeUI ui = new SmartHomeUI(light, music, thermostat, camera, facade);
        ui.start();
    }
}
