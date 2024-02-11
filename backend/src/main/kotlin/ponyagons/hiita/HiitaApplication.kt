package ponyagons.hiita

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@MapperScan("ponyagons.hiita.repository.mapper")
@SpringBootApplication
class HiitaApplication

fun main(args: Array<String>) {
	runApplication<HiitaApplication>(*args)
}
