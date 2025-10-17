package decorators;

import devices.Device;
import utils.Logger;

public class AnalyticsDecorator extends DeviceDecorator {
    private long onCount = 0;
    private long totalOnMillis = 0;
    private long lastOnTimestamp = -1;

    public AnalyticsDecorator(Device device) { super(device); }

    @Override
    public void turnOn() {
        super.turnOn();
        onCount++;
        lastOnTimestamp = System.currentTimeMillis();
        Logger.log("Analytics: device turned on. total onCount=" + onCount);
    }

    @Override
    public void turnOff() {
        super.turnOff();
        if (lastOnTimestamp > 0) {
            long duration = System.currentTimeMillis() - lastOnTimestamp;
            totalOnMillis += duration;
            Logger.log("Analytics: device turned off. lasted " + (duration/1000) + "s");
            lastOnTimestamp = -1;
        }
    }

    @Override
    public void operate() {
        super.operate();
        System.out.println("   (analytics) times turned on: " + onCount + ", total on time: " + (totalOnMillis/1000) + "s");
    }

    // getters
    public long getOnCount() { return onCount; }
    public long getTotalOnSeconds() { return totalOnMillis / 1000; }
}
