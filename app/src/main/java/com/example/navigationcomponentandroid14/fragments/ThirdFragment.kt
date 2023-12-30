package com.example.navigationcomponentandroid14.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponentandroid14.R
import com.example.navigationcomponentandroid14.databinding.FragmentThirdBinding
import com.google.android.material.snackbar.Snackbar

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding: FragmentThirdBinding get() = _binding!!
    private val args by navArgs<ThirdFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBack()
        getArgs(view)
    }

    private fun goBack() {
        binding.iconBack.setOnClickListener {
            findNavController().apply {
                popBackStack(R.id.second_fragment, true)
            }
        }
    }

    private fun getArgs(view: View) {
        args.model?.let {
            Log.e("argument", it.toString())
            Snackbar.make(view, it.text, Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}