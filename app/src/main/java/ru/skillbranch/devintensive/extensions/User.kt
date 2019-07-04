package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils

fun User.toUserView(): UserView{
    val nickName = Utils.transliteration("$firstName $lastName")
    val status = if (lastVisit == null) "Ещё ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit!!.humanizeDiff()}"
    val initials = Utils.toInitials(firstName, lastName)

    return UserView(id, "$firstName $lastName", nickName, avatar, status, initials)
}
