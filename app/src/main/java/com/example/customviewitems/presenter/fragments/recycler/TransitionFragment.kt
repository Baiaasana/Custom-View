package com.example.customviewitems.presenter.fragments.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewitems.R
import com.example.customviewitems.data.ItemModel2
import com.example.customviewitems.databinding.FragmentTransitionBinding
import com.example.customviewitems.presenter.adapters.RecyclerAdapter

class TransitionFragment : Fragment() {

    private var _binding: FragmentTransitionBinding? = null
    private val binding get() = _binding!!

    private val item = ItemModel2("Android", "ADJSTAI", R.mipmap.ic_launcher)

//    private val recyclerAdapter: RecyclerAdapter = RecyclerAdapter()
//    private val list = mutableListOf(
//        ItemModel2("Android - 0", "ADJSTAI", R.mipmap.ic_launcher),
//        ItemModel2("Android - 1", "ADJSTAI", R.mipmap.ic_launcher),
//        ItemModel2("Android - 2", "ADJSTAI", R.mipmap.ic_launcher),
//        ItemModel2("Android - 3", "ADJSTAI", R.mipmap.ic_launcher),
//    )

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
        listeners()
        init()
    }

    private fun init() {
        initSingleItem()
//        initRecycler()
    }

    private fun initSingleItem() {
        binding.item = item
    }

//    private fun initRecycler() {
//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//            adapter = recyclerAdapter
//        }
//        recyclerAdapter.submitList(list)
//    }

    private fun listeners() {
        binding.root.setOnClickListener {
            val extras = FragmentNavigatorExtras(
                binding.ivImage to "image_to",
                binding.tvTitle to "title_to",
                binding.tvSubtitle to "subtitle_to"
            )
            findNavController().navigate(
                directions = TransitionFragmentDirections.actionRecyclerFragmentToRecyclerDetailsFragment(
                    item
                ), navigatorExtras = extras
            )
        }

//        recyclerAdapter.onItemClickListener = {
//            val extras = FragmentNavigatorExtras(
//                binding.ivImage to "image_to",
//                binding.tvTitle to "title_to",
//                binding.tvSubtitle to "subtitle_to"
//            )
//            findNavController().navigate(
//                directions = TransitionFragmentDirections.actionRecyclerFragmentToRecyclerDetailsFragment(
//                    it
//                ), navigatorExtras = extras
//            )
//
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}