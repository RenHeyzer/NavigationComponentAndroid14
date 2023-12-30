package com.example.navigationcomponentandroid14.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentandroid14.R
import com.example.navigationcomponentandroid14.databinding.FragmentFirstBinding
import com.example.navigationcomponentandroid14.databinding.FragmentSecondBinding
import com.example.navigationcomponentandroid14.models.Arguments

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToThirdFragment()
        goBack()
    }

    private fun goToThirdFragment() = with(binding) {
        btnGo.setOnClickListener {
            val text = etInput.text.toString().trim()
            val model = Arguments(
                text = text,
                tags = listOf("Tag 1", "Tag 2", "Tag 3"),
                isTransition = true
            )
            findNavController().navigate(
                SecondFragmentDirections.actionSecondFragmentToThirdFragment(model)
            )
        }
    }

    private fun goBack() {
        binding.iconBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}