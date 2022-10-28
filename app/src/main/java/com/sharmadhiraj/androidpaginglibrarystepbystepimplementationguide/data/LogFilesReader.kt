package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.data

import android.content.Context

/**
 * Класс для чтения файлов с логами
 * @property directory папка где лежат фалы с логами
 * @property dispatcherIO диспатчер для чтения логов
 * @author Yury Vlasik
 */
internal class LogFilesReader {
    /**
     * Метод чтения файлов с логами
     */
    fun readFiles(context: Context, positionStart: Int, blockSize: Int): String? {
        val byteArray = ByteArray(blockSize)
        val inputStream = context.assets.open("20002216_ServerSequence.log")
        inputStream.skip((positionStart * blockSize).toLong())
        val readNumber = inputStream.read(byteArray, 0, blockSize)
        inputStream.close()
        if (readNumber != -1) {
            return String(byteArray)
        }
        return null
    }
}