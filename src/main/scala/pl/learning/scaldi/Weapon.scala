package pl.learning.scaldi

trait Weapon {
  def attack(): String
}

class Sword extends Weapon{
  override def attack(): String = "Attack with sword"
}

class Stick extends Weapon {
  override def attack(): String = "Attack with stick"
}

trait Axe extends Weapon {
  def swing(): String = "Swing..."
}

class TwoHandsAxe extends Axe {
  override def attack(): String = "Attacking with two hands axe"
}

class OneHandAxe extends Axe {
  override def attack(): String = "Attacking with one hand axe"
}

trait Bow extends Weapon {
  def reload(): String = "Reload..."
}

class LongBow extends Bow {
  override def attack(): String = "Shooting an arrow from long bow"
}

class NormalBow extends Bow {
  override def attack(): String = "Shooting an arrow from bow"
}


