package basic.knowledge.stephen.algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Leetcode353SnakeGame {
    public static void main(String[] args) {
        int[][] food = new int[][]{{1, 2},{0,1}};
        Leetcode353SnakeGame snakeGame = new Leetcode353SnakeGame(3, 2, food);

        String[] dirs = new String[]{ "R","D","R","U","L","U"};

        int index = 1;
        for(String str : dirs){
            index++;
            int res = snakeGame.move(str);
            System.out.println(res);
        }


        HashSet<Position> objects = new HashSet<>();
        boolean add = objects.add(new Position(0, 0));
        boolean add2 =objects.add(new Position(0,0));

        System.out.println(new Position(0,0).equals(new Position(0,0)));

    }

    int width;
    int height;
    int[][] food;
    int headX;
    int headY;

    HashSet<Position> set;
    int score;
    int index;

    LinkedList<Position> snakeBody;


    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public Leetcode353SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.headX = 0;
        this.headY = 0;
        this.index = 0;
        this.set = new HashSet<>();
        this.set.add(new Position(0, 0));

        this.snakeBody = new LinkedList<>();
        this.snakeBody.add(new Position(0, 0));
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {

        switch (direction) {
            case "L":
                headX--;

                if (gameOver()) {
                    return -1;
                }

                break;
            case "R":
                headX++;
                if (gameOver()) {
                    return -1;
                }
                break;
            case "U":
                headY--;
                if (gameOver()) {
                    return -1;
                }
                break;
            case "D":
                headY++;
                if (gameOver( )) {
                    return -1;
                }
                break;
        }

        return this.snakeBody.size() - 1;


    }

    private boolean gameOver() {
        if (this.headX < 0 || this.headX > this.width - 1
                || this.headY < 0 || this.headY > this.height - 1) {
            return true;
        }

        Position pos = new Position(this.headX, this.headY);
        Position tailPos = this.snakeBody.pollLast();
        this.set.remove(tailPos);
        if (!this.set.contains(pos)) {
            this.snakeBody.addFirst(pos);
            this.set.add(pos);
            if (this.food[this.index][1] == this.headX && this.food[this.index][0] == this.headY) {
                this.snakeBody.addLast(tailPos);
                this.index++;
            }
            return false;
        } else {
            return true;
        }


    }


    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public boolean equals(Object o) {

            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }
}
