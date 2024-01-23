package com.kuaishou.k

object StringUtil {
    /**
     * 是否符合昵称格式
     *
     * @param value
     * @return
     */
    fun isNickname(value: String): Boolean {
        return value.length in 2..10
    }

    /**
     * 是否符合密码格式
     *
     * @param value
     * @return
     */
    fun isPassword(value: String): Boolean {
        return value.length >= 6 && value.length <= 15
    }

    fun formatMessageCount(data: Int): String {
        return if (data > 99) {
            "99+"
        } else data.toString()
    }
}