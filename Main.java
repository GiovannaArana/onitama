import java.util.Arrays;

public class Main {

    /**
     * Class for tests, will be replaced by jUnit tests after the development fase is over
     */

    public static Card[] testCardsCreate(){
        Card [] cards = Card.createCards();
        Arrays.stream(cards).forEach(System.out::println);
        return cards;
    }

    public static void testPlayerSwapCards(Card[] cards, Player p1) {
        System.out.println("\nSwapping cards!");
        System.out.println("Before swap:");
        Arrays.stream(p1.getCards()).forEach(System.out::println);

//        Erro
        p1.swapCard(cards[3], cards[2]);
//        troca
        p1.swapCard(cards[0], cards[2]);

        System.out.println("After swap:");
        Arrays.stream(p1.getCards()).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Card [] cards = testCardsCreate();
        Player p1 = new Player("arana", Color.RED, cards[0], cards[1]);

//        testPlayerSwapCards(cards, p1);
    }
}
