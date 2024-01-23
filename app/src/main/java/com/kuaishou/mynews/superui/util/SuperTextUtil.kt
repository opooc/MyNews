package com.kuaishou.mynews.superui.util

import android.text.method.LinkMovementMethod
import android.widget.TextView

/**
 * 文本相关工具类
 */
object SuperTextUtil {
    /**
     * 设置富文本，超链接颜色
     *
     * @param view
     * @param color  这里不能传16进制的值  要转为Int
     */
    fun setLinkColor(view: TextView, color: Int) {
        //设置后才可以点击
        /**
         * movementMethod通常用于在TextView中实现链接、单击、滚动等行为，常见的有以下几种：

        LinkMovementMethod：用于处理文本中的链接，当用户点击链接时会打开链接的地址。

        ScrollingMovementMethod：用于使文本可滚动，当用户在TextView中滚动文本时，文本会随着用户的手指移动。

        ArrowKeyMovementMethod：用于处理方向键的移动，当用户按下方向键时，文本光标会移动到下一个位置。

        TouchMovementMethod：用于处理触摸事件，当用户在TextView中触摸文本时，可以捕获触摸事件并执行相应的操作。
         */
        view.movementMethod = LinkMovementMethod.getInstance()

        //链接的颜色
        view.setLinkTextColor(color)
    }
}