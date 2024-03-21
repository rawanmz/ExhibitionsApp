package com.example.exhibitionsapp.ui.dashboard

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.exhibitionsapp.R
import com.example.exhibitionsapp.common.UIState
import com.example.exhibitionsapp.data.model.ExhibitionResponse
import com.example.exhibitionsapp.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val dashboardViewModel: DashboardViewModel by viewModels<DashboardViewModel>()
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        observeData(dashboardViewModel.artWork)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun observeData(artWork: MutableLiveData<UIState<ExhibitionResponse>>) {
        artWork.observe(viewLifecycleOwner, Observer { uiState ->
            when (uiState) {
                is UIState.Success -> {
                    binding.progress.visibility = View.GONE
                    binding.textDashboard.text = uiState.responseData?.data?.get(1)?.title
                    Glide.with(requireContext())
                        .load(uiState.responseData?.data?.get(2)?.imageUrl)
                        .error(R.drawable.ic_notifications_black_24dp)
                        .into(binding.imageView)
                }

                is UIState.Empty -> {

                }

                is UIState.Error -> {

                }

                is UIState.Loading -> {
                    binding.progress.visibility = View.VISIBLE
                }
            }
        })
    }
}