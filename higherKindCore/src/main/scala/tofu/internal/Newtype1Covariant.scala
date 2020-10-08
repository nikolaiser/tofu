package tofu.internal

trait Newtype1Covariant {
  type Base = Any { type newTypeCovariant }
  trait Tag extends Any
  type Type[+A] <: Base with Tag
}

trait SimpleNewtype1 extends Newtype1Covariant {
  import SimpleNewtype1.Ops
  def apply[A](a: A): Type[A] = a.asInstanceOf[Type[A]]

  implicit def ops[A](value: Type[A]): Ops[Type, A] = new Ops(value)
}

object SimpleNewtype1 {
  implicit class Ops[T[_], A](private val t: T[A]) extends AnyVal {
    def value: A = t.asInstanceOf[A]
  }
}

trait BooleanNewtype {
  import BooleanNewtype.Ops
  type Base = Boolean { type newType }
  trait Tag extends Any
  type Type <: Base with Tag

  def apply[A](a: Boolean): Type = a.asInstanceOf[Type]

  implicit def ops[A](value: Type): Ops[Type] = new Ops(value)
}

object BooleanNewtype {
  implicit class Ops[T <: Boolean](private val t: T) extends AnyVal {
    def value: Boolean = t.asInstanceOf[Boolean]
  }
}
