data class Chat(
    val id: Int,
    val userRecipient: User,
    val userSender: User,
    var messages: MutableList<Message>,
    var isChatRead: Boolean = false,
    var hasLastMessage: Boolean = false
) {

    init {
        for (message: Message in messages) {
            if (message.isRead) {
                isChatRead = true
                break
            } else isChatRead = false
        }
        hasLastMessage = messages.isNotEmpty()
    }

    fun createMessage(message: Message) {
        this.messages.add(message)
        message.isRead = true

    }

    fun editMessage(id: Int, text: String, user: User) {
        this.messages.set(id - 1, Message( user, text, false, true))

    }

    fun deleteMessage(id: Int) {
        this.messages.removeAt(id - 1)
        messages[id - 1].isDeleted = true
    }


}