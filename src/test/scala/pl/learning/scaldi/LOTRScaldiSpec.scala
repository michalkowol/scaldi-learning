package pl.learning.scaldi

import org.scalatest.{ Matchers, FlatSpec }
import scaldi.{ DynamicModule, Injectable }

class LOTRScaldiSpec extends FlatSpec with Matchers with Injectable {

  "A Scaldi dependency injection" should "return warrior from modules" in {
    implicit val modules = new LegolasWarriorModule :: new WeaponModule

    val warrior = inject[Warrior]

    warrior.attack() should include("Legolas")
    warrior.attack() should include("Shooting an arrow from bow")
  }

  it should "return warrior from modules using Test Weapon Module" in {
    implicit val modules = new LegolasWarriorModule :: new TestWeaponModule

    val warrior = inject[Warrior]

    warrior.attack() should include("Legolas")
    warrior.attack() should include("testing bow...")
  }

  it should "return concrete instances of Legolas" in {
    implicit val modules = new LegolasWarriorModule :: new DynamicModule {
      bind[Bow] to injected[LongBow]
    }

    val warrior = inject[Warrior]

    warrior.attack() should include("Legolas")
    warrior.attack() should include("Shooting an arrow from long bow")
  }

  it should "return concrete instances of Boromir" in {
    implicit val modules = new WeaponModule :: new DynamicModule {
      bind[Warrior] to injected[Boromir]
    }

    val warrior = inject[Warrior]

    warrior.attack() should include("Boromir")
    warrior.attack() should include("Attack with sword")
  }

  it should "return concrete instances of Boromir with One Hand Axe" in {
    implicit val modules = new DynamicModule {
      bind[Weapon] to injected[OneHandAxe]
      bind[Warrior] to injected[Boromir]
    }

    val warrior = inject[Warrior]

    warrior.attack() should include("Boromir")
    warrior.attack() should include("Attacking with one hand axe")
  }
}
