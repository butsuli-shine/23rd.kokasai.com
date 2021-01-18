package com.kokasai.the23rd

import com.kokasai.flowerkt.*
import com.kokasai.flowerkt.database.*
import com.kokasai.flowerkt.file.*
import com.kokasai.flowerkt.route.*
import com.kokasai.the23rd.configure.*
import com.kokasai.the23rd.routes.*
import com.kokasai.the23rd.routes.html.*
import com.kokasai.the23rd.routes.websocket.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.features.*
import io.ktor.sessions.*
import io.ktor.websocket.*

object Kokasai23rd: FlowerKt() {
    override val databaseProvider = SQLiteDatabaseProvider(".data.db")
    override val port = 8080
    override val fileProvider = WebDAVFileProvider(HttpClient(OkHttp) {
        install(Auth) {
            basic {
                username = System.getenv(SystemEnv.WebDEV.UserName)
                password = System.getenv(SystemEnv.WebDEV.Password)
            }
        }
    }, System.getenv(SystemEnv.WebDEV.Url))
    override val routeBuilder = HtmlRouteBuilder + WebSocketRouteBuilder + route {
        fileRoutes()
        cssRoutes()
        staticRoute()

        testRoute()
    }

    override fun Application.installKtorFeature() {
        install(Sessions) {
            configureAuthCookie()
        }

        install(Authentication) {
            configureFormAuth()
            configureSessionAuth()
        }

        install(ContentNegotiation) {
            configureGson()
        }

        install(WebSockets)
    }
}