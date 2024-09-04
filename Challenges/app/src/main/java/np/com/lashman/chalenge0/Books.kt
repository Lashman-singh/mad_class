data class Book(
    val title: String,
    val author: String,
    var isAvailable: Boolean = true
)

class Library {
    private val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
        println("Added book: ${book.title} by ${book.author}")
    }

    fun removeBook(title: String) {
        books.find { it.title == title }?.let { bookToRemove ->
            books.remove(bookToRemove)
            println("Removed book: ${bookToRemove.title} by ${bookToRemove.author}")
        } ?: println("Book with title '$title' not found.")
    }

    fun displayAvailableBooks() {
        println("Available Books in the Lashman's Library:")
        books.filter { it.isAvailable }.forEach {
            println("- ${it.title} by ${it.author}")
        }
    }

    fun borrowBook(title: String) {
        books.find { it.title == title }?.let { bookToBorrow ->
            if (bookToBorrow.isAvailable) {
                bookToBorrow.isAvailable = false
                println("You have borrowed: ${bookToBorrow.title}")
            } else {
                println("Book '$title' is not available.")
            }
        } ?: println("Book '$title' not found.")
    }

    fun getAvailableBooksCountByAuthor(author: String): Int {
        return books.count { it.author == author && it.isAvailable }
    }
}

fun main() {
    val library = Library()

    library.addBook(Book("Kotlin Programming", "Author Lashman"))
    library.addBook(Book("Effective Java", "Author Gagan"))
    library.addBook(Book("Head First Kotlin", "Author Sandeep"))

    library.borrowBook("Kotlin Programming")

    library.removeBook("Effective Java")

    library.displayAvailableBooks()

}
