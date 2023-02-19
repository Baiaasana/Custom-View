package com.example.customviewitems.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.customviewitems.data.ItemModel
import com.example.customviewitems.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val itemsList = mutableListOf<ItemModel>()

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
    }

    private fun listeners(){
        binding.cvItem.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailsFragment(itemsList[0]))
        }
    }

    private fun setUpItems(){

        itemsList.add(ItemModel("AVATAR - 1", "series", "https://www.thewrap.com/wp-content/uploads/2022/06/Avatar-The-Last-Airbender.jpg"))
        itemsList.add(ItemModel("AVATAR - 2", "series", "https://static.wikia.nocookie.net/avatar/images/a/ae/Aang_at_Jasmine_Dragon.png/revision/latest?cb=20130612174003"))
        itemsList.add(ItemModel("AVATAR - 3", "series", "https://static.wikia.nocookie.net/character-tiers/images/f/f5/Aang_1280.jpg/revision/latest?cb=20200618102019"))

        binding.cvItem.setData(itemsList[0])
        binding.cvItem2.setData(itemsList[1])
        binding.cvItem3.setData(itemsList[2])
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}