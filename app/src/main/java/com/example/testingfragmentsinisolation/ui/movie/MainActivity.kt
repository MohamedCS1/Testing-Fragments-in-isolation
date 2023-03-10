package com.example.testingfragmentsinisolation.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testingfragmentsinisolation.R
import com.example.testingfragmentsinisolation.factory.MovieFragmentFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.fragmentFactory = MovieFragmentFactory()

        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            val movieId = 0
            val bundle = Bundle()
            bundle.putInt("movie_id", movieId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieDetailFragment::class.java, bundle)
                .commit()
        }
    }
}