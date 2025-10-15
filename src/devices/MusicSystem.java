package devices;

public class MusicSystem implements Device {
    private boolean isOn = false;
    private int volume = 50;

    @Override
    public void operate() {
        if (isOn)
            System.out.println("🎵 Playing music at volume: " + volume);
        else
            System.out.println("Music system is OFF.");
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Music system turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Music system turned OFF.");
    }

    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(volume, 100));
        System.out.println("Volume set to: " + this.volume);
    }

    public int getVolume() {
        return volume;
    }
}
