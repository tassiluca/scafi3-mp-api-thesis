package it.unibo.scafi.types

import scala.concurrent.Future

trait PortableTypes:
  export it.unibo.scafi.utils.libraries.Iso
  export it.unibo.scafi.utils.libraries.Iso.given

  // A portable Map that can be used across different languages.
  type Map[K, V]
  // Portable maps are isomorphic to Scala's collection.Map.
  given [K, V] => Iso[Map[K, V], collection.Map[K, V]] = deferred

  // A portable Sequence that can be used across different languages
  type Seq[V]
  // Portable sequences are isomorphic to Scala's collection.Seq.
  given [V] => Iso[Seq[V], collection.Seq[V]] = deferred

  // A portable 1-arg function type that can be used across different languages.
  type Function1[T1, R]
  // Portable functions at 1-arg can be converted to Scala's T1 => R.
  given toScalaFunction1[T1, R]: Conversion[Function1[T1, R], T1 => R]

  // other types...

end PortableTypes
