package com.example.fragments.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.google.android.material.button.MaterialButton

class FirstFragment : Fragment() {
    private lateinit var editText: EditText

    private var firstListener: FirstListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: MaterialButton = view.findViewById(R.id.btnOk)
        editText = view.findViewById(R.id.editText)

        button.setOnClickListener {
            firstListener?.sendFirst(editText.text.toString().trim())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        firstListener = if (context is FirstListener)
            context
        else
            throw RuntimeException("Error occurred!")
    }

    override fun onDetach() {
        super.onDetach()
        firstListener = null
    }

    fun firstText(text: String) {
        editText.setText(text)
    }

    interface FirstListener {
        fun sendFirst(text: String)
    }
}