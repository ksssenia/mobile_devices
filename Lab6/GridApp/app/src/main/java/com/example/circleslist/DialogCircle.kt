package com.example.circleslist

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogCircle: DialogFragment() {
    private var CircleNum: Int = 0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Number")
            .setMessage("Number of this circle is: " + CircleNum.toString())
            .setPositiveButton("Ok", null)
            .create()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CircleNum = arguments?.getInt("CircleNum") as Int
    }


    companion object {
        fun newInstance(number: Int): DialogCircle {
            val args = Bundle()
            args.putInt("CircleNum", number)
            val fragment = DialogCircle()
            fragment.arguments = args
            return fragment
        }
    }
}