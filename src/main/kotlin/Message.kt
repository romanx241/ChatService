data class Message(
    val user: User,
    var text: String,
    var isDeleted: Boolean,
    var isRead: Boolean,
) {
}