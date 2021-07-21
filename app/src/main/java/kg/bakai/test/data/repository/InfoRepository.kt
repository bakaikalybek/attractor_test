package kg.bakai.test.data.repository

import android.content.Context
import kg.bakai.test.R
import kg.bakai.test.domain.model.User
import kg.bakai.test.utils.Converter
import kg.bakai.test.utils.Resource
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringWriter

class InfoRepository(private val context: Context, private val converter: Converter) {
    suspend fun getUser(): Resource<User> {
        val ins = context.resources.openRawResource(R.raw.user)
        val user = converter.jsonToString(ins)
        return Resource.success(user)
    }
}