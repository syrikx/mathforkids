package com.example.mathforkids

import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

//@BindingAdapter("app:cardBackgroundColor")
//fun setCardBackgroundColor(view: CardView, @ColorRes colorRes: Int) {
//    view.setCardBackgroundColor(ContextCompat.getColor(view.context, colorRes))
//}
//@BindingAdapter("app:buttonBackgroundColor")
//fun setBackgroundColor(view: Button, @ColorRes colorRes: Int) {
//    view.setBackgroundColor(ContextCompat.getColor(view.context, colorRes))
//}

//@BindingAdapter("textFromId")
//fun setTextFromId(view: Button, int : Int) {
//        val idStr = view.resources.getResourceEntryName(view.id)
//        val textValue = idStr.replace("num", "")
//        view.text = textValue
//}

//@BindingAdapter("customTextColor")
//fun setCustomTextColor(view: TextView, colorResId: Int) {
//        view.setTextColor(ContextCompat.getColor(view.context, colorResId))
//}
object BindingAdapter {
        @BindingAdapter("customTextColor")
        @JvmStatic
        fun setCustomTextColor(view: TextView, colorResId: Int) {
                view.setTextColor(ContextCompat.getColor(view.context, colorResId))
        }
        @BindingAdapter("customText")
        @JvmStatic
        fun setCustomText(view: TextView, text: String) {
                view.text=text
        }
}
//@BindingAdapter("app:bindClickFromId")
//fun bindClickFromId(view: Button, viewModel: SharedViewModel) {
//    val idStr = view.resources.getResourceEntryName(view.id)
//    val number = idStr.replace("num", "").toIntOrNull()
//
//    number?.let {
//        view.setOnClickListener {
//            viewModel.appendNumber(number)
//        }
//    }
//}


