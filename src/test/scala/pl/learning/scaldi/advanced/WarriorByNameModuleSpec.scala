package pl.learning.scaldi.advanced

import org.scalatest.{Matchers, FlatSpec}
import pl.learning.scaldi.{Warrior, WeaponModule}
import scaldi.Injectable

class WarriorByNameModuleSpec extends FlatSpec with Matchers with Injectable {

  "Warrior by name module" should "create Legolas" in {
    implicit val modules = new WarriorModule("legolas") :: new WeaponModule

    val warrior = inject[Warrior]

    warrior.attack() should include("Legolas")
    warrior.attack() should include("Shooting an arrow from bow")
  }

  it should "create warrior Gimli" in {
    implicit val modules = new WarriorModule("gimli") :: new WeaponModule

    val warrior = inject[Warrior]

    warrior.attack() should include("Gimli")
    warrior.attack() should include("Attacking with two hands axe")
  }

  it should "return always the same instance" in {
    implicit val modules = new WarriorModule("legolas") :: new WeaponModule

    val warrior1 = inject[Warrior]
    val warrior2 = inject[Warrior]

    warrior1 should be theSameInstanceAs warrior2
  }
}
