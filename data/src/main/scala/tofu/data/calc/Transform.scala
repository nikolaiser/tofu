package tofu.data.calc

trait Transform[-FL[+_, +_], +RL, -SL, -EL, -AL, +F[+_, +_], -R, -SI, +SO, +E, +A]
    extends Continue[AL, EL, SI, CalcM[F, R, SI, SO, E, A]] {
  def mapRead(r: R): RL
  def transF[X, B](fea: FL[X, B]): CalcM[F, R, SI, SO, X, B]
}
