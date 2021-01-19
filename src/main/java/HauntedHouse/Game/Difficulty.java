package HauntedHouse.Game;

import HauntedHouse.Generated;

/**
 * Enum class with Difficulty levels
 *
 * @author Pedro Machado "pedroma2000"
 */
@Generated
public enum Difficulty {
    EASY, MEDIUM, HARD;

    /**
     * method to get the difficulty factor,
     * given a
     *
     * @param diff difficulty
     * @return the difficulty factor
     */
    public static int getDifficultyFactor(Difficulty diff) {
        int factor = 0;
        switch (diff) {
            case EASY:
                factor = 1;
                break;

            case MEDIUM:
                factor = 2;
                break;

            case HARD:
                factor = 3;
                break;
        }
        return factor;
    }
}