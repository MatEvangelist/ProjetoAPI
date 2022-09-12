package user;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@Getter
@Setter
public class UsersLombok extends Users {

    private static Faker faker = new Faker();

    @Builder.Default
    private String email = faker.internet().emailAddress();
    @Builder.Default
    private String gender = getValorAleatorio("male", "female");
    @Builder.Default
    private String name = faker.name().fullName();
    @Builder.Default
    private String status = getValorAleatorio("active", "inactive");

    public static String getValorAleatorio(String... args) {
        List<String> valores = Arrays.asList(args);
        Collections.shuffle(valores);
        return valores.get(0);
    }

}
