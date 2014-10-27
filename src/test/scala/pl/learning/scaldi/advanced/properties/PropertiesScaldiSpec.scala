package pl.learning.scaldi.advanced.properties

import org.scalatest.mock.MockitoSugar
import org.scalatest.{ FlatSpec, Matchers }
import scaldi.{ DynamicModule, Injectable, PropertiesInjector }

class PropertiesScaldiSpec extends FlatSpec with Matchers with MockitoSugar with Injectable {

  "A Scaldi dependency injection" should "create user with default username and default password" in {
    implicit val modules = new UserModule

    val user = inject[User]

    user.username should be("anonymous")
    user.password should be("xxx")
  }

  it should "create user with username and password" in {
    implicit val modules = new UserModule :: new ConfigModule

    val user = inject[User]

    user.username should be("michal")
    user.password should be("secret")
  }

  it should "create user with username and default password" in {
    implicit val modules = new UserModule :: new DynamicModule {
      binding identifiedBy 'username to "michal"
    }

    val user = inject[User]

    user.username should be("michal")
    user.password should be("xxx")
  }

  it should "create user with username and password from properties file" in {
    val props = getClass().getResourceAsStream("/config.properties")
    implicit val modules = new UserModule :: PropertiesInjector(props)

    val user = inject[User]

    user.username should be("jan")
    user.password should be("secret2")
  }
}
