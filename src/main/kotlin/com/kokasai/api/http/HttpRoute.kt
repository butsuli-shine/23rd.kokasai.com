package com.kokasai.api.http

import com.kokasai.flowerkt.route.RoutePath
import com.kokasai.api.http.form.assign as formAssign
import com.kokasai.api.http.group.document.list as groupDocumentList
import com.kokasai.api.http.group.form.get as groupFormGet
import com.kokasai.api.http.group.form.list as groupFormList
import com.kokasai.api.http.group.form.submit as groupFormSubmit
import com.kokasai.api.http.group.list as groupList
import com.kokasai.api.http.group.user.list as groupUserList
import com.kokasai.api.http.logout.all as logoutAll
import com.kokasai.api.http.logout.index as logoutIndex
import com.kokasai.api.http.user.document.list as userDocumentList
import com.kokasai.api.http.user.form.list as userFormList
import com.kokasai.api.http.user.group.list as userGroupList

object HttpRoute : RoutePath("/") {
    override val child = setOf(Index, Auth, Login, Logout, Session, Document, Form, Group, User)

    object Index : RoutePath("/", action = index)
    object Auth : RoutePath("/auth", action = auth)
    object Login : RoutePath("/login", action = login)
    object Logout : RoutePath("/logout") {
        override val child = setOf(Index, All)

        object Index : RoutePath(this, "/", action = logoutIndex)
        object All : RoutePath(this, "/all", action = logoutAll)
    }
    object Session : RoutePath("/session", action = session)
    object Document : RoutePath("/document", action = document)
    object Form : RoutePath("/form") {
        override val child = setOf(Assign)

        object Assign : RoutePath(this, "/assign", action = formAssign)
    }
    object Group : RoutePath("/group") {
        override val child = setOf(List, Form, Document, User)

        object List : RoutePath(this, "/list", action = groupList)
        object Form : RoutePath(this, "/form") {
            override val child = setOf(List, Get, Submit)

            object List : RoutePath(this, "/list", action = groupFormList)
            object Get : RoutePath(this, "/get", action = groupFormGet)
            object Submit : RoutePath(this, "/submit", action = groupFormSubmit)
        }
        object Document : RoutePath(this, "/document") {
            override val child = setOf(List)

            object List : RoutePath(this, "/list", action = groupDocumentList)
        }
        object User : RoutePath(this, "/user") {
            override val child = setOf(List)

            object List : RoutePath(this, "/list", action = groupUserList)
        }
    }
    object User : RoutePath("/user") {
        override val child = setOf(Form, Document, Group)

        object Form : RoutePath(this, "/form") {
            override val child = setOf(List)

            object List : RoutePath(this, "/list", action = userFormList)
        }
        object Document : RoutePath(this, "/document") {
            override val child = setOf(List)

            object List : RoutePath(this, "/list", action = userDocumentList)
        }
        object Group : RoutePath(this, "/group") {
            override val child = setOf(List)

            object List : RoutePath(this, "/list", action = userGroupList)
        }
    }
}
