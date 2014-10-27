package pl.learning.scaldi

import scaldi.Module

class WeaponModule extends Module {
  bind[Bow] to injected[NormalBow]
  bind[Axe] to injected[TwoHandsAxe]
  bind[Weapon] to injected[Sword]
}