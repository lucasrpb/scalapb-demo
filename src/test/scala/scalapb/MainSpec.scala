package scalapb

import org.scalatest.FlatSpec
import scalapb.protos.user.{User, UserProto}

class MainSpec extends FlatSpec {

  "serialization " should "run successfully " in {

    var user = new User("Lucas")

    var start = System.currentTimeMillis()
    val bytes = user.toByteArray
    var elapsed = System.currentTimeMillis() - start

    println(s"elapsed: ${elapsed}ms")

    println(bytes.toSeq)

    start = System.currentTimeMillis()
    user = User.parseFrom(bytes)
    elapsed = System.currentTimeMillis() - start

    println(s"user ${user} elapsed: ${elapsed}ms")
  }

}
