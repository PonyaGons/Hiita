package ponyagons.hiita.controller

import org.springframework.web.bind.annotation.*
import ponyagons.hiita.controller.input.LoginInput
import ponyagons.hiita.domain.User
import ponyagons.hiita.service.UserService

@RestController
@RequestMapping("/login")
class LoginController(
    val userService: UserService
) {

    @PostMapping
    fun login(@RequestBody input: LoginInput): User {
        return userService.login(input.name)
    }
}