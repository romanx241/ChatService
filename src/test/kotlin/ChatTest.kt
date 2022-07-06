import org.junit.Test
import org.junit.Assert.*

class ChatTest {

    @Test
    fun createMessage() {
        val expectedValue = chat3.createMessage(message5)
        val realValue = chat2.createMessage(message1)
        assertEquals(expectedValue, realValue)
    }

    @Test
    fun editMessage() {
        val expectedValue = Message(
            user1,
            "Как поживаете?",
            false,
            true
        )
        chat1.editMessage(1, "Как поживаете?", user1)
        val realValue = chat1.messages[0]
        assertEquals(expectedValue, realValue)
    }

    @Test
    fun deleteMessage() {
        message2.isDeleted = true
        val expectedValue = mutableListOf(message2)
        chat1.deleteMessage(1)
        val realValue = mutableListOf(chat1.messages.removeAt(0))
        assertEquals(expectedValue, realValue)
    }
}