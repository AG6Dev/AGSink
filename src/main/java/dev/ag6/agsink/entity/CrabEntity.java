package dev.ag6.agsink.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CrabEntity extends Animal {
    public CrabEntity(EntityType<CrabEntity> entityType, Level pLevel) {
        super(entityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 16));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.6));
    }

    public static AttributeSupplier createAttributes() {
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH, 6).add(Attributes.FOLLOW_RANGE, 16).add(Attributes.MOVEMENT_SPEED, 0.3).build();
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.CRAB.get().create(pLevel);
    }
}
