package com.github.sore.sample.plugin

import com.github.sore.sample.SampleItem
import org.bukkit.GameRule
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.plugin.java.JavaPlugin

class SamplePlugin : JavaPlugin() {
    override fun onEnable() {
        for (world in server.worlds) {
            world.setGameRule(GameRule.SPAWN_RADIUS, 2)
            world.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true)
            world.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false)
            world.setGameRule(GameRule.DO_LIMITED_CRAFTING, true)
            world.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, false)
            world.setGameRule(GameRule.SEND_COMMAND_FEEDBACK, true)
            world.setGameRule(GameRule.LOG_ADMIN_COMMANDS, true)
        }

        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("godapple"),
                SampleItem.godapple
            ).apply {
                shape(
                    "GGG",
                    "GAG",
                    "GGG"
                )
                setIngredient('G', ItemStack(Material.GOLD_BLOCK))
                setIngredient('A', ItemStack(Material.APPLE))
            }
        )
    }
}
