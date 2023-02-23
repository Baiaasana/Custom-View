package com.example.customviewitems.presenter.fragments.recycler_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.example.customviewitems.databinding.FragmentTransitionDetailsBinding
import com.google.android.material.transition.MaterialContainerTransform

class TransitionDetailsFragment : Fragment() {

    private var _binding: FragmentTransitionDetailsBinding? = null
    private val binding get() = _binding!!

    private val args : TransitionDetailsFragmentArgs by navArgs()

    private fun setUpTransition(){
        val animation = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTransitionDetailsBinding.inflate(inflater, container, false)
        setUpTransition()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.item = args.item
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}