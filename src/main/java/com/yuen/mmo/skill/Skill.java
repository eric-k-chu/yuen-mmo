package com.yuen.mmo.skill;

import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public abstract class Skill {
    protected final String id;
    protected final String name;
    protected final int cost;
    protected final double cooldown;

    public Skill(String id, String name, int cost, double cd) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.cooldown = cd;
    }

    public double getCd() {
        return this.cooldown;
    }

    public int getCost() {
        return this.cost;
    }

    public int getMainHandDamage(ServerPlayerEntity player) {
        ItemStack currentItem = player.getMainHandStack();
        return currentItem.getMaxDamage();
    }

    public abstract void use(ServerPlayerEntity player);
}
