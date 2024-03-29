package dev.ag6.agsink.datagen;

import dev.ag6.agsink.AGSink;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AGSink.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AGSinkDatagen {

    @SubscribeEvent
    public static void onDatagen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        generator.addProvider(event.includeClient(), new AGSinkLanguageProvider(generator.getPackOutput(), "en_us"));
    }
}
