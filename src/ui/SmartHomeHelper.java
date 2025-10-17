package ui;

public class SmartHomeHelper {
    public static void printHelp() {
        System.out.println("\n=== SmartHome Helper ===");
        System.out.println("Menu commands: choose number from menu.");
        System.out.println("Text commands (type directly):");
        System.out.println("  say <phrase>        - simulate voice command, e.g. say turn on light");
        System.out.println("  clap <n>            - simulate clap(s), e.g. clap 1 (one clap), clap 2 (two claps)");
        System.out.println("  status              - show system status");
        System.out.println("  help                - show this help");
        System.out.println("Examples of voice phrases:");
        System.out.println("  say turn on the light");
        System.out.println("  say set volume 70");
        System.out.println("  say set temperature 25");
        System.out.println("========================\n");
    }
}
