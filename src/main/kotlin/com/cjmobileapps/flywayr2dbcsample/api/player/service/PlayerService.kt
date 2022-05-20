package com.cjmobileapps.flywayr2dbcsample.api.player.service

import com.cjmobileapps.flywayr2dbcsample.data.model.Player

interface PlayerService {

    suspend fun getAll(): List<Player>

    suspend fun insertPlayer(player: Player): Player
}
