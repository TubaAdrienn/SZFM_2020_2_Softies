package Game2048;

public class GameState {

    private char[][] gameState;

    public GameState() {
        this.gameState = new char[4][4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                gameState[i][j] = '0';
            }
        }
    }

    public GameState(char[][] gameState, int current){
        this.gameState = gameState;
    }

    public char[][] getState() {
        return this.gameState;
    }

    public boolean isEmpty(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                if(gameState[i][j]=='0'){
                    return true;
                }
            }
        }
        return false;
    }

    public void winner(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameState[i][j] == 2048) {
                    System.out.println("You won");
                }
            }
        }
    }

    public void isOver(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (isEmpty()){
                    System.out.println("Game Over");
                }
            }
        }
    }

    public void showState() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf(String.valueOf(gameState[i][j]));
                if (j == 3) {
                    System.out.println();
                }
            }
        }
    }
}
