import org.junit.Test

import org.junit.Assert.*

class MainKtTest {


    @Test
    fun createChat() {
        val realValue = Chat(4, user5, user6, mutableListOf(message4))
        val expectedValue = Chat(
            4,
            user5,
            user6,
            mutableListOf(message4)
        )
        assertEquals(expectedValue, realValue)
    }
}
