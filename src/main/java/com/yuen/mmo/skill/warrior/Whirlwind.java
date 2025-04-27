package com.yuen.mmo.skill.warrior;

import com.yuen.mmo.skill.Skill;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public class Whirlwind extends Skill {
    private static final double RADIUS = 3.0;
    private static final int BASE_DAMAGE = 10;
    private static final int BASE_COST = 20;
    private static final double BASE_COOLDOWN = 2.0;

    public Whirlwind() {
        super("whirlwind", "Whirlwind", BASE_COST, BASE_COOLDOWN);
    }

    @Override
    public void use(ServerPlayerEntity player) {

        int damage = BASE_DAMAGE * this.getMainHandDamage(player);


        List<LivingEntity> targets = player.getWorld().getEntitiesByClass(
                LivingEntity.class,
                player.getBoundingBox().expand(RADIUS),
                (entity) -> entity != player && entity.isAlive() && player.canSee(entity)
        );

        ServerWorld serverWorld = player.getServerWorld();
        DamageSource src = player.getDamageSources().playerAttack(player);

        for (LivingEntity target : targets) {
            target.damage(serverWorld, src, damage);
        }
    }
}
