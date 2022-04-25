package monabot.scparser

sealed class ScpKind
data class Item(val id: Int) : ScpKind()

object Parser {
    private fun consUrl(kind: ScpKind): String =
            when (kind) {
                is Item(id) -> ""
            }

    fun parse() {}
}
