package com.github.sore.sample.plugin

import com.github.sore.sample.SampleItem
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.GameRule
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.plugin.java.JavaPlugin

class SamplePlugin : JavaPlugin() {

    override fun onEnable() {
//        setupRecipe()
        setupWorlds()

        server.apply {
            pluginManager.registerEvents(
                EventListener(), this@SamplePlugin
            )
//            scheduler.runTaskTimer(this@SamplePlugin, Restarter(), 20L * 60L, 20L * 60L)
        }
    }

//    private fun setupRecipe() {
//        server.addRecipe(
//            ShapedRecipe(
//                NamespacedKey.minecraft("light_apple"),
//                SampleItem.light_apple
//            ).apply {
//                shape(
//                    " G ",
//                    "GAG",
//                    " G "
//                )
//                setIngredient('G', ItemStack(Material.GOLD_INGOT))
//                setIngredient('A', ItemStack(Material.APPLE))
//            }
//        )
//        server.addRecipe(
//            ShapedRecipe(
//                NamespacedKey.minecraft("god_apple"),
//                SampleItem.god_apple
//            ).apply {
//                shape(
//                    "GGG",
//                    "GAG",
//                    "GGG"
//                )
//                setIngredient('G', ItemStack(Material.GOLD_BLOCK))
//                setIngredient('A', ItemStack(Material.APPLE))
//            }
//        )
//    }

    private fun setupWorlds() {
        for (w in server.worlds) {
            w.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true)
            w.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, true)
            w.setGameRule(GameRule.KEEP_INVENTORY, true)
            w.setGameRule(GameRule.UNIVERSAL_ANGER, false)
        }
    }
}