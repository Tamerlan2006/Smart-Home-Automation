package decorators;

import devices.Device;

public class RemoteAccessDecorator extends DeviceDecorator {
    public RemoteAccessDecorator(Device device) {
        super(device);
    }

    @Override
    public void operate() {
        super.operate();
        System.out.println("🌐 Remote control enabled.");
    }
}
