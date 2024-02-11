package ponyagons.hiita.service

import org.springframework.stereotype.Service
import ponyagons.hiita.domain.User
import ponyagons.hiita.repository.UserRepository

@Service
class UserService(
    val userRepository: UserRepository
) {

    fun login(name: String): User {
        return userRepository.selectUserByName(name).let {
            if(it == null) {
                userRepository.insert(name)
                userRepository.selectUserByName(name).let { newUser ->
                    User(id = newUser!!.id, name = newUser.name)
                }
            } else {
                User(id = it.id, name = it.name)
            }
        }
    }
}