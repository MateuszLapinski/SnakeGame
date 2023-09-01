package org.example.SecondVersion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

public class GamePanel extends JPanel implements ActionListener {
    CheckGameState checkGameState= CheckGameState.getInstance();
    private static final int width = 600;
    private static final int height = 600;
    private static final int unitSize = 20;
    private static final int gameUnit = (width * height) / unitSize;
    public final int delay = 90;
    private ArrayList<Point> snakeBody;
    private static int eatenApples;
    private int bodyLenght=3;
    private int AppleX;
    private int AppleY;
    char direction = 'R';

    static boolean running = false;
    static boolean isGameOver = false;
    public static boolean isGameOver() {
        return isGameOver;
    }
    Color darkGreen = new Color(0, 100, 0);
    Color lightGreen = new Color(144, 238, 144);
    Timer timer;
    Random random;
    GameOverPanel gameOverPanel;
    private Image appleImage= Toolkit.getDefaultToolkit().getImage("G:\\My Drive\\IdeaProjects\\Snake\\src\\main\\resources\\apple.png");
    Score score=new Score();
    int theBestScore= score.getHighestScore();
    public GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.lightGray);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        createSnake();
        startGame();
    }

    public static int getEatenApples() {
        return eatenApples;
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }


    public void createSnake() {
        snakeBody = new ArrayList<>();
        for(int i=0; i<=bodyLenght; i++) {
            snakeBody.add(new Point(0-i,0));
        }
    }
    private void resetGame() {
        snakeBody.clear();
        createSnake();
        eatenApples = 0;
        bodyLenght = 3;
        direction = 'R';
        running = true;
        newApple();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            for (int i = 0; i <= height / unitSize; i++) {
                g.drawLine(i * unitSize, 0, i * unitSize, height);
                g.drawLine(0, i * unitSize, width, i * unitSize);
            }
            g.setColor(Color.red);
            g.drawImage(appleImage,AppleX,AppleY,unitSize,unitSize,null);
            for (int i = 0; i < snakeBody.size(); i++) {
                Point point = snakeBody.get(i);
                if (i == 0) {
                    if (eatenApples > theBestScore) {
                        g.setColor(Color.getHSBColor(210, 105, 30));
                    } else {
                        g.setColor(darkGreen);
                    }
                    g.fillRect(point.x, point.y, unitSize, unitSize);
                } else {
                    if (eatenApples > theBestScore) {
                        g.setColor(Color.orange);
                    } else {
                        g.setColor(lightGreen);
                    }
                    g.fillRect(point.x, point.y, unitSize, unitSize);
                }
            }
            g.setColor(Color.black);
            g.setFont(new Font("Lato", Font.ITALIC, 20));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + eatenApples, (width - metrics.stringWidth("Score: " + eatenApples)), g.getFont().getSize());
        } else {

        }
    }

    public Point newApple() {
        boolean isValid = false;
        while (!isValid) {
            AppleX = random.nextInt((width / unitSize)) * unitSize;
            AppleY = random.nextInt((height / unitSize)) * unitSize;
            isValid = true;
            for (Point point : snakeBody) {
                if (AppleX == point.x || AppleY == point.y) {
                    isValid = false;
                    break;
                }
            }

        }
        System.out.println(AppleX + " " + AppleY);
        return new Point(AppleX, AppleY);
    }




    public void move() {
        char newDirection = direction;
            Point head = snakeBody.get(0);
            Point newHead = (Point) head.clone();

            switch (newDirection) {
                case 'U':
                    newHead.y -= unitSize;
                    break;
                case 'D':
                    newHead.y += unitSize;
                    break;
                case 'R':
                    newHead.x += unitSize;
                    break;
                case 'L':
                    newHead.x -= unitSize;
                    break;
            }

            snakeBody.add(0, newHead);
            snakeBody.remove(snakeBody.size() - 1);
        }
    public void checkApple() {
        Point head = snakeBody.get(0);
        Point apple = new Point(AppleX, AppleY);
        if (head.equals(apple)) {
            snakeBody.add(new Point(snakeBody.get(snakeBody.size()-1)));
            eatenApples++;
            bodyLenght++;
            newApple();
            System.out.println(bodyLenght);
            System.out.println(eatenApples);
        }
    }

    public void checkCollision() {
        if (snakeBody.get(0).x < 0 || snakeBody.get(0).x >= width ||
                snakeBody.get(0).y < 0 || snakeBody.get(0).y >= height) {
            running = false;
            checkGameState.setPlay(false);
        }
    }

    public void checkCollisionWithBody(){
        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeBody.get(0).x == snakeBody.get(i).x && snakeBody.get(0).y == snakeBody.get(i).y) {
                running = false;
                checkGameState.setPlay(false);
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running==true){
            move();
            checkApple();
            checkCollision();
            checkCollisionWithBody();
        }else {
        }
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            char newDirection=direction;

            if (keyCode == KeyEvent.VK_LEFT && direction != 'R') {
                newDirection = 'L';
            } else if (keyCode == KeyEvent.VK_RIGHT && direction != 'L') {
                newDirection = 'R';
            } else if (keyCode == KeyEvent.VK_UP && direction != 'D') {
                newDirection = 'U';
            } else if (keyCode == KeyEvent.VK_DOWN && direction != 'U') {
                newDirection = 'D';
            }
            direction=newDirection;
        }
    }
}
