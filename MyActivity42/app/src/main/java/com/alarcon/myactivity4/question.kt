package com.alarcon.myactivity4

data class Question(
    val text: String,
    val options: Array<String>,
    val correctOptionIndex: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Question

        if (text != other.text) return false
        if (!options.contentEquals(other.options)) return false
        if (correctOptionIndex != other.correctOptionIndex) return false

        return true
    }

    override fun hashCode(): Int {
        var result = text.hashCode()
        result = 31 * result + options.contentHashCode()
        result = 31 * result + correctOptionIndex
        return result
    }
}


