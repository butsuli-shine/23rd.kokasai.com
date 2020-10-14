package com.gitlab.nitgc.kokasai.flowerkt.html

import com.gitlab.nitgc.kokasai.flowerkt.route.*
import com.gitlab.nitgc.kokasai.the23rd.routes.*
import kotlinx.html.*

@HtmlTagMarker
fun FlowOrPhrasingOrMetaDataContent.css(href: HtmlRoute.Css) =
    link(rel = LinkRel.stylesheet, href = href.full_path, type = StyleType.textCss)

@HtmlTagMarker
fun FlowOrPhrasingOrMetaDataContent.javaScript(src: HtmlRoute.Js) =
    script(src = src.full_path, type = ScriptType.textJavaScript) {}

@HtmlTagMarker
inline fun FlowOrInteractiveOrPhrasingContent.a(
    href: RoutePath? = null,
    target: String? = null,
    classes: String? = null,
    crossinline block: A.() -> Unit = {}
) = a(href?.full_path, target, classes, block)