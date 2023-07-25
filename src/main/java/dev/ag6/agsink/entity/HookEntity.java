package dev.ag6.agsink.entity;

import dev.ag6.agsink.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class HookEntity extends ThrowableItemProjectile {
    public HookEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public HookEntity(Player player, Level pLevel) {
        super(ModEntities.HOOK.get(), pLevel);
        this.setOwner(player);
        this.setRot(player.getYRot(), player.getXRot());
        this.setPos(player.getX(), player.getY() + player.getEyeHeight(), player.getZ());
        this.setNoGravity(true);
    }

    @Override
    public void tick() {
        this.checkInsideBlocks();
        Vec3 deltaMovement = this.getDeltaMovement();
        double newX = this.getX() + deltaMovement.x;
        double newY = this.getY() + deltaMovement.y;
        double newZ = this.getZ() + deltaMovement.z;
        this.updateRotation();

        if (this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                this.level().addParticle(ParticleTypes.BUBBLE, newX - deltaMovement.x * 0.25D, newY - deltaMovement.y * 0.25D, newZ - deltaMovement.z * 0.25D, deltaMovement.x, deltaMovement.y, deltaMovement.z);
            }
        }

        this.setDeltaMovement(deltaMovement);
        this.setPos(newX, newY, newZ);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.HOOK_ITEM.get();
    }
}
