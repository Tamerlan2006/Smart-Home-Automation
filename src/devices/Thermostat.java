package devices;

public class Thermostat implements Device {
    private boolean isOn = false;
    private double temperature = 22.0;
    private String mode = "comfort";

    @Override
    public void operate() {
        if (isOn) {
            System.out.println("🌡️ Thermostat ON | Temp: " + temperature + "°C | Mode: " + mode);
        } else {
            System.out.println("Thermostat is OFF.");
        }
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Thermostat turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Thermostat turned OFF.");
    }

    public void setTemperature(double temp) {
        this.temperature = Math.max(10, Math.min(temp, 30));
        System.out.println("Temperature set to " + this.temperature + "°C.");
    }

    public void setMode(String mode) {
        if ("eco".equalsIgnoreCase(mode) || "comfort".equalsIgnoreCase(mode)) {
            this.mode = mode.toLowerCase();
            System.out.println("Thermostat mode set to: " + this.mode);
        } else {
            System.out.println("Invalid mode. Use: eco / comfort.");
        }
    }

    public void enableEcoMode() {
        setMode("eco");
        if (!isOn) turnOn();
        System.out.println("Thermostat eco mode activated.");
    }
}
