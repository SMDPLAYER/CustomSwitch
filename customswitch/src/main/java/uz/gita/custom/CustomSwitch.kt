package uz.gita.custom

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ImageView


@SuppressLint("AppCompatCustomView")
class CustomSwitch @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : ImageView(context, attrs, defStyle) {
    private var listenerChange: OnChangeListener? = null

    var isChecked: Boolean = false
        set(value) {
            field = value
            updateSwitchState()
        }

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomSwitch)
        isChecked = typedArray.getBoolean(R.styleable.CustomSwitch_icChecked, isChecked)
        typedArray.recycle()

        updateSwitchState()
        /*super.setOnClickListener {
            isChecked = !isChecked
            updateSwitchState()
        }*/
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_UP -> {
                val isRight = event.x > width / 2
                if (isChecked && isRight && event.x < width * 0.9) {
                    isChecked = false
                } else if (!isChecked && !isRight && event.x > width * 0.1) {
                    isChecked = true
                }
            }
        }
        return true//super.onTouchEvent(event)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        //super.setOnClickListener(l)
    }

    private fun updateSwitchState() {
        setImageResource(if (isChecked) R.drawable.on_swtich else R.drawable.off_switch)
        listenerChange?.onChanged(isChecked)
    }

    fun setOnChangeListener(block: OnChangeListener) {
        listenerChange = block
    }

    //SAM
    fun interface OnChangeListener {
        fun onChanged(isChecked: Boolean)
    }
}