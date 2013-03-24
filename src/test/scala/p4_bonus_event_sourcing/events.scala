package p4_bonus_event_sourcing

import java.util.UUID


package events {


  /**
   * Identifiant d'un post
   */
  case class PostId(uuid: UUID)
  object PostId {
    def generate(): PostId = PostId(UUID.randomUUID())

    /*
    import util.control.Exception._

    def fromString(s: String): Option[PostId] = s match {
      case PostIdRegex(uuid) => catching(classOf[RuntimeException]) opt { PostId(UUID.fromString(uuid)) }
      case _                 => None
    }

    private val PostIdRegex = """PostId\(([a-fA-F0-9-]{36})\)""".r */
  }

  /**
   * Contenu d'un post
   */
  case class PostContent(author: String, title: String, body: String)

  /**
   * Evénements du domaine pour définir le cycle de vie d'un blog post.
   */

  sealed trait PostEvent {
    def postId: PostId
  }

  case class PostAdded(postId: PostId, content: PostContent) extends PostEvent

  case class PostEdited(postId: PostId, content: PostContent) extends PostEvent

  case class PostDeleted(postId: PostId) extends PostEvent

}
