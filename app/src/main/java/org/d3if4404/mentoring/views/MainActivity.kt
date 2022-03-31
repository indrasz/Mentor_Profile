package org.d3if4404.mentoring.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if4404.mentoring.R
import org.d3if4404.mentoring.adapter.MentorAdapter
import org.d3if4404.mentoring.databinding.ActivityMainBinding
import org.d3if4404.mentoring.model.Mentor

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayListMentor()
    }

    @SuppressLint("Recycle")
    private fun displayListMentor(){
        val listMentor = ArrayList<Mentor>()
        val images = resources.obtainTypedArray(R.array.mentor_image)
        val name = resources.getStringArray(R.array.mentor_name)
        val experience = resources.getStringArray(R.array.mentor_experience)
        val workplace = resources.getStringArray(R.array.mentor_workplace)
        val review = resources.getStringArray(R.array.mentor_review)

        for(pos in name.indices){
            listMentor.add(
                Mentor(
                    name = name[pos],
                    experience = experience[pos],
                    workplace = workplace[pos],
                    review = review[pos],
                    images = images.getResourceId(pos, -1)
                )
            )
        }

        binding.rvListMentor.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = MentorAdapter(listMentor)
            setHasFixedSize(true)
        }
    }

}