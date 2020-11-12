package com.hariofspades.platter.feature.platter

import androidx.recyclerview.widget.DiffUtil


class CartDiffUtilCallBack: DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(p0: String, p1: String): Boolean {
        return p0 == p1
    }

    override fun areContentsTheSame(p0: String, p1: String): Boolean {
        return p0 == p1
    }
}