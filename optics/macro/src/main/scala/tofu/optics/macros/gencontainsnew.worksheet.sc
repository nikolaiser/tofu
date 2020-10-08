import tofu.optics.macros._

// sealed trait User{
//     def id: String
// }

// case class Registered(id: String, name: String, email: String) extends User
// case class Anonymous(id: String, ip: String) extends User

// val registeredC = GenContains[Registered](_.id)
// val anonymousC = GenContains[Anonymous](_.id)

// new Contains[User, String]{
//     def set(s: User, b: String) = s match {
//         case r: Registered => registeredC.set(r, b)
//         case a: Anonymous => anonymousC.set(a, b)
//     }
// }

