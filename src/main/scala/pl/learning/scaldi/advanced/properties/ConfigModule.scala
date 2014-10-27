package pl.learning.scaldi.advanced.properties

import scaldi.Module

class ConfigModule extends Module {
  binding identifiedBy 'username to "michal"
  binding identifiedBy 'password to "secret"
}
