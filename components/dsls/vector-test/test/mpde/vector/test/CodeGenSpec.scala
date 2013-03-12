package mpde.vector.test

import org.scalatest._
import dsl.print._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CodeGenSpec extends FlatSpec with ShouldMatchers {

  "Static code staging" should "work" in {
    assert(
      liftPrint {
        val x = 1
        val y = 2
        val z = 4
        println(x + y + z)
        x + y + z
      } == 7, "Should return the value 7!")
  }

  // TODO (Duy) This should work after the holes are made. 
  "Dynamic code insertion" should "work" in {
    val x = 1
    val y = 2

    assert(
      liftPrint {
        val z = 4
        println(x + y + z)
        x + y + z
      } == 7) // should print "7" and return "7"
  }

  "Runtime code generating" should "work" in {
    val y = 3
    assert(
      liftPrint {
        val b = 0
        println(b)
        break(y)
        1
      } == 1)

  }

  "Runtime code generating" should "not recompile" in {
    val y = 3
    for (i ← 0 to 2) {
      assert(
        liftPrint {
          val b = 0
          println(b)
          break(y)
          1
        } == 1)
    }
  }

  "Runtime code generating" should "recompile" in {
    val y = 3
    for (i ← 0 to 2) {
      assert(
        liftPrint {
          val b = 0
          println(b)
          break(i)
          1
        } == 1)
    }
  }

}
