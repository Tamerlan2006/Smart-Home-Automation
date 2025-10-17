import devices.*;
import decorators.*;
import facade.HomeAutomationFacade;
import ui.SmartHomeUI;
import utils.Logger;

public class Main {
    public static void main(String[] args) {
        // core devices
        Light coreLight = new Light();
        MusicSystem coreMusic = new MusicSystem();
        Thermostat coreThermostat = new Thermostat();
        SecurityCamera coreCamera = new SecurityCamera();

        // light: voice + energy saving + analytics
        Device decoratedLight = new AnalyticsDecorator(new VoiceControlDecorator(new EnergySavingDecorator(coreLight)));

        // music: remote + energy + analytics
        Device decoratedMusic = new AnalyticsDecorator(new RemoteAccessDecorator(new EnergySavingDecorator(coreMusic)));

        // thermostat: analytics only (could add other decorators if needed)
        Device decoratedThermostat = new AnalyticsDecorator(coreThermostat);

        // camera: analytics + remote
        Device decoratedCamera = new AnalyticsDecorator(new RemoteAccessDecorator(coreCamera));

        HomeAutomationFacade facade = new HomeAutomationFacade(decoratedLight, decoratedMusic, decoratedThermostat, decoratedCamera);

        Logger.log("SmartHome started.");

        // UI
        SmartHomeUI ui = new SmartHomeUI(facade);
        ui.start();

        Logger.log("SmartHome stopped.");
    }
}
