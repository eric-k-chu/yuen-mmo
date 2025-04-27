package com.yuen.mmo.skill;

import com.yuen.mmo.skill.warrior.Whirlwind;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static final KeyBinding WHIRLWIND_KEYBIND = new KeyBinding("key.mmo.whirlwind", GLFW.GLFW_KEY_R, "key.categories.mmo");

    public static void registerKeybinds() {
        KeyBindingHelper.registerKeyBinding(WHIRLWIND_KEYBIND);
    }


}
