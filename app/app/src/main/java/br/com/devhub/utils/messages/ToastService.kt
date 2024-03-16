package br.com.devhub.utils.messages

import android.content.Context
import android.widget.Toast

class ToastService {

    fun emitToast(message: String, context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}