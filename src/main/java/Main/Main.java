package Main;

import Game2048.GameState;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        GameState gameState=new GameState();
        gameState.showState();
        System.out.println();
        Scanner scan = new Scanner(System.in);
        String be;

        while (true){
            be=scan.nextLine();
            gameState.moveCells(be);
            gameState.showState();
            System.out.println();
            }
        }
    }
