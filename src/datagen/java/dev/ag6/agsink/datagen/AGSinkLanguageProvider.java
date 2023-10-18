package dev.ag6.agsink.datagen;

import dev.ag6.agsink.AGSink;
import dev.ag6.agsink.entity.ModEntities;
import dev.ag6.agsink.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class AGSinkLanguageProvider extends LanguageProvider {
    public AGSinkLanguageProvider(PackOutput output, String locale) {
        super(output, AGSink.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        this.addItem(ModItems.HOOK_ITEM, "Mob Hook");
        this.addItem(ModItems.C4_EXPLOSIVE_BLOCK_ITEM, "C4 Explosives");
        this.addItem(ModItems.DETONATOR, "Detonator");

        this.addItem(ModItems.LUNCHBOX, "Lunchbox");
        this.add("container.agsink.lunchbox", "Lunchbox");

        this.addItem(ModItems.WISHBONE, "Wishbone");
        this.add("item.agsink.wishbone.success", "Your wish came true!");
        this.add("item.agsink.wishbone.failure", "The bone broke and nothing happened!");

        this.addEntityType(ModEntities.CRAB, "Crab");
        this.addItem(ModItems.CRAB_CLAW, "Crab Claw");

        this.addEntityType(ModEntities.PENGUIN, "Penguin");
    }
}
