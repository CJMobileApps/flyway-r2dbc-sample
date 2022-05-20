package com.cjmobileapps.flywayr2dbcsample.api.player.controller

import com.cjmobileapps.flywayr2dbcsample.api.player.service.PlayerService
import com.cjmobileapps.flywayr2dbcsample.data.model.Player
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/flywayr2dbcexampe/player")
@RestController
class PlayerController(val playerService: PlayerService) {

    @GetMapping
    suspend fun getAll(): List<Player> {
        return playerService.getAll()
    }

    @PostMapping
    suspend fun insertPlayer(@RequestBody player: Player): Player {
        return playerService.insertPlayer(player)
    }
}
