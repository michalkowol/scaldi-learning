package pl.learning.scaldi

import scaldi.Module

class LegolasWarriorModule extends Module {
  bind[Warrior] to injected[Legolas]
}
