package com.cjmobileapps.flywayr2dbcsample.datasource

import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FlywayDatasource {

    @Bean
    @ConfigurationProperties("app.datasource")
    fun hikariDataSource(): HikariDataSource = DataSourceBuilder
        .create()
        .type(HikariDataSource::class.java)
        .build()

    @Bean
    fun flywayPostgres(): FlywayMigrationStrategy? {
        return FlywayMigrationStrategy { flyway: Flyway ->

//            This is used to clean database for testing
            try {
//                flyway.clean()
                flyway.migrate()
                val version = flyway.info().current().version
                println("Flyway Version: " + version.toString())
            } catch (e: Exception) {
                println("flywayPostgres() " + e)
            }
        }
    }
}

//@Configuration
//class FlywayConfig(val flywayConfigProps: FlywayConfigProps) {
//
//    @Bean(initMethod = "migrate")
//    fun flyway(): Flyway? {
//        return Flyway(
//            Flyway.configure()
//                .baselineOnMigrate(true)
//                .dataSource(
//                    flywayConfigProps.jdbcUrl,
//                    flywayConfigProps.username,
//                    flywayConfigProps.password
//                )
//        )
//    }
//}
//
//@ConfigurationProperties("app.datasource")
//@Component
//class FlywayConfigProps {
//    var jdbcUrl: String = ""
//    var username: String = ""
//    var password: String = ""
//}
//
//
//@Configuration
//class FlywayTestingConfig(flyway: Flyway) {
//
//    init {
//        try {
//            //flyway.clean()
//            val version = flyway.info().current().version
//            Logger.debug("Flyway Version: ", version.toString())
//        } catch (e: Exception) {
//            Logger.errorStackTrace("flywayPostgres()", e)
//        }
//    }
//}
