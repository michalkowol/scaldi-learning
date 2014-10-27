package pl.learning.scaldi.advanced

import pl.learning.scaldi._
import scaldi.Module

class WarriorModule(name: String) extends Module {

  def createWarrior: Warrior = name match {
    case "legolas" => injected[Legolas]
    case "gimli" => injected[Gimli]
    case _ => injected[Boromir]
  }

  // use toProvider to create new instance each time
  bind[Warrior] to createWarrior
}

