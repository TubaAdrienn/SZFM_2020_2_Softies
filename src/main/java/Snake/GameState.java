package Snake;


import java.util.Random;
import java.util.Scanner;

public class GameState {
    private int[][] gameState;
    private int snakeLength;
    private String direction;
    private int[] head;
    private int[] tail;
    private int[] foodPlace;
    private Scanner scanner = new Scanner(System.in);
    private int score;
    private int highScore;

    public GameState(){
        this.score = 0;
        this.snakeLength=3;
        this.direction="right";
        this.gameState = new int[10][10];
        this.head = new int[2];
        this.tail = new int[2];
        this.foodPlace = new int[2];
        Random rand = new Random();
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                gameState[i][j] = 0;
            }
        }
        int randomI = rand.nextInt(6);
        int randomJ = rand.nextInt(6);
        gameState[randomI][randomJ]= 3;
        saveHead(randomI, randomJ);
        gameState[++randomI][randomJ]=2;
        gameState[++randomI][randomJ]=1;
        this.generateFood();
    }


    /*
     * Ez a metódus menti el a fejnek a koordinátáit.
     * */
    public void saveHead(int headI, int headJ){
        this.head[0]=headI;
        this.head[1]=headJ;
    }

    /*
     * ez a metódus kiiratja a játékteret
     * */
    public void showState(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.print("[ " + gameState[i][j] + " ]");
                if (j == 9){
                    System.out.println();
                }
            }
        }
    }

    /*
     * ez a metódus majd visszaadja a játékállapotot
     * */
    public int[][] getGameState(){
        return this.gameState;
    }

    public void generateFood(){
        boolean success=false;
        Random rand = new Random();
        int foodCellI=-1;
        int foodCellJ = -1;
        while(success==false){
            foodCellI=rand.nextInt(9);
            foodCellJ=rand.nextInt(9);
            if(gameState[foodCellI][foodCellJ]==0){
                gameState[foodCellI][foodCellJ]=-1;
                success=true;
            }
            //mentsd le az almát
            this.foodPlace[0]=foodCellI;
            this.foodPlace[1]=foodCellJ;
        }
    }

    public boolean isOver(){
        /*
         * if(){
         *
         * this.highScore=this.score;
         *return true;
         * }
         * else {*/
        return false;

        //ha kimegy a rácsokból, akkor dobjon vissza az isOver egy truet
    }

    public void moveSnake(){
        while(isOver()==false){
            this.showState();
            this.direction = this.scanner.nextLine();
            switch(this.direction){
                case "w":
                    this.direction = "up";
                    makeStep();
                    break;
                case "a":
                    this.direction = "left";
                    makeStep();
                    break;
                case "s":
                    this.direction = "down";
                    makeStep();
                    break;
                case "d":
                    this.direction = "right";
                    makeStep();
                    break;
            }

            System.out.println();
            //bekér egy a, s, d, w
            //lemented a direction változóba
            //változtatod switch-chel az irányt
        }
    }

    public void makeStep(){
        //amikor eszik egy almát, akkor az alma helye lesz a feje

        if(this.foodPlace[0]==this.head[0] && this.foodPlace[1]==this.head[1]){
            ++this.snakeLength;
            saveHead(this.foodPlace[0],this.foodPlace[1]);
            putHead();
            this.score+=5; //after eating the food increase score by 5
            generateFood(); //after eating the food generate a new one

        } else {
            decreseCells();
            putHead();
        }

        // System.out.println("row " + foodPlace[0] + " col " + foodPlace[1]);
        // System.out.println("row " + head[0] + " col " + head[1]);
        // System.out.println(this.score);

    }

    /*
     * ahol nem nulla a cella értéke azt csökkenti eggyel
     * */
    public void decreseCells(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if(gameState[i][j]!=0){
                    gameState[i][j]--;
                }
            }
        }
    }

    public void putHead(){
        switch (this.direction){
            case "up":
                gameState[--head[0]][head[1]] = this.snakeLength;
                break;
            case "down":
                gameState[++head[0]][head[1]] = this.snakeLength;
                break;
            case "left":
                gameState[head[0]][--head[1]] = this.snakeLength;
                break;
            case "right":
                gameState[head[0]][++head[1]] = this.snakeLength;
                break;
        }
    }
}
