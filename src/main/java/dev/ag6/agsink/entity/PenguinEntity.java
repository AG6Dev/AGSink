package dev.ag6.agsink.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
    public AgeableMob getBreedOffspring(@NotNull ServerLevel pLevel, @NotNull AgeableMob pOtherParent) {
        return ModEntities.PENGUIN.get().create(pLevel);
    }

    @Override
    public void tick() {
        System.out.println("penguin" + this.position());

        List<Boat> boatsWPlayers = getBoatsWithPlayers();

        for (Boat boat : boatsWPlayers) {
            boat.setDeltaMovement(boat.getDeltaMovement().scale(2.0f));
        }
    }

    private List<Boat> getBoatsWithPlayers() {
        AABB bb = this.getBoundingBox().inflate(16.0D);
        List<Boat> boats = this.level().getEntitiesOfClass(Boat.class, bb);
        return boats.stream().filter(boat -> boat.hasPassenger(passenger -> passenger instanceof Player)).toList();
    }

    public static boolean canSpawn(EntityType<PenguinEntity> entityType, LevelAccessor level, MobSpawnType type, BlockPos pos, RandomSource random) {
        return Animal.checkAnimalSpawnRules(entityType, level, type, pos, random);
    }
}
