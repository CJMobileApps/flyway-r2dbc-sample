package com.cjmobileapps.flywayr2dbcsample.api.player.service

import com.cjmobileapps.flywayr2dbcsample.api.player.repository.PlayerDao
import com.cjmobileapps.flywayr2dbcsample.data.model.Player
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class PlayerServiceImpl(@Qualifier("playerRepository") val playerDao: PlayerDao): PlayerService {

    override suspend fun getAll(): List<Player> = playerDao.getAll()

    override suspend fun insertPlayer(player: Player) = playerDao.insertPlayer(player)
}
