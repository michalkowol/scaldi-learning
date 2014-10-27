package pl.learning.scaldi

import scaldi.Module

class TestWeaponModule extends Module {
  bind[Bow] to new Bow {
    override def attack(): String = "testing bow..."
  }
  bind[Axe] to new Axe {
    override def attack(): String = "testing axe..."
  }
  bind[Weapon] to new Weapon {
    override def attack(): String = "testing some weapon"
  }
}
