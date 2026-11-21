public class ExpSystem {
    public static int MaxLevel = 50;
    private static final int FirstLevelUp = 100;
    private static final int LevelUpExp = 25;
    private long totalExp = 0;

    public void earnExp(int amount){
        if (amount < 0){
            return;
        }
        totalExp += amount;
    }
    //exp undo
    public void removeExp(int amount) {
        if (amount < 0) {
           return;
        }
        totalExp = totalExp - amount;
            if (totalExp < 0){ //can't have negative exp
                totalExp = 0;
            }
    }

    public long getTotalExp() {
        return totalExp;
    }

    //level up exp required
    private static int expRequiredAtLevel(int level) {
        return FirstLevelUp + (level - 1) * LevelUpExp; //essentially adds +25 exp per level
    }

    public int getLevel() {
        long remaining = totalExp;
        int level = 1;

        while (level < MaxLevel) {
            int required = expRequiredAtLevel(level);

            if (remaining < required) {
                break;
            }

            remaining -= required;
            level++;
        }

        return level;
    }

    public long getExpInLevel() {
        if (isMaxLevel()) {
            return 0;
        }

        long remaining = totalExp;

        for (int level = 1; level < getLevel(); level++) {
            remaining -= expRequiredAtLevel(level);
        }

        return remaining;
    }


    public int getNextLevelExp() {
        return isMaxLevel() ? 0 : expRequiredAtLevel(getLevel());
    }

    public double getProgressToNextLevel() {
        if (isMaxLevel()) {
            return 1.0;
        }

        return (double) getExpInLevel() / getNextLevelExp();
    }

    public boolean isMaxLevel() {
        return getLevel() == MaxLevel;
    }
}
