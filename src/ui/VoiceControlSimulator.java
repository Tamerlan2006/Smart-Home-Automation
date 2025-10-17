package ui;

import facade.HomeAutomationFacade;
import utils.Logger;

public class VoiceControlSimulator {
    private final HomeAutomationFacade facade;

    public VoiceControlSimulator(HomeAutomationFacade facade) {
        this.facade = facade;
    }

    public void processClap(int count) {
        Logger.log("VoiceSimulator: clap detected: " + count);
        if (count == 1) {
            facade.turnOnLight();
            System.out.println("🎙️ Clap: one clap → Light ON");
        } else if (count == 2) {
            facade.turnOffLight();
            System.out.println("🎙️ Clap: two claps → Light OFF");
        } else {
            System.out.println("🎙️ Clap: no mapping for " + count + " claps.");
        }
    }

    public void processSay(String phrase) {
        Logger.log("VoiceSimulator: phrase -> " + phrase);
        phrase = phrase.toLowerCase().trim();
        try {
            if (phrase.contains("turn on light") || phrase.contains("light on") || phrase.contains("turn on the light")) {
                facade.turnOnLight();
            } else if (phrase.contains("turn off light") || phrase.contains("light off") || phrase.contains("turn off the light")) {
                facade.turnOffLight();
            } else if (phrase.contains("play music") || phrase.contains("turn on music")) {
                facade.turnOnMusic();
            } else if (phrase.contains("stop music") || phrase.contains("turn off music")) {
                facade.turnOffMusic();
            } else if (phrase.matches(".*(set volume|volume) \\d+.*")) {
                // extract number
                String nums = phrase.replaceAll("\\D+", " ").trim();
                if (!nums.isEmpty()) {
                    int vol = Integer.parseInt(nums.split("\\s+")[0]);
                    facade.setMusicVolume(Math.max(0, Math.min(vol, 100)));
                }
            } else if (phrase.matches(".*(set temperature|temperature|set temp) \\d+.*")) {
                String nums = phrase.replaceAll("\\D+", " ").trim();
                if (!nums.isEmpty()) {
                    double t = Double.parseDouble(nums.split("\\s+")[0]);
                    facade.setThermostatTemperature(Math.max(10, Math.min(t, 30)));
                }
            } else if (phrase.contains("night mode")) {
                facade.activateNightMode();
            } else if (phrase.contains("party")) {
                facade.startPartyMode();
            } else {
                System.out.println("🎙️ Voice command not recognized.");
            }
        } catch (Exception e) {
            System.out.println("🎙️ Error processing voice command: " + e.getMessage());
        }
    }
}
