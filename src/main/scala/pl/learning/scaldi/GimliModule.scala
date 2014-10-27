package pl.learning.scaldi

import scaldi.Module

class GimliAlwaysTheSameModule extends Module {
  bind[Axe] to injected[OneHandAxe]
  bind[Warrior] to injected[Gimli]
}

class GimliAlwaysTheSameByNewModule extends Module {
  bind[Axe] to new OneHandAxe()
  bind[Warrior] to new Gimli(axe = inject[Axe])
}

class GimliAlwaysDiffrentModule extends Module {
  bind[Axe] to injected[OneHandAxe]
  bind[Warrior] toProvider new Gimli(axe = inject[Axe])
}
