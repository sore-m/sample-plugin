package com.github.sore.sample.plugin

import com.destroystokyo.paper.event.server.PaperServerListPingEvent
import io.github.monun.tap.fake.FakeEntityServer
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import java.util.Calendar
import kotlin.random.Random.Default.nextInt

class EventListener(
    private val fakeServer: FakeEntityServer
) : Listener {

    @EventHandler
    fun onServerListPing(e: PaperServerListPingEvent) {
        val c = Calendar.getInstance()
        e.numPlayers = c.get(Calendar.YEAR) * 10000 + (c.get(Calendar.MONTH) + 1) * 100 + c.get(Calendar.DAY_OF_MONTH)
        e.maxPlayers = c.get(Calendar.HOUR) * 10000 + c.get(Calendar.MINUTE) * 100 + c.get(Calendar.SECOND)
        e.motd(
            Component.keybind("Hello World!").color(TextColor.color(nextInt(0xFFFFF))).decorate(TextDecoration.BOLD)
        )
    }
}
