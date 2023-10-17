package dev.ag6.agsink.client.render;

import dev.ag6.agsink.AGSink;
import dev.ag6.agsink.client.model.CrabModel;
import dev.ag6.agsink.entity.CrabEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrabRenderer extends MobRenderer<CrabEntity, CrabModel<CrabEntity>> {
    public CrabRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrabModel<>(pContext.bakeLayer(CrabModel.CRAB_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(CrabEntity pEntity) {
        return new ResourceLocation(AGSink.MOD_ID, "textures/entities/crab.png");
    }
}
