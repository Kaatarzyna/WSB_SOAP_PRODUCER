package wsb.soap;

import localhost._8080.Movie;
import localhost._8080.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {

    static final List<Movie> movies = new LinkedList<>();

    @PostConstruct
    public void initData() {

        Person quentinTarantino = new Person();
        quentinTarantino.setName("Quentin");
        quentinTarantino.setLastName("Tarantino");

        Movie pulpFiction = new Movie();
        pulpFiction.setTitle("Pulp Fiction");
        pulpFiction.setDirector(quentinTarantino);
        pulpFiction.setYear(1994);

        Person aaronSorkin = new Person();
        aaronSorkin.setName("Aaron");
        aaronSorkin.setLastName("Sorkin");

        Movie chicago7 = new Movie();
        chicago7.setTitle("Proces Siódemki z Chicago");
        chicago7.setDirector(aaronSorkin);
        chicago7.setYear(2020);

        Person davidFincher = new Person();
        davidFincher.setName("David");
        davidFincher.setLastName("Fincher");

        Movie fightClub = new Movie();
        fightClub.setTitle("Fight Club");
        fightClub.setDirector(davidFincher);
        fightClub.setYear(1999);

        movies.add(pulpFiction);
        movies.add(chicago7);
        movies.add(fightClub);
    }

    public List<Movie> find(String title) {
        return movies.stream()
                .filter(m -> m.getTitle().toLowerCase().contains(title != null ? title : ""))
                .collect(Collectors.toList());
    }
}
