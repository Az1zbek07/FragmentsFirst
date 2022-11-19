package com.example.fragments.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.google.android.material.button.MaterialButton

class SecondFragment : Fragment() {
    private var secondListener: SecondListener? = null
    private lateinit var editText: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: MaterialButton = view.findViewById(R.id.btnOk)
        editText = view.findViewById(R.id.editText)

        button.setOnClickListener {
            secondListener?.sendSecond(editText.text.toString().trim())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        secondListener = if (context is SecondListener)
            context
        else
            throw RuntimeException("Error")
    }

    override fun onDetach() {
        super.onDetach()
        secondListener = null
    }

    fun secondText(text: String) {
        editText.setText(text)
    }

    interface SecondListener {
        fun sendSecond(text: String)
    }
}