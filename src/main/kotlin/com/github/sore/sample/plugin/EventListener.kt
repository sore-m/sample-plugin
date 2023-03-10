package com.github.sore.sample.plugin

import com.destroystokyo.paper.event.server.PaperServerListPingEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.util.Calendar
import kotlin.random.Random.Default.nextInt

class EventListener(
    private val samplePlugin: SamplePlugin
) : Listener {

    @EventHandler
    fun onServerListPing(e: PaperServerListPingEvent) {
        val c = Calendar.getInstance()
        e.numPlayers = c.get(Calendar.YEAR) * 10000 + (c.get(Calendar.MONTH) + 1) * 100 + c.get(Calendar.DAY_OF_MONTH)
        e.maxPlayers = c.get(Calendar.HOUR) * 10000 + c.get(Calendar.MINUTE) * 100 + c.get(Calendar.SECOND)
        e.motd(
            Component.text().color(TextColor.color(nextInt(0xFFFFF))).content("${ChatColor.BOLD}Dev Server").build()
        )
    }
}