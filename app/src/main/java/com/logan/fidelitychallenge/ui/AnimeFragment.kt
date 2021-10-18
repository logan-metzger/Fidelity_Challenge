package com.logan.fidelitychallenge.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.logan.fidelitychallenge.adapters.AnimeAdapter
import com.logan.fidelitychallenge.databinding.FragmentAnimeBinding
import com.logan.fidelitychallenge.utils.Result

class AnimeFragment: Fragment() {
    private var _binding: FragmentAnimeBinding? = null
    private val binding: FragmentAnimeBinding get() = _binding!!

    private val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter: AnimeAdapter by lazy {
        AnimeAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            animeRv.adapter = animeAdapter
            viewModel.anime.observe(viewLifecycleOwner, { result ->
                when(result) {
                    is Result.InProgress -> {
                        progressBar.isVisible = true
                    }
                    is Result.Success -> {
                        progressBar.isVisible = false
                        animeAdapter.loadData(result.data.results)
                    }
                    is Result.Error -> {
                        progressBar.isVisible = false
                    }
                }
            })
        }
    }
}