package com.gitlab.nitgc.kokasai.the23rd.routes

import com.gitlab.nitgc.kokasai.the23rd.extension.respondCss
import com.gitlab.nitgc.kokasai.the23rd.routes.template.WithHeaderTemplate.headerCss
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing

fun Routing.cssRoutes() {
    get("/header.css") {
        call.respondCss(headerCss)
    }
}