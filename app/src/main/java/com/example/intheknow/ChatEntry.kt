package com.example.intheknow
import android.os.Environment
import java.io.*

public class ChatEntry (val question: String, var activePeople: Int, val chat: MutableList<Message>) {


    public fun getTheQuestion(): String{
        return question
    }

    public fun getTheActive(): Int{
        return activePeople
    }
}

data class Message (val name: String, val message: String)

class myCircleIO {
    companion object {
        private const val myCirclePath = "myCircle.txt"
        private val myCircleFile: File = File(Environment.getExternalStorageDirectory(), myCirclePath)
        var chatData: MutableList<ChatEntry> = mutableListOf<ChatEntry>()

        fun updateFile() {
            try {
                val fileOutPutStream = FileOutputStream(myCircleFile)
                fileOutPutStream.write(chatData.toString().toByteArray())
                fileOutPutStream.close()
            } catch(e : IOException) {
                e.printStackTrace()
            }
        }

        fun updateLocalData() {
            var fileInputStream = FileInputStream(myCircleFile)
            var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            chatData = mutableListOf<ChatEntry>()
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }
            fileInputStream.close()
            var dataString = stringBuilder.toString()
            if (dataString.equals("[]") || dataString.equals("")) {
                return;
            }
            dataString = dataString.substring(dataString.indexOf("ChatEntry") + 9)
            val splitArray = dataString.split(", ChatEntry")

            splitArray.forEach {
                var currentString = it
                val question = currentString.substring(currentString.indexOf("question=") + 9, currentString.indexOf(", activePeople="))
                currentString = currentString.substring(currentString.indexOf(", activePeople=") + 1)
                val numPeople = currentString.substring(currentString.indexOf("activePeople=") + 13, currentString.indexOf(", chat="))
                currentString = currentString.substring(currentString.indexOf(", chat=") + 7)
                val postList = mutableListOf<Message>()
                if (currentString.length >= 7) {
                    currentString = currentString.substring(currentString.indexOf("Message(") + 7)
                    val messageArray = currentString.split(", Message")
                    messageArray.forEach {
                        var currentMessage = it
                        val name = currentMessage.substring(currentMessage.indexOf("name=") + 5, currentMessage.indexOf(", message="))
                        currentMessage = currentMessage.substring(currentMessage.indexOf(", message=") + 10)
                        var message = currentMessage.substring(0, currentMessage.length - 1)
                        if (message.indexOf(")])") >= 0) {
                            message = message.substring(0, message.length - 3)
                        } else if (message.indexOf(")]") >= 0) {
                            message = message.substring(0, message.length - 2)
                        }
                        postList.add(Message(name, message))
                    }
                }
                chatData.add(ChatEntry(question, numPeople.toInt(), postList))
            }
        }
    }
}