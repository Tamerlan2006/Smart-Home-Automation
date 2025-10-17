package devices;

/**
 * Common device interface.
 * Добавлены default методы для device-specific операций (чтобы фасад мог работать только с Device интерфейсом).
 */
public interface Device {
    void operate();
    void turnOn();
    void turnOff();

    // Optional operations with default implementations that бросают UnsupportedOperationException,
    // но конкретные устройства переопределяют их.
    default void setVolume(int v) { throw new UnsupportedOperationException("setVolume not supported"); }
    default int getVolume() { throw new UnsupportedOperationException("getVolume not supported"); }

    default void setTemperature(double t) { throw new UnsupportedOperationException("setTemperature not supported"); }
    default void enableEcoMode() { throw new UnsupportedOperationException("enableEcoMode not supported"); }

    default void arm() { throw new UnsupportedOperationException("arm not supported"); }
    default void disarm() { throw new UnsupportedOperationException("disarm not supported"); }
}
