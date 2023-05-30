import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Card [] cards = Card.createCards();
        Arrays.stream(cards).forEach(System.out::println);
    }
}
