package com.whl.a328_chat.ui.custom_view

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.whl.a328_chat.R
import com.whl.a328_chat.utils.dp

private val TEXT_SIZE = 12.dp
private val TEXT_MARGIN = 8.dp
private val HORIZONTAL_OFFSET = 5.dp
private val VERTICAL_OFFSET = 23.dp
private val EXTRA_VERTICAL_OFFSET = 16.dp


class MaterialEditText(context: Context, attrs: AttributeSet) :
    AppCompatEditText(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var isFloatShown = false
    private val animator by lazy {
        ObjectAnimator.ofFloat(this, "friction", 0f, 1f)
    }
    var friction: Float = 0f
        set(value) {
            field = value
            invalidate()
        }
    var useFloatingLabel: Boolean = true
        set(value) {
            if(field != value) {
                field = value
                if (field){
                    setPadding(
                        paddingLeft,
                        (paddingTop + TEXT_MARGIN + TEXT_SIZE).toInt(),
                        paddingRight,
                        paddingBottom
                    )
                } else {
                    setPadding(
                        paddingLeft,
                        (paddingTop - TEXT_MARGIN - TEXT_SIZE).toInt(),
                        paddingRight,
                        paddingBottom
                    )
                }
            }
        }

    init {
        // TODO STEP1 完成 EditText上方添加一片文字空间, 和间隙
        if(useFloatingLabel){ // 处理第一次
            setPadding(
                paddingLeft,
                (paddingTop + TEXT_MARGIN + TEXT_SIZE).toInt(),
                paddingRight,
                paddingBottom
            )
        }
        paint.textSize = TEXT_SIZE

        for (index in 0 until attrs.attributeCount) {
            println("Attrs: key: ${attrs.getAttributeName(index)}, value: ${attrs.getAttributeValue(index)}")
        }

//        val typedArray = context.obtainStyledAttributes(attrs, intArrayOf(R.attr.useFloatingLabel))
//        useFloatingLabel = typedArray.getBoolean(0, true)
//        typedArray.recycle()
    }

    // TODO STEP3 完成提示在透明度和竖直位移上的动画
    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if(isFloatShown && text.isNullOrEmpty()){
            // 提示出现
            isFloatShown = false
            animator.reverse()
        }else if (!isFloatShown && !text.isNullOrEmpty()){
            // 提示消失
            isFloatShown = true
            animator.start()
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.alpha = (0xff * friction).toInt()
        val y = VERTICAL_OFFSET + EXTRA_VERTICAL_OFFSET * (1 - friction) // 23dp -> 39dp 39dp -> 23dp

        // TODO STEP2 完成输入内容提示消失，不输入内容提示弹出
        canvas.drawText(hint.toString(), HORIZONTAL_OFFSET, y, paint)
    }
}