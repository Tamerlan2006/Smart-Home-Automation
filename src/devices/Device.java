package devices;

public interface Device {
    void operate();
    void turnOn();
    void turnOff();

    default void setVolume(int v) { throw new UnsupportedOperationException("setVolume not supported"); }
    default int getVolume() { throw new UnsupportedOperationException("getVolume not supported"); }

    default void setTemperature(double t) { throw new UnsupportedOperationException("setTemperature not supported"); }
    default void enableEcoMode() { throw new UnsupportedOperationException("enableEcoMode not supported"); }

    default void arm() { throw new UnsupportedOperationException("arm not supported"); }
    default void disarm() { throw new UnsupportedOperationException("disarm not supported"); }

    // previously abstract — make it a default to avoid forcing all devices to implement it
    default void setTemperature(double t, boolean silent) {
        throw new UnsupportedOperationException("setTemperature(t, silent) not supported");
    }
}
