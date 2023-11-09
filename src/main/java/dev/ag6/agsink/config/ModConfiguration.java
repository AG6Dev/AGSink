package dev.ag6.agsink.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfiguration {
    public static final ForgeConfigSpec COMMON_SPEC;

    public static ForgeConfigSpec.DoubleValue penguinBoatSpeedMultiplier;

    private static void setupModConfig(ForgeConfigSpec.Builder builder) {
        penguinBoatSpeedMultiplier = builder.defineInRange("penguin_boat_speed_modifier", 0.05D, 0D, 2.0D);
    }

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupModConfig(configBuilder);
        COMMON_SPEC = configBuilder.build();
    }
}
