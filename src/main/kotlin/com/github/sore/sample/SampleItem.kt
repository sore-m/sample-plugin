package com.github.sore.sample

import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object SampleItem {
    val godapple = ItemStack(Material.ENCHANTED_GOLDEN_APPLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("마법이 부여된 황금 사과").color(TextColor.color(0xfc54fc)).decorate(TextDecoration.BOLD))
        }
    }
}