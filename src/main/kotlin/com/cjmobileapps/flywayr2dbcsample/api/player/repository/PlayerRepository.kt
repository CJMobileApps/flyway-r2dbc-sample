package com.cjmobileapps.flywayr2dbcsample.api.player.repository

import com.cjmobileapps.flywayr2dbcsample.data.model.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.util.*

@Suppress("SqlNoDataSourceInspection", "SqlResolve")
@Repository("playerRepository")
class PlayerRepository(val jdbcTemplate: JdbcTemplate): PlayerDao {

    override suspend fun getAll(): List<Player> {
        val sqlSelectAllPlayers = """
        SELECT * FROM player
        """

        val players = withContext(Dispatchers.IO) {
            jdbcTemplate.query(sqlSelectAllPlayers, arrayOf()) { resultSet, _ ->
                val id = UUID.fromString(resultSet.getString("id"))
                val firstName = resultSet.getString("firstName")
                val lastName = resultSet.getString("lastName")
                val dateCreated = resultSet.getDate("dateCreated")

                println("dateCreated " + dateCreated)

                Player(
                    id = id,
                    firstName = firstName,
                    lastName = lastName,
                    dateCreated = null
                )
            }
        }

        return players
    }

    override suspend fun insertPlayer(player: Player): Player {

        val sqlInsertPlayer = """
        INSERT INTO player (id, firstName, lastName, dateCreated)
        VALUES (?,?,?,now() at time zone 'utc')    
        """

        val id = UUID.randomUUID()
        player.id = id

        val isSuccessfulInsertPlayer = withContext(Dispatchers.IO) {
            jdbcTemplate.update(
                sqlInsertPlayer,
                player.id,
                player.firstName,
                player.lastName
            )
        }

        println("player inserted: $isSuccessfulInsertPlayer")

        return player
    }
}
