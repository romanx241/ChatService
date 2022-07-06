import ChatService.getUnreadChatsCount

val user1 = User(
    1,
    "Мария",
)
val user2 = User(
    2,
    "Арсений",
)
val user3 = User(
    3,
    "Иван",
)
val user4 = User(
    4,
    "Екатерина",
)
val user5 = User(
    5,
    "Семен",
)
val user6 = User(
    6,
    "Ольга",
)
var userList = mutableListOf(user1, user2, user3, user4, user5, user6)

var message1 = Message(
    user1,
    "Доброго дня!",
    isDeleted = false,
    isRead = false
)
var message2 = Message(
    user2,
    "Какие новости?",
    isDeleted = false,
    isRead = false
)
var messages1 = mutableListOf(message1, message2)

var message3 = Message(
    user1,
    "Привет!",
    isDeleted = false,
    isRead = false
)
var message4 = Message(
    user3,
    "Какие планы на вечер?",
    isDeleted = false,
    isRead = false
)
var messages2 = mutableListOf(message3, message4)

var message5 = Message(
    user4,
    "Чем занимаешься?",
    isDeleted = false,
    isRead = true
)
var message6 = Message(
    user3,
    "У меня сегодня большая стирка",
    isDeleted = false,
    isRead = false
)
var messages3 = mutableListOf(message5, message6)

var message7 = Message(
    user5,
    "В каком часу встречаемся?",
    isDeleted = false,
    isRead = true
)
var message8 = Message(
    user6,
    "В полночь",
    isDeleted = false,
    isRead = true
)
var messages4 = mutableListOf(message7, message8)

var chat1 = Chat(
    1,
    user1,
    user2,
    messages1
)
var chat2 = Chat(
    2,
    user2,
    user3,
    messages2
)
var chat3 = Chat(
    3,
    user3,
    user4,
    messages3
)
var chat4 = Chat(
    4,
    user5,
    user6,
    messages4
)
var chatList = mutableListOf(chat1, chat2, chat3, chat4)


fun main() {
    val chatFilter = { chat: Chat -> chat.hasLastMessage }
    val chats = chatList.filter(chatFilter).toMutableList()
    println("В сети сейчас чаты: $chats")

    val newMessage = Message(
        user2,
        "Привет!",
        isDeleted = false,
        isRead = true
    )
    println("У пользователя ${user1.name} имеется ${chat1.getUnreadChatsCount(2)} непрочитанных чата")
    chat2.deleteMessage(1)
    chat1.createMessage(newMessage)
    chat3.editMessage(2, "Доброе утро!", user4)
    chat4.editMessage(1, "Будь здоров!", user2)

    val messageToNewChat = Message(
        user1,
        "Будь здоров!",
        isDeleted = false,
        isRead = true
    )

    fun createChat(userOne: User, userTwo: User, message: Message): Chat? {
        var chatExample: Chat? = null
        var isChatExist = false
        for (chat: Chat in chatList) {
            if (chat.userRecipient === userOne || chat.userSender === userTwo) {
                isChatExist = true
            }
        }
        if (!isChatExist) {
            chatExample = Chat(
                chatList.size + 1,
                userOne,
                userTwo,
                mutableListOf(message)
            )
        }
        return chatExample
    }

    val newChat = createChat(user1, user3, messageToNewChat)
    chats.forEachIndexed { index, chat ->
        if (newChat?.id == chat.id) {
            chats[index] = newChat
            return@forEachIndexed
        }
    }
}

