package com.example.customviewitems.presenter.fragments.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.customviewitems.R
import com.example.customviewitems.databinding.FragmentTransitionBinding

class TransitionFragment : Fragment() {

    private var _binding: FragmentTransitionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTransitionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.ivImage to "image_to", binding.tvTitle to "title_to", binding.tvSubtitle to "subtitle_to")
            findNavController().navigate(
                R.id.action_recyclerFragment_to_recyclerDetailsFragment,
                null, null, extras
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}