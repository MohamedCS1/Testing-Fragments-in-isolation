package com.example.testingfragmentsinisolation.data.source

import com.example.testingfragmentsinisolation.ui.movie.Movie

interface MoviesDataSource {
    fun getMovie(movieId: Int): Movie?
}