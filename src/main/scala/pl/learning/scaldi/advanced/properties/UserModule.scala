package pl.learning.scaldi.advanced.properties

import scaldi.Module

class UserModule extends Module {
  bind[User] to User(
    username = inject[String]('username and by default "anonymous"),
    password = inject[String]('password and by default "xxx")
  )
}
