package com.kokasai.api.configure

import com.kokasai.api.KokasaiAPI
import com.kokasai.api.auth.UserLogin
import com.kokasai.flowerkt.session.SessionStorageExposed
import io.ktor.sessions.Sessions
import io.ktor.sessions.cookie

fun Sessions.Configuration.configureAuthCookie() {
    cookie<UserLogin.Data>(UserLogin.cookie, storage = SessionStorageExposed(KokasaiAPI.sessionTable)) {
        cookie.path = "/"
    }
}