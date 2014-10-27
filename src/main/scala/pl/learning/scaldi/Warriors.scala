package pl.learning.scaldi

trait Warrior {
  def attack(): String
}

class Legolas(bow: Bow) extends Warrior {
  def attack(): String = {
    s"Legolas: ${bow.reload()} ${bow.attack()}"
  }
}

class Gimli(axe: Axe) extends Warrior {
  def attack(): String = {
    s"Gimli: ${axe.swing()} ${axe.attack()}"
  }
}

class Boromir(weapon: Weapon) extends Warrior {
  def attack(): String = {
    s"Boromir: ${weapon.attack()}"
  }
}
