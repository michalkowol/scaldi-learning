package pl.learning.scaldi

import scaldi.Module

class ConfigModule extends Module {
  binding identifiedBy 'username to "michal"
  binding identifiedBy 'password to "secret"
}

class UserModule extends Module {
  bind[User] to User(
    username = inject[String]('username and by default "anonymous"),
    password = inject[String]('password and by default "xxx")
  )
}
