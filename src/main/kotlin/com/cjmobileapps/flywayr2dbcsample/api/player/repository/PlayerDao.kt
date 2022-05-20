package com.cjmobileapps.flywayr2dbcsample.api.player.repository

import com.cjmobileapps.flywayr2dbcsample.data.model.Player

interface PlayerDao {

    suspend fun getAll(): List<Player>

    suspend fun insertPlayer(player: Player): Player
}
