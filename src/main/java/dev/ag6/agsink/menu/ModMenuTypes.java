package dev.ag6.agsink.menu;

import dev.ag6.agsink.AGSink;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AGSink.MOD_ID);

    public static final RegistryObject<MenuType<LunchboxMenu>> LUNCHBOX = MENU_TYPES.register("lunchbox", () -> IForgeMenuType.create(LunchboxMenu::new));

    private ModMenuTypes() {}
}
