package kg.bakai.test.utils

import com.google.gson.Gson
import kg.bakai.test.domain.model.User
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringWriter

class Converter {
    fun jsonToString(stream: InputStream): User {
        val writer = StringWriter()
        val buffer = CharArray(1024)
        stream.use {
            val reader = BufferedReader(InputStreamReader(it, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        }
        val jsonString = writer.toString()
        println(jsonString)
        val gs = Gson().fromJson(jsonString, User::class.java)
//        val res = Klaxon().parse<User>(jsonString)
        println(gs)
        return gs
    }
}