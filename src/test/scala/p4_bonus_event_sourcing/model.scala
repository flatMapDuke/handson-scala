package p4_bonus_event_sourcing


package model {

import p4_bonus_event_sourcing.events._


  case class Post(id: PostId, content: PostContent)  {
      def versions:List[PostContent] = ???
  }

  case class Posts(byId: Map[PostId, Post] = Map.empty, orderedByTimeAdded: Seq[PostId] = Vector.empty) {
    def get(id: PostId): Option[Post] = byId.get(id)
    def mostRecent(n: Int): Seq[Post] = orderedByTimeAdded.takeRight(n).reverse.map(byId)

    def apply(event: PostEvent): Posts = event match {

      case PostAdded(id, content)  => ???
      case PostEdited(id, content) => ???
      case PostDeleted(id)         => ???
      case _ => this.copy()
    }
  }

  object Posts {
    def fromHistory(events: PostEvent*): Posts = events.foldLeft(Posts())(_ apply _)
  }

}
