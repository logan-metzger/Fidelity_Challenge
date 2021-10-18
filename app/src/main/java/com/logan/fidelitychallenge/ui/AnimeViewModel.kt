package com.logan.fidelitychallenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.logan.fidelitychallenge.networking.models.Anime
import com.logan.fidelitychallenge.networking.models.ApiResponse
import com.logan.fidelitychallenge.repos.AnimeRepository
import com.logan.fidelitychallenge.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeViewModel : ViewModel() {
    private var _anime: MutableLiveData<Result<ApiResponse>> = MutableLiveData()
    val anime: LiveData<Result<ApiResponse>> get() = _anime


    init {
        getAnime("naruto")
    }

    private fun getAnime(animeTitle: String) {
        _anime.value = Result.InProgress
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AnimeRepository.getAnime(animeTitle)
                if (response.body() != null && response.isSuccessful) {
                    _anime.postValue(Result.Success(response.body()!!))
                } else {
                    _anime.postValue(Result.Error("Error fetching results"))
                }
            } catch (e: Exception) {
                _anime.postValue(Result.Error("An unexpected Error occurred"))
            }
        }
    }
}