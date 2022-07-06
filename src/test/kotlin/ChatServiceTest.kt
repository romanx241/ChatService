import ChatService.getUnreadChatsCount
import org.junit.Test
import org.junit.Assert.*

class ChatServiceTest {

    @Test
    fun messages() {
        val expectedValue = ChatService.messages(2, 3, 4)
        val realValue = ChatService.messages(2, 3, 4)
        assertEquals(expectedValue, realValue)
    }

    @Test
    fun ChatsCount() {
        val expectedValue = 0
        val realValue = chat4.getUnreadChatsCount(4)
        assertEquals(expectedValue, realValue)
    }
}