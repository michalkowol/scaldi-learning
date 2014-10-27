package pl.learning.scaldi

import org.scalatest.{ Matchers, FlatSpec }
import org.scalatest.mock.MockitoSugar
import scaldi.{ PropertiesInjector, DynamicModule, Injectable }

class LOTRScaldiSpec extends FlatSpec with Matchers with MockitoSugar with Injectable {

  "A Scaldi depenendency injection" should "create warrior from implicit" in {
    implicit val modules = new WarriorModule("legolas") :: new WeaponModule

    val warrior = inject[Warrior]

    warrior.attackWithWeapon() should include("bow")
  }

  it should "create concrete instances of Legolas" in {
    implicit val modules = new WeaponModule :: new DynamicModule {
      bind[Warrior] to injected[Legolas]
    }

    val warrior = inject[Warrior]

    warrior.attackWithWeapon() should include("bow")
  }

  it should "create concrete instances of Boromir" in {
    implicit val modules = new WeaponModule :: new DynamicModule {
      bind[Warrior] to injected[Boromir]
    }

    val warrior = inject[Warrior]

    warrior.attackWithWeapon() should include("stick")
  }

  it should "create Gimli" in {
    implicit val modules = new GimliAlwaysTheSameModule

    val gimli = inject[Warrior]

    gimli.attackWithWeapon() should include("one hand axe")
  }

  it should "create same Gimlis" in {
    implicit val modules = new GimliAlwaysTheSameModule

    val gimli1 = inject[Warrior]
    val gimli2 = inject[Warrior]

    gimli1 should be(gimli2)
    gimli1.attackWithWeapon() should include("one hand axe")
  }

  it should "create same Gimlis by new" in {
    implicit val modules = new GimliAlwaysTheSameByNewModule

    val gimli1 = inject[Warrior]
    val gimli2 = inject[Warrior]

    gimli1 should be(gimli2)
    gimli1.attackWithWeapon() should include("one hand axe")
  }

  it should "create diffrent Gimlis" in {
    implicit val modules = new GimliAlwaysDiffrentModule

    val gimli1 = inject[Warrior]
    val gimli2 = inject[Warrior]

    gimli1 should not be gimli2
    gimli1.attackWithWeapon() should include("one hand axe")
  }
}
