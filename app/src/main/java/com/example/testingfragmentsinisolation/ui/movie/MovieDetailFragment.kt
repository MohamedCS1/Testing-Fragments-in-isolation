package com.example.testingfragmentsinisolation.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.testingfragmentsinisolation.R
import com.example.testingfragmentsinisolation.data.source.MoviesRemoteDataSource

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieDetailFragment : Fragment(){

    private lateinit var movie_description:TextView
    private lateinit var movie_directiors: TextView
    private lateinit var movie_image: ImageView
    private lateinit var movie_title: TextView
    private lateinit var movie_star_actors:TextView
    private lateinit var movie: Movie
    lateinit var MoviesRemoteDataSource: MoviesRemoteDataSource
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            args.getInt("movie_id").let{ movieId ->
                MoviesRemoteDataSource.getMovie(movieId)?.let{ movieFromRemote ->
                    movie = movieFromRemote
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_detail, container, false)
        movie_description = view.findViewById(R.id.movie_description)
        movie_directiors = view.findViewById(R.id.movie_directiors)
        movie_image = view.findViewById(R.id.movie_image)
        movie_title = view.findViewById(R.id.movie_title)
        movie_star_actors = view.findViewById(R.id.movie_star_actors)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMovieDetails()

        movie_directiors.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_directors", movie.directors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, DirectorsFragment::class.java, bundle)
                ?.addToBackStack("DirectorsFragment")
                ?.commit()
        }

        movie_star_actors.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_actors", movie.star_actors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, StarActorsFragment::class.java, bundle)
                ?.addToBackStack("StarActorsFragment")
                ?.commit()
        }
    }

    private fun setMovieDetails(){
        movie.let{ nonNullMovie ->
            Glide.with(requireContext())
                .load(nonNullMovie.image)
                .into(movie_image)
            movie_title.text = nonNullMovie.title
            movie_description.text = nonNullMovie.description
        }
    }

}
