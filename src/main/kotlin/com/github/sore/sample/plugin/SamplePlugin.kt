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
        setupRecipe()
        setupWorlds()
    }

    private fun setupRecipe() {
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("god_apple"),
                SampleItem.god_apple
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

    private fun setupWorlds() {
        for (w in server.worlds) {
            w.setGameRule(GameRule.SPAWN_RADIUS, 2)
            w.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true)
            w.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false)
            w.setGameRule(GameRule.DO_LIMITED_CRAFTING, true)
            w.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, false)
            w.setGameRule(GameRule.SEND_COMMAND_FEEDBACK, true)
            w.setGameRule(GameRule.LOG_ADMIN_COMMANDS, true)
        }
    }
}