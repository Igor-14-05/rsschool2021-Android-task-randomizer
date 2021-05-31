package com.rsschool.android2021

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    private var generateButton: Button? = null
    private var previousResult: TextView? = null
//    private lateinit var Listener: OnGenerate
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previousResult = view.findViewById(R.id.previous_result)
        generateButton = view.findViewById(R.id.generate)

        val result = arguments?.getInt(PREVIOUS_RESULT_KEY)
        previousResult?.text = "Previous result: ${result.toString()}"

        // TODO: val min = ...
        // TODO: val max = ...
        val min = 0
        val max = 100

        //TODO TROUBLE
//        val minn= min?.getText() as Int
//        val maxx = max?.getText() as Int
//        val minn = Integer.parseInt(min?.getText() as String)
//        val maxx = Integer.parseInt(max?.getText() as String)
        generateButton?.setOnClickListener {
            // TODO: send min and max to the SecondFragment
//           Listener.onGenerateButtonClick(minn,maxx)
            MainActivity().openSecondFragment(min,max)
        }
    }

//    interface OnGenerate{
//        fun onGenerateButtonClick(min: Int, max: Int)
//    }

    companion object {

        @JvmStatic
        fun newInstance(previousResult: Int): FirstFragment {
            val fragment = FirstFragment()
            val args = Bundle()
            args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        private const val PREVIOUS_RESULT_KEY = "PREVIOUS_RESULT"
    }
}