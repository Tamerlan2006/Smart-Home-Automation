package decorators;

import devices.Device;

/**
 * Базовый декоратор — делегирует вызовы декорируемому устройству.
 * Также переопределяет опциональные методы интерфейса, перенаправляя к decoratedDevice.
 */
public abstract class DeviceDecorator implements Device {
    protected Device decoratedDevice;

    public DeviceDecorator(Device device) {
        this.decoratedDevice = device;
    }

    @Override
    public void operate() { decoratedDevice.operate(); }

    @Override
    public void turnOn() { decoratedDevice.turnOn(); }

    @Override
    public void turnOff() { decoratedDevice.turnOff(); }

    @Override
    public void setVolume(int v) { decoratedDevice.setVolume(v); }

    @Override
    public int getVolume() { return decoratedDevice.getVolume(); }

    @Override
    public void setTemperature(double t) { decoratedDevice.setTemperature(t); }

    @Override
    public void enableEcoMode() { decoratedDevice.enableEcoMode(); }

    @Override
    public void arm() { decoratedDevice.arm(); }

    @Override
    public void disarm() { decoratedDevice.disarm(); }

    // delegate the two-arg temperature method so concrete decorators don't need to implement it
    @Override
    public void setTemperature(double t, boolean silent) {
        decoratedDevice.setTemperature(t, silent);
    }
}
