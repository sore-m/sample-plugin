package com.github.sore.sample.plugin

import com.github.sore.sample.SampleItem
import io.github.monun.kommand.kommand
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

        server.apply {
            pluginManager.registerEvents(
                EventListener(), this@SamplePlugin
            )
        }

        kommand {
            register("sample") {
                requires { isPlayer && isOp }
                then("item") {
                    then("light_apple") {
                        executes {
                            player.inventory.addItem(SampleItem.light_apple)
                        }
                    }
                    then("god_apple") {
                        executes {
                            player.inventory.addItem(SampleItem.god_apple)
                        }
                    }
                }
            }
        }
    }

    private fun setupRecipe() {
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("light_apple"),
                SampleItem.light_apple
            ).apply {
                shape(
                    " G ",
                    "GAG",
                    " G "
                )
                setIngredient('G', ItemStack(Material.GOLD_INGOT))
                setIngredient('A', ItemStack(Material.APPLE))
            }
        )
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
            w.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true)
            w.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, false)
        }
    }
}
