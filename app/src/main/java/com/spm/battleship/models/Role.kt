package com.spm.battleship.models

enum class Role(val id: Int, val roleName: String) {
    HOST(0, "host"),
    GUEST(1, "guest")
}