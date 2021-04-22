package wsb.soap;

import localhost._8080.FindMovieRequest;
import localhost._8080.FindMovieResponse;
import localhost._8080.Movie;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class MovieEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080";

    private final MovieRepository movieRepository;

    public MovieEndpoint(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findMovieRequest")
    @ResponsePayload
    public FindMovieResponse findMovie(@RequestPayload FindMovieRequest request) {

        String title = request.getTitle();
        List<Movie> movies = movieRepository.find(title);

        FindMovieResponse response = new FindMovieResponse();
        response.getMovies().addAll(movies);

        return response;
    }
}
