package tofu.data

import cats.kernel.Order
import cats.kernel.Semigroup
import tofu.internal.{SimpleNewtype1, BooleanNewtype}
import cats.kernel.Monoid

object Min extends SimpleNewtype1 {
  implicit def semigroup[A](implicit A: Order[A]): Semigroup[Type[A]] =
    (x, y) => apply(A.min(x.value, y.value))
}

object Max extends SimpleNewtype1 {
  implicit def semigroup[A](implicit A: Order[A]): Semigroup[Type[A]] =
    (x, y) => apply(A.max(x.value, y.value))
}

object And extends BooleanNewtype {
  implicit val monoid: Monoid[Type] = new Monoid[Type] {
    def combine(x: Type, y: Type): Type = apply(x.value && y.value)

    def empty: Type = apply(true)
  }
}

object Or extends BooleanNewtype {
  implicit val monoid: Monoid[Type] = new Monoid[Type] {
    def combine(x: Type, y: Type): Type = apply(x.value || y.value)

    def empty: Type = apply(false)
  }
}

object Xor extends BooleanNewtype {
  implicit val monoid: Monoid[Type] = new Monoid[Type] {
    def combine(x: Type, y: Type): Type = apply(x.value ^ y.value)

    def empty: Type = apply(false)
  }
}
