package monabot

import io.ktor.utils.io.errors.IOException
import kotlin.io.println
import monabot.utils.OkReq
import okhttp3.Request

/* fun main(): Unit = runBlocking { */
/*     val conf = Conf.config */

/*     val bot = */
/*             BotFactory.newBot(conf.uid, conf.pwd) { */
/*                         fileBasedDeviceInfo() */
/*                         protocol = ANDROID_PAD */
/*                     } */
/*                     .alsoLogin() */

/*     bot.eventChannel.subscribeAlways<FriendMessageEvent> { */
/*         subject.sendMessage("got it! you just said ${message.content}") */
/*     } */
/* } */

fun main() {
    val request = Request.Builder().url("http://scp-wiki-cn.wikidot.com/scp-1154").build()
    OkReq.emit(request) { _, resp ->
        resp.use {
            if (!resp.isSuccessful) throw IOException("uns")
            for ((name, value) in resp.headers) {
                println("$name: $value")
            }

            println(resp.body!!.string())
        }
    }
}
