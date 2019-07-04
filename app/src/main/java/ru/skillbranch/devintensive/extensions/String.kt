package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16): String{
    val trimmedMes = this.trim()
    return if (trimmedMes.length <= length) trimmedMes else trimmedMes.substring(0, length).trim() + "..."
}

fun String.stripHtml(): String{
    val htmlRegex = Regex("(<.*?>)|(&[^ а-я]{1,4}?;)")
    val spaceRegex = Regex(" {2,}")
    return this.replace(htmlRegex, "").replace(spaceRegex, " ")
}