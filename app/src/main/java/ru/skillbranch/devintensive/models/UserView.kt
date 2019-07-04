package ru.skillbranch.devintensive.models

class UserView (
    val id : String,
    var fullName : String,
    var nickName : String,
    var avatar : String?,
    var status: String = "offline",
    val initials: String?
)