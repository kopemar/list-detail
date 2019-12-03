package cz.kopemar.listdetail.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.kopemar.listdetail.R

class AboutFragment: NamedFragment() {

    override var fragmentName = R.string.about

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }
}