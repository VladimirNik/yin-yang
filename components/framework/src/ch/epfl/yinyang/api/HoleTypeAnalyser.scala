
package ch.epfl.yinyang.api

import reflect.runtime.universe.Symbol

/**
 * Marker trait for DSLs in which identifying holes are done by lifted type information.
 *
 * NOTE: DSLs that inherit this trait will not be reflectively instantiated at compile time.
 */
trait HoleTypeAnalyser { this: BaseYinYang =>
  override def compilationVars(symbols: List[Symbol]): List[VarType] =
    throw new RuntimeException("This method must not be called!!!")

}
