package devices;

public class SecurityCamera implements Device {
    private boolean isOn = false;
    private boolean armed = false;

    @Override
    public void operate() {
        System.out.println("📹 Camera ON: " + isOn + " | Armed: " + armed);
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Security camera turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        armed = false;
        System.out.println("Security camera turned OFF.");
    }

    public void arm() {
        if (!isOn) turnOn();
        armed = true;
        System.out.println("Camera armed (security enabled).");
    }

    public void disarm() {
        armed = false;
        System.out.println("Camera disarmed.");
    }
}
