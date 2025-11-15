package it.unibo.scafi.types

import scala.concurrent.{ ExecutionContext, Future }
import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichIterableOnce
import scala.util.{ Failure, Success }

trait JSTypes extends PortableTypes:
  override type Map[K, V] = js.Map[K, V]
  override given [K, V] => Iso[Map[K, V], collection.Map[K, V]] = Iso(_.toMap, m => js.Map(m.toSeq*))

  override type Seq[V] = js.Array[V]
  override given [V] => Iso[Seq[V], collection.Seq[V]] = Iso(identity, _.toJSArray)

  override type Function1[T1, R] = js.Function1[T1, R]
  given toScalaFunction1[T1, R]: Conversion[Function1[T1, R], T1 => R] = _.apply

  // ...

end JSTypes
