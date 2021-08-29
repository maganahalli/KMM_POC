package com.mobile.venky.kmm.ktor.poc

import android.graphics.Bitmap
import android.graphics.BitmapFactory

actual typealias Image = Bitmap

actual fun ByteArray.toSharedImage(): Image? =
    BitmapFactory.decodeByteArray(this, 0, this.size)