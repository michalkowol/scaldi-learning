package pl.learning.scaldi.advanced

import pl.learning.scaldi.{ Axe, Gimli, Warrior }
import scaldi.Module

class GimliAlwaysTheSameModule extends Module {
  bind[Warrior] to injected[Gimli]
}

class GimliAlwaysTheSameByNewModule extends Module {
  bind[Warrior] to new Gimli(axe = inject[Axe])
}

class GimliAlwaysDiffrentModule extends Module {
  bind[Warrior] toProvider injected[Gimli]
}
