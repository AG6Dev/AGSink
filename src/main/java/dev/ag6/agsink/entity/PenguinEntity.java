package dev.ag6.agsink.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class PenguinEntity extends Animal {
    public PenguinEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {

    }

    public static AttributeSupplier createAttributes() {
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH, 10).add(Attributes.FOLLOW_RANGE, 16).add(Attributes.MOVEMENT_SPEED, 0.8).build();
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.PENGUIN.get().create(pLevel);
    }
}