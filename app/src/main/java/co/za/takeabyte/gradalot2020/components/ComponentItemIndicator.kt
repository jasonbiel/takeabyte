package co.za.takeabyte.gradalot2020.components

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.AttrRes

class ComponentItemIndicator : FrameLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleRes: Int) : super(
        context,
        attrs,
        defStyleRes
    )



}