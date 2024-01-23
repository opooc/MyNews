package com.kuaishou.mynews.superui.date

import java.util.Calendar

/**
 * 获取年份
 */
object SuperDateUtil {
  fun currentYear(): Int {
    return Calendar.getInstance().get(Calendar.YEAR)
  }
}