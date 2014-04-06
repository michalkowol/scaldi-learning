package pl.learning.scaldi

trait Warrior {
  def attackWithWeapon(): String
}

class Legolas(bow: Bow) extends Warrior {

  override def attackWithWeapon(): String = {
    s"${bow.reload()} ${bow.attack()}"
  }
}

class Gimli(axe: Axe) extends Warrior {

  override def attackWithWeapon(): String = {
    s"${axe.swing()} ${axe.attack()}"
  }
}

class Boromir(weapon: Weapon) extends Warrior {

  override def attackWithWeapon(): String = {
    weapon.attack()
  }
}
