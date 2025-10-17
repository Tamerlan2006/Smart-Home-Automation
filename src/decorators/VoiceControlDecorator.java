package decorators;

import devices.Device;

/**
 * Декоратор, помечающий устройство как поддерживающее голос.
 * Сам по себе он не "распознаёт" команды — VoiceControlSimulator будет вызывать методы фасада/устройств.
 * Здесь мы просто добавляем сообщение при operate(), чтобы пользователь видел, что voice-enabled.
 */
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
