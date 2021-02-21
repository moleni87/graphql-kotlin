package kr.inplat.graphql.domain

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Post(
    @Id
    val id: Int,
    val name: String
)

@Repository
interface PostRepository : JpaRepository<Post, Int>

@Component
class PostQuery(val postRepository: PostRepository) : Query {

    fun getPostList(): List<Post> = postRepository.findAll()
}
