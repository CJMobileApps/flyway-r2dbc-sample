package com.cjmobileapps.flywayr2dbcsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlywayR2dbcSampleApplication

fun main(args: Array<String>) {
	runApplication<FlywayR2dbcSampleApplication>(*args)
	println("Server is running")
}
