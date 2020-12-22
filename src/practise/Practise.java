package practise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practise {
    public static void main(String[] args) {
        printPhoneNumbers();
    }

    private static void printPhoneNumbers() {

        Map<String, List<String>> phoneNumbers = new HashMap<>();

        phoneNumbers.put("Mary Lou", Arrays.asList("3524187954", "5487986522"));
        phoneNumbers.put("John Doe", Arrays.asList("3524187954", "5487986522"));

        phoneNumbers.entrySet().stream().filter(entry -> entry.getKey().equals("Mary Lou"))
                    .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()))
                    .forEach((key, value)->{
                        System.out.println("key: " + key);
                        value.forEach(v -> System.out.println("Phone Numbers : " + v));
                    });

        List<String> list = Arrays.asList("1", "2", "3", "4");

        list.stream()
                .map(Integer::valueOf)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList())
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Lord of the Rings", 8.8, true));
        movies.add(new Movie("Back to the Future", 8.5, true));
        movies.add(new Movie("Pulp Fiction", 8.2, false));

        //we want to sort our movies List by title. We can use Comparator.comparing()
        // and pass a function that extracts the field to use for sorting – title
        movies.sort(Comparator.comparing(Movie::getTitle));
        movies.forEach(System.out::println);

        //sort our movies List by rating
        movies.sort(Comparator.comparing(Movie::getRating).reversed());
        movies.forEach(System.out::println);

        //custom sorting
        movies.sort(new Comparator<Movie>() {
            @Override
             public int compare(Movie m1, Movie m2){
                if (m1.isStarred() == m2.isStarred()){
                    return 0;
                }
                return m1.isStarred() ? -1 : 1;
            }
        });
        movies.forEach(System.out::println);


        movies.sort(Comparator.comparing(Movie::getRating).reversed().thenComparing(Movie::getTitle).reversed());

       }
}
