import java.util.Random;

/**
 * Classe que contém informações das cartas
 */
public class Card {

    private final String name;
    private final Color color;
    private final Position[] positions;
    /**
     * Construtor que define os principais atributos de uma cara
     * @param name Nome da carta
     * @param color Cor da carta
     * @param positions Todas as posições relativas de movimento
     */
    public Card(String name, Color color, Position[] positions) {
        this.name = name;
        this.color = color;
        this.positions = positions;
    }

    /**
     * Método que devolve o nome da carta
     * @return String que contém o nome da carta
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método que devolve a cor da carta
     * @return Enum Color que contém a cor da carta
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Método que devolve todas as possíveis posições relativas de movimento.
     * A posição atual da peça é o ponto de origem (0,0). Uma carta possui as possíveis posições de movimento em relação ao ponto de origem.
     * @return Um array de Position contendo todas as possíveis posições de movimento em relação ao ponto de origem
     */
    public Position[] getPositions() {
        return this.positions;
    }

    /**
     * Método que cria todas as cartas do jogo, embaralha-as e devolve as 5 que serão utilizadas na partida.
     * @return Vetor de cartas com todas as cartas do jogo
     */
    public static Card[] createCards() {

        // Posição depende de onde a carta está, relativa à peça, ex:
        // row = -2 > duas colunas acima (para diminuir indice da matriz)
        // row = +2 > duas colunas para baixo
        // col = -1 > uma coluna para a esquerda
        // col = +1 > uma coluna para direita
        Card [] allCards = new Card[]{
                new Card("Tiger", Color.NONE,new Position[]{
                        new Position(-2,0),
                        new Position(+1,0)
                }),
                new Card("Dragon", Color.NONE,new Position[]{
                        new Position(-1,-2),
                        new Position(-1,+2),
                        new Position(+1,-1),
                        new Position(+1,+1)
                }),
                new Card("Frog", Color.NONE,new Position[]{
                        new Position(0,-2),
                        new Position(-1,-1),
                        new Position(+1,+1)
                }),
                new Card("Rabbit", Color.NONE,new Position[]{
                        new Position(+1,-1),
                        new Position(-1,+1),
                        new Position(0,+2)
                }),
                new Card("Crab", Color.NONE,new Position[]{
                        new Position(0,-2),
                        new Position(-1,0),
                        new Position(0,+2)
                }),
                new Card("Elephant", Color.NONE,new Position[]{
                        new Position(-1,-1),
                        new Position(0,-1),
                        new Position(-1,+1),
                        new Position(0,+1)
                }),
                new Card("Goose", Color.NONE,new Position[]{
                        new Position(-1,-1),
                        new Position(0,-1),
                        new Position(0,+1),
                        new Position(+1,+1)
                }),
                new Card("Rooster", Color.NONE,new Position[]{
                        new Position(0,-1),
                        new Position(+1,-1),
                        new Position(-1,+1),
                        new Position(0,+1)
                })
        };

        return randomizeCards(allCards);
    }

    private static Card[] randomizeCards(Card[] allCards){
        Random random = new Random();
        Card[] response = new Card[5];

        int n = allCards.length;
        // randomize cards
        for (int i = 0; i < n - 1; i++) {
            int j = i + random.nextInt(n - i);
            Card temp = allCards[i];
            allCards[i] = allCards[j];
            allCards[j] = temp;
        }

        System.arraycopy(allCards, 0, response, 0, response.length);

        return response;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                '}';
    }
}
