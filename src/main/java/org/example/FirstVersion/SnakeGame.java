package org.example.FirstVersion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    MyKeyAdapter myKeyAdapter=new MyKeyAdapter('R');
    private static final int width=1366;
    private static final int height=768;
    private static final int unitSize=20;
    private static final int gameUnit=(width*height)/unitSize;
    private ArrayList<Point> snakeBody;
    private Point food;

    private boolean running=false;
    private Timer timer;

    public SnakeGame(){
        snakeBody=new ArrayList<>();
        snakeBody.add(new Point(0,0));
        food= createFood();
        setPreferredSize(new Dimension(width,height));
        setBackground(Color.white);
        setFocusable(true);
        addKeyListener(myKeyAdapter);
        startGame();
    }
    private void startGame(){
        running=true;
        timer=new Timer(100,this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        if (running) {
            for (Point point : snakeBody) {
                g.setColor(Color.green);
                g.fillRect(point.x, point.y, unitSize, unitSize);
            }
            g.setColor(Color.RED);
            g.fillRect(food.x, food.y, unitSize, unitSize);
            g.setColor(Color.BLACK);
            g.setFont (new Font("Lato", Font.ITALIC,40));
            FontMetrics metrics= getFontMetrics(g.getFont());
            g.drawString("Wynik: " + (snakeBody.size() - 1), (width - metrics.stringWidth("Wynik: " + (snakeBody.size() - 1))) / 2, g.getFont().getSize());
            g.drawString("Pozycja węża: (" + snakeBody.get(0).x + ", " + snakeBody.get(0).y + ")", (width - metrics.stringWidth("Pozycja węża: (" + snakeBody.get(0).x + ", " + snakeBody.get(0).y + ")")) / 2, g.getFont().getSize() * 2);
        } else {

        }
    }
        public Point createFood() {
            Random rand= new Random();
            int x=rand.nextInt((int)(width/unitSize)*unitSize);
            int y=rand.nextInt((int)(height/unitSize)*unitSize);
            return new Point(x,y);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(running) {
                move();
                checkFoodCollision();
                checkCollision();
                repaint();
            }
        }
        public void move() {
            Point head=snakeBody.get(0);
            Point newHead= (Point)head.clone();

            char newDirection= myKeyAdapter.getDirection();
            switch(newDirection){
                case 'U':
                    newHead.y-=unitSize;
                    break;
                case 'D':
                    newHead.y += unitSize;
                    break;
                case 'R':
                    newHead.x -= unitSize;
                    break;
                case 'L':
                    newHead.x += unitSize;
                    break;
            }
            snakeBody.add(0,newHead);
            snakeBody.remove(snakeBody.size()-1);
        }
        public void checkFoodCollision() {
            if(snakeBody.get(0).equals(food)) {
                snakeBody.add(food);
                food=createFood();
            }
        }
        public void checkCollision() {
            if (snakeBody.get(0).x < 0 || snakeBody.get(0).x >= width ||
                    snakeBody.get(0).y < 0 || snakeBody.get(0).y >= height) {
                running = false;
                return;
            }

            for (int i = 1; i < snakeBody.size(); i++) {
                if (snakeBody.get(0).equals(snakeBody.get(i))) {
                    running = false;
                    return;
                }
            }
        }

    }


