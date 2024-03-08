package com.github.sore.sample.plugin

import com.destroystokyo.paper.event.server.PaperServerListPingEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import java.util.*
import kotlin.random.Random.Default.nextInt

class EventListener(
) : Listener {

    @EventHandler
    fun onServerListPing(e: PaperServerListPingEvent) {
        val c = Calendar.getInstance()
        e.numPlayers = c.get(Calendar.YEAR) * 10000 + (c.get(Calendar.MONTH) + 1) * 100 + c.get(Calendar.DAY_OF_MONTH)
        e.maxPlayers = c.get(Calendar.HOUR) * 10000 + c.get(Calendar.MINUTE) * 100 + c.get(Calendar.SECOND)
        e.motd(
            Component.keybind("motd").color(TextColor.color(nextInt(0xFFFFF))).decorate(TextDecoration.BOLD)
        )
    }

    @EventHandler
    fun onPlayerCommand(event: PlayerCommandPreprocessEvent) {
        val command = event.message.split(" ")[0].lowercase(Locale.getDefault())

        if (command == "/plugins") {
            val errorMessage = Component.text("해당 명령어는 차단되어 있습니다.")
                .color(TextColor.fromHexString("#FF0000"))
            event.player.sendMessage(errorMessage)
            event.isCancelled = true
        }
        if (command == "/pl") {
            val errorMessage = Component.text("해당 명령어는 차단되어 있습니다.")
                .color(TextColor.fromHexString("#FF0000"))
            event.player.sendMessage(errorMessage)
            event.isCancelled = true
        }
    }
}
