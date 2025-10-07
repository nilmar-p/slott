package enums;

public enum Color {
    BLACK("ROXO"),
    WHITE("BANCO"),
    SILVER("PRATA"),
    GRAY("CINZA"),
    BLUE("AZUL"),
    RED("VERMELHO"),
    GREEN("VERDE"),
    YELLOW("AMARELO"),
    ORANGE("LARANJA"),
    BROWN("MARROM"),
    GOLD("DOURADO"),
    BEIGE("BEGE"),
    PURPLE("ROXO"),
    NONE("NENHUM");

    public final String description;

    private Color(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }

}
