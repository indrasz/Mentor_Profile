package org.d3if4404.mentoring.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if4404.mentoring.databinding.ItemProfileMentorBinding
import org.d3if4404.mentoring.model.Mentor

class MentorAdapter(private val listMentor: ArrayList<Mentor>) :
    RecyclerView.Adapter<MentorAdapter.ListViewMentorHolder>() {

    inner class ListViewMentorHolder(private val binding: ItemProfileMentorBinding) :

        RecyclerView.ViewHolder(binding.root) {

        fun bind(mentor: Mentor){
            with(binding){
                Glide.with(this.root)
                    .load(mentor.images)
                    .into(binding.ivMentor)

                binding.apply {
                    tvMentorName.text = mentor.name
                    tvExperience.text = mentor.experience
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewMentorHolder =
        ListViewMentorHolder(
            ItemProfileMentorBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ListViewMentorHolder, position: Int) {
        holder.bind(listMentor[position])
    }

    override fun getItemCount(): Int = listMentor.size
}