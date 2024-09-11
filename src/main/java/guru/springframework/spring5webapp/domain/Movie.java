package guru.springframework.spring5webapp.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String id;

    @NonNull
    private String title;


    public Movie(String s) {
        title = s;
    }
}
