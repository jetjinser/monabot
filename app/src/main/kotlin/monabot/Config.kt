package monabot.Config

import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addResourceSource
import com.sksamuel.hoplite.toml.TomlParser

object Conf {
    data class Config(val uid: Long, val pwd: String)

    val config: Config =
            ConfigLoaderBuilder.default()
                    .addParser("data", TomlParser())
                    .addResourceSource("/config.toml")
                    .build()
                    .loadConfigOrThrow()
}
