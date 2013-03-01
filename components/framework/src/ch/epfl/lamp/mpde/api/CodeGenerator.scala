package ch.epfl.lamp.mpde
package api

import ch.epfl.lamp.mpde.MPDETransformer
import scala.reflect.macros.Context

trait CodeGenerator {

  def generateCode(className: String): String

  //def main(): Any

  /**
   * Should be used in compile-time code generation to replace free variables.
   *
   * TODO (Duy) Should we provide the hole evidence like we do with literals?
   * Probably not.
   */
  //def hole[T](varName: String): T

  /**
   * `x` must be a `hole("some string literal")`.
   */
  //def fill(x: Any): String

}
