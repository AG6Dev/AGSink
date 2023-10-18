package dev.ag6.agsink.client.render;

import dev.ag6.agsink.AGSink;
import dev.ag6.agsink.client.model.PenguinModel;
import dev.ag6.agsink.entity.PenguinEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
    public PenguinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PenguinModel<>(pContext.bakeLayer(PenguinModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(PenguinEntity pEntity) {
        return new ResourceLocation(AGSink.MOD_ID, "textures/entity/penguin.png");
    }
}
