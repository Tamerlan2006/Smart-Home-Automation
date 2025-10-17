package decorators;

import devices.Device;


public class VoiceControlDecorator extends DeviceDecorator {
    public VoiceControlDecorator(Device device) {
        super(device);
    }

    @Override
    public void operate() {
        super.operate();
        System.out.println("🎙️ (Voice control supported)");
    }
}
