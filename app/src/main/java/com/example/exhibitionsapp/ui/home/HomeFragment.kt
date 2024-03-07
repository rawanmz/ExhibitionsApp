package com.example.exhibitionsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exhibitionsapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val list = listOf<String>(
            "apple",
            "orange",
            "apple",
            "orange",
            "apple",
            "orange",
            "apple",
            "orange",
            "apple",
            "orange",
            "apple",
            "orange"
        )
        val homeViewModel by viewModels<HomeViewModel>()

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val homeAdapter = HomeListAdapter(list)
        val recyclerView: RecyclerView = binding.recyclerviewHome
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = homeAdapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}