package kata.tennis.model;

public enum ScoreValue {

    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADVANTAGE("A");

    private final String score;

    ScoreValue(String score) {
        this.score = score;
    }

    public ScoreValue next() {
        if (ordinal() == values().length - 1) {
            return this;
        }
        return values()[ordinal() + 1];
    }

    public ScoreValue previous() {
        if (ordinal() == 0) {
            return this;
        }
        return values()[ordinal() - 1];
    }
}
