package pl.learning.scaldi

import scaldi.Module

class WarriorModule(name: String) extends Module {

  def createWarrior: Warrior = name match {
    case "legolas" => new Legolas(bow = inject[Bow])
    case "gimli" => new Gimli(axe = inject[Axe])
    case _ => new Boromir(weapon = inject[Weapon])
  }

  bind[Warrior] toProvider createWarrior
}

