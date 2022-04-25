package monabot.utils

import io.ktor.utils.io.errors.IOException
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

object OkReq {
    private val client = OkHttpClient()

    fun emit(request: Request, onResponse: (Call, Response) -> Unit) {
        client.newCall(request)
                .enqueue(
                        object : Callback {
                            override fun onFailure(call: Call, e: IOException) {
                                e.printStackTrace()
                            }
                            override fun onResponse(call: Call, response: Response) =
                                    onResponse(call, response)
                        }
                )
    }
}
