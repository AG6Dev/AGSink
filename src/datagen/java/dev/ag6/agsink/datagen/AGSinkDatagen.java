package dev.ag6.agsink.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AGSinkDatagen {

    @SubscribeEvent
    public static void onDatagen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        generator.addProvider(event.includeClient(), new AGSinkLanguageProvider(generator.getPackOutput(), ModConstants.MOD_ID, "en_us"));
    }
}
