package common

object Assert {
    fun <T> assertException(eClass: Class<T>, block: () -> Unit) {
        var caught = false
        try {
            block()
        } catch (t: Throwable) {
            if (t.javaClass == eClass) {
                caught = true
            }
        } finally {
            if (!caught) {
                throw Exception("uncaught exception")
            }
        }
    }
}