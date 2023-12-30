package com.example.navigationcomponentandroid14.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentandroid14.App
import com.example.navigationcomponentandroid14.R
import com.example.navigationcomponentandroid14.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvText.text = App.preferencesHelper?.text
        setupListener()
        goToSecondFragment()
    }

    private fun setupListener() {
        binding.etInputText.addTextChangedListener {
            App.preferencesHelper?.text = it.toString()
            binding.tvText.text = it
        }
    }

    private fun goToSecondFragment() {
        binding.btnGo.setOnClickListener {
            findNavController().navigate(R.id.action_first_fragment_to_third_fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}