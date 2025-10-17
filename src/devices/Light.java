package devices;

public class Light implements Device {
    private boolean isOn = false;

    @Override
    public void operate() {
        if (isOn) System.out.println("💡 Light is ON");
        else System.out.println("🌑 Light is OFF");
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light turned OFF.");
    }

    // helper for other code
    public boolean isOn() { return isOn; }
}
