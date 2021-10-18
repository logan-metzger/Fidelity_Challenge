package com.logan.fidelitychallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.logan.fidelitychallenge.databinding.AnimeItemBinding
import com.logan.fidelitychallenge.networking.models.Anime
import com.logan.fidelitychallenge.utils.loadImage

class AnimeAdapter() : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {
    private val anime = mutableListOf<Anime>()

    class AnimeViewHolder(private val binding: AnimeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            anime: Anime
        ) = with(binding) {
            if(anime.airing) {
                this.animeAiringTv.text = "On Air"
            } else {
                this.animeAiringTv.text = "Off Air"
            }
            this.animeEpisodesTv.text = anime.episodes.toString()
            this.animeIv.loadImage(anime.imageUrl)
            this.animeMediaTypeTv.text = anime.type
            this.animeScoreTv.text = anime.score.toString()
            this.animeSynopsisTv.text = anime.synopsis
            this.animeEpisodesTv.text = anime.episodes.toString()
            this.animeTitleTv.text = anime.title
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = AnimeItemBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
    ).let {
        AnimeViewHolder(it)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(anime[position])
    }

    override fun getItemCount(): Int {
        return anime.size
    }

    fun loadData(newAnime: List<Anime>) {
        anime.clear()
        anime.addAll(newAnime)
        notifyDataSetChanged()
    }
}