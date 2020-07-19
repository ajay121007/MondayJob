package com.mondayjob.mondayjob.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mondayjob.mondayjob.R

class ResumeLetterFragment:Fragment() {
    internal var rootView: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView= inflater.inflate(R.layout.fragment_resume_letter, container, false)
        return  rootView;
    }
}