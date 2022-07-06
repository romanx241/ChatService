object ChatService {

    fun Chat.getUnreadChatsCount(id: Int): Int {
        var count = 0
        for (user: User in userList) {
            if (user.id == id) {
                for (chat: Chat in chatList) {
                    if ((chat.userRecipient === user || chat.userSender === user) && !chat.isChatRead) {
                        count++
                    }
                }
            }
        }
        return count
    }

    fun messages(chatId: Int, messageId: Int, count: Int) {
        val chatFound = mutableListOf<Chat>()
        val chat = chatList.forEach { chat: Chat -> if (chat.id == chatId) chatFound.add(chat) }
        val messages = { message: Message -> !message.isRead }
        val messagesList = mutableListOf<Message>()
        var i = 1
        val updateMessages = chatFound.forEach {
            if (!it.messages[i - 1].isRead && i <= count && i >= messageId) messagesList.add(it.messages[i - 1])
            i++
            it.messages[i - 1].isRead = true
        }
        return updateMessages
    }
}