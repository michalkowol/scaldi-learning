package pl.learning.scaldi.advanced

import org.scalatest.{FlatSpec, Matchers}
import pl.learning.scaldi.{WeaponModule, Warrior}
import scaldi.Injectable

class GimliScaldiSpec  extends FlatSpec with Matchers with Injectable {

  "Gimli Scaldi dependency injection" should "create Gimli" in {
    implicit val modules = new WeaponModule :: new GimliAlwaysTheSameModule

    val gimli = inject[Warrior]

    gimli.attack() should include("Gimli")
    gimli.attack() should include("Attacking with two hands axe")
  }

  it should "create same Gimlis" in {
    implicit val modules = new WeaponModule :: new GimliAlwaysTheSameModule

    val gimli1 = inject[Warrior]
    val gimli2 = inject[Warrior]

    gimli1 should be theSameInstanceAs gimli2
  }

  it should "create same Gimlis by new" in {
    implicit val modules = new WeaponModule :: new GimliAlwaysTheSameByNewModule

    val gimli1 = inject[Warrior]
    val gimli2 = inject[Warrior]

    gimli1 should be theSameInstanceAs gimli2
  }

  it should "create different Gimlis" in {
    implicit val modules = new WeaponModule :: new GimliAlwaysDiffrentModule

    val gimli1 = inject[Warrior]
    val gimli2 = inject[Warrior]

    gimli1 should not be theSameInstanceAs(gimli2)
  }
}
