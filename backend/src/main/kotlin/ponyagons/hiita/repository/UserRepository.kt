package ponyagons.hiita.repository

import org.springframework.stereotype.Repository
import ponyagons.hiita.domain.User
import ponyagons.hiita.repository.entities.UserExample
import ponyagons.hiita.repository.mapper.UserMapper

@Repository
class UserRepository(
    val userMapper: UserMapper
) {

    fun selectUserByName(name: String): User?{
        val example = UserExample()
        example.createCriteria()
            .andNameEqualTo(name)
        val result = userMapper.selectByExample(example)!!

        if(result.isEmpty()) {
            return null
        }

        val user = result.first()!!

        return User(
            id = user.id,
            name = user.name
        )
    }

    fun insert(name: String) {
        val user = ponyagons.hiita.repository.entities.User()
        user.name = name
        userMapper.insert(user)
    }
}