package mzx.imdbproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater

internal val Context.inflater: LayoutInflater
    get() = LayoutInflater.from(this)
