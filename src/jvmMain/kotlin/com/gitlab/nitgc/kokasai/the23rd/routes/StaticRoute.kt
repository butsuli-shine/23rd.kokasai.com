package com.gitlab.nitgc.kokasai.the23rd.routes

import com.gitlab.nitgc.kokasai.the23rd.routes.html.*
import io.ktor.http.content.*
import io.ktor.routing.*

fun Routing.staticRoute() {
    static {
        resource(HtmlRoute.Js.MainBundle.path)
    }
}