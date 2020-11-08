package AI;

public class StepAdvisor {

    //Simple MinMax algorithm
    public static Operator offerMove(GameState gameState, int supportedPlayer, int depth, int limit) {
        Operator best = null;
        Operator operators = new Operator();
        double max = Integer.MIN_VALUE;

        for (Operator op : operators.getOperators()) {
            if (op.isApplicable(gameState.getState())) {
                GameState nextState = op.applyMove(gameState);
                double result = minSearch(nextState, supportedPlayer, ++depth, limit);
                if (max < result) {
                    max = result;
                    best = op;
                }
            }
        }
        return best;
    }

    private static double minSearch(GameState state, int sp, int depth, int limit) {
        if (state.isWinningState() || state.isOver()) {
            return Heuristic.heurNum(state, sp) + (depth * 0.1);
        }

        double min = Integer.MAX_VALUE;
        Operator operators = new Operator();

        if (depth < limit) {
            for (Operator op : operators.getOperators()) {
                if (op.isApplicable(state.getState())) {
                    GameState nextState = op.applyMove(state);
                    double result = maxSearch(nextState, sp, ++depth, limit);
                    if (min > result) {
                        min = result;
                    }
                }
            }
        }
        return min;
    }

    private static double maxSearch(GameState state, int sp, int depth, int limit) {
        if (state.isOver() || state.isWinningState()) {
            return Heuristic.heurNum(state, sp) - (depth * 0.1);
        }

        double max = Integer.MIN_VALUE;
        Operator operators = new Operator();

        if (depth < limit) {
            for (Operator op : operators.getOperators()) {
                if (op.isApplicable(state.getState())) {
                    GameState nextState = op.applyMove(state);
                    double result = minSearch(nextState, sp, ++depth, limit);
                    if (max < result) {
                        max = result;
                    }
                }
            }
        }
        return max;
    }
}