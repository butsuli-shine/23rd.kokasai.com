package com.kokasai.the23rd.user

import io.ktor.auth.Principal

data class UserPrincipal(val name: String) : Principal
