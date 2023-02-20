package com.example.customviewitems.presenter.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.customviewitems.data.ItemModel
import com.example.customviewitems.databinding.FragmentListBinding
import com.example.customviewitems.presenter.adapters.CustomViewAdapter

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CustomViewAdapter

    private val itemsList = mutableListOf(
        ItemModel(
            "AVATAR - 1",
            "series",
            "https://www.thewrap.com/wp-content/uploads/2022/06/Avatar-The-Last-Airbender.jpg"

        ),
        ItemModel(
            "AVATAR - 2",
            "series",
            "https://static.wikia.nocookie.net/avatar/images/a/ae/Aang_at_Jasmine_Dragon.png/revision/latest?cb=20130612174003"

        ),
        ItemModel(
            "AVATAR - 3",
            "series",
            "https://static.wikia.nocookie.net/character-tiers/images/f/f5/Aang_1280.jpg/revision/latest?cb=20200618102019"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpItems()
        listeners()
        enable()
    }

    fun enable(){
        binding.selectorSwitch.setOnCheckedChangeListener { compoundButton, b ->
            binding.bulb.isEnabled = b
        }
    }

    private fun listeners() {
        binding.listView.setOnItemClickListener { _, _, position, _ ->
            findNavController().navigate(
                ListFragmentDirections.actionListFragmentToDetailsFragment(
                    itemsList[position]
                )
            )
        }
        binding.btnSignUp.setOnClickListener {
            navigateToSignUp()
        }
    }
    fun navigateToSignUp(){
        findNavController().navigate(ListFragmentDirections.actionListFragmentToSignUpFragment())
    }

    private fun setUpItems() {
        adapter = CustomViewAdapter(requireContext(), itemsList)
        binding.listView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}