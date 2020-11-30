package com.kokasai.flowerkt.html

import com.kokasai.flowerkt.route.*
import com.kokasai.the23rd.routes.html.*
import kotlinx.html.*

@HtmlTagMarker
fun FlowOrPhrasingOrMetaDataContent.css(href: HtmlRoute.Css) =
    link(rel = LinkRel.stylesheet, href = href.fullPath, type = StyleType.textCss)

@HtmlTagMarker
fun FlowOrPhrasingOrMetaDataContent.javaScript(src: HtmlRoute.Js) =
    script(src = src.fullPath, type = ScriptType.textJavaScript) {}

@HtmlTagMarker
inline fun FlowOrInteractiveOrPhrasingContent.a(
    href: RoutePath? = null,
    target: String? = null,
    classes: String? = null,
    crossinline block: A.() -> Unit = {}
) = a(href?.fullPath, target, classes, block)