
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author eadil1765
 */
public class GeometryDash extends JComponent implements KeyListener, MouseMotionListener, MouseListener {

// Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
// sets the framerate and delay for our game
// you just need to select an approproate framerate
    long desiredFPS = 65;
    long desiredTime = (1000) / desiredFPS;
//player 
    Rectangle player = new Rectangle(300, 500, 50, 50);
//moving player, gravity on player
    int moveX = 0;
    int moveY = 0;
    int gravity = 2;
    boolean inAir = false;
//keyboard variables
    boolean up = false;
    boolean down = false;
    boolean right = false;
    boolean left = false;
    boolean jump = false;
//screen changer 
    int screen = 3;
//camera   
    int camx = 0;
//block
    ArrayList<Rectangle> blocks = new ArrayList<>();
//add imageio
    BufferedImage GeometryDash = loadImage("Geometry Dash.png");
//add death screen 
    BufferedImage Yousuck = loadImage("Yousuck.jpg");
//level complete image
    BufferedImage LevelComplete = loadImage("LevelComplete.jpg");
//intro screen
    BufferedImage IntroScreen = loadImage("IntroScreen.jpg");
//space to jump image
    BufferedImage Space = loadImage("Space.png");
//backround screen
    BufferedImage Backround = loadImage("Backround.jpg");

    public BufferedImage loadImage(String filename) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filename));
        } catch (Exception e) {
            System.out.println("Error loading" + filename);
        }
        return img;
    }
    //level one complete
    Rectangle LevelComplete1 = new Rectangle(1950, 0, 1000, 300);
    //Space to jump
    Rectangle Space1 = new Rectangle(100, 50, 400, 400);
    //backround
    Rectangle Backround1 = new Rectangle(0, 0, 10000, 1000);

// drawing of the game happens in here
// we use the Graphics object, g, to perform the drawing
// NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
// always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

// GAME DRAWING GOES HERE
        if (screen == 0) {
//backround
            g.drawImage(Backround, Backround1.x - camx, Backround1.y, Backround1.width, Backround1.height, null);
//add level complete
            g.drawImage(LevelComplete, LevelComplete1.x - camx, LevelComplete1.y, LevelComplete1.width, LevelComplete1.height, null);
//space to jump
            g.drawImage(Space, Space1.x - camx, Space1.y, Space1.width, Space1.height, null);


//add color
            g.setColor(Color.CYAN);
            g.drawImage(GeometryDash, player.x - camx++, player.y, player.width, player.height, null);


//blocks
            g.setColor(Color.MAGENTA);
            for (Rectangle block : blocks) {
                g.fillRect(block.x - camx, block.y, block.width, block.height);

                g.setColor(Color.MAGENTA);
            }

        } else {
            //add screens 
            if (screen == 3) {
                Rectangle player = new Rectangle(0, 0, 800, 700);
                g.setColor(Color.BLACK);
                g.drawImage(IntroScreen, player.x, player.y, player.width, player.height, null);
                //stop the screen from moving while on intro screen
                camx = 0;
            }
        }
//death screen
        if (screen == 1) {
            Rectangle player = new Rectangle(0, 0, 800, 700);
            g.setColor(Color.BLACK);
            g.drawImage(Yousuck, player.x, player.y, player.width, player.height, null);
        }

    }

    // GAME DRAWING ENDS HERE
// The main game loop
// In here is where all the logic for my game will go
    public void run() {

//add the blocks
        //base
        blocks.add(new Rectangle(0, 550, 450, 50));
        blocks.add(new Rectangle(1950, 550, 1000, 50));
        blocks.add(new Rectangle(350, 545, 5, 5));


        //blocks level 1
        blocks.add(new Rectangle(400, 500, 50, 50));
        blocks.add(new Rectangle(500, 500, 50, 50));
        blocks.add(new Rectangle(500, 450, 50, 50));
        blocks.add(new Rectangle(600, 500, 50, 50));
        blocks.add(new Rectangle(600, 450, 50, 50));
        blocks.add(new Rectangle(600, 400, 50, 50));
        blocks.add(new Rectangle(800, 500, 50, 50));
        blocks.add(new Rectangle(850, 500, 50, 50));
        blocks.add(new Rectangle(850, 450, 50, 50));
        blocks.add(new Rectangle(950, 500, 50, 50));
        blocks.add(new Rectangle(1050, 450, 50, 50));
        blocks.add(new Rectangle(1150, 400, 50, 50));
        blocks.add(new Rectangle(1250, 350, 50, 50));
        blocks.add(new Rectangle(1650, 500, 50, 50));
        blocks.add(new Rectangle(1750, 450, 50, 50));
        blocks.add(new Rectangle(1850, 500, 50, 50));
        blocks.add(new Rectangle(1950, 500, 50, 50));
        blocks.add(new Rectangle(500, 550, 50, 50));
        blocks.add(new Rectangle(600, 550, 50, 50));
        blocks.add(new Rectangle(700, 550, 50, 50));
        blocks.add(new Rectangle(1350, 550, 250, 50));


        //blocks level 2
        blocks.add(new Rectangle(3000, 550, 50, 50));
        blocks.add(new Rectangle(3100, 550, 50, 50));
        blocks.add(new Rectangle(3200, 550, 50, 50));
        blocks.add(new Rectangle(3300, 550, 50, 50));
        blocks.add(new Rectangle(3400, 550, 50, 50));
        blocks.add(new Rectangle(3500, 550, 50, 50));
        blocks.add(new Rectangle(3600, 500, 50, 50));
        blocks.add(new Rectangle(3700, 550, 50, 50));
        blocks.add(new Rectangle(3800, 510, 50, 50));
        blocks.add(new Rectangle(3900, 550, 50, 50));
        blocks.add(new Rectangle(4000, 500, 50, 50));
        blocks.add(new Rectangle(4100, 450, 50, 50));
        blocks.add(new Rectangle(4200, 400, 50, 50));
        blocks.add(new Rectangle(4300, 450, 50, 50));
        blocks.add(new Rectangle(4400, 400, 250, 50));
        blocks.add(new Rectangle(4700, 500, 1000, 50));
        blocks.add(new Rectangle(4800, 400, 50, 1000));




// Used to keep track of time used to draw and update the game
// This is used to limit the framerate later on
        long startTime;
        long deltaTime;

// the main game loop section
// game will end if you set done = false;

        boolean done = false;
        while (!done) {
// determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

// all your game rules and move is done in here
// GAME LOGIC STARTS HERE 


            //camera movement
            camx++;

//make the dude jump
            if (jump && !inAir) {
//make a big change in the y direction
                moveY = -20;
                inAir = true;
            }
//move the player
            player.x = player.x + moveX;
            player.y = player.y + moveY;
            if (left) {
                moveX = -2;
            } else if (right) {
                moveX = 2;
            } else {
                moveX = 0;
            }
//If feet of player becomes lower then the screen
            if (player.y + player.height > HEIGHT) {
//death screen
                if (player.y > 500) {
                    screen = 1;
                }
//stops falling
                player.y = HEIGHT - player.height;
                moveY = 0;
                inAir = false;
            }
//if dude goes out of the screen
            if (player.x < camx) {
                screen = 1;
            }

//speed up
            if (player.x > 1950) {
                desiredFPS = 120;
            }

//add gravity to the player
            moveY = moveY + gravity;

            // go through all blocks
            for (Rectangle block : blocks) {
                //is the player hitting a block
                if (player.intersects(block)) {
                    //get the collision rectangle
                    Rectangle intersection = player.intersection(block);
                    //fix the x movement
                    if (intersection.width < intersection.height) {
                        //player on the left
                        if (player.x < block.x) {
                            player.x = player.x - intersection.width;
                        } else {
                            player.x = player.x - intersection.height;
                        }
                    } else { // fix the Y
                        //hit the block with my head
                        if (player.y > block.y) {
                            player.y = player.y + intersection.height;
                            moveY = 0;
                        } else {
                            player.y = player.y - intersection.height;
                            moveY = 0;
                            inAir = false;
                        }
                    }
                }
            }

//perma move right
            right = true;

// GAME LOGIC ENDS HERE 

// update the drawing (calls paintComponent)
            repaint();

// SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
// USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if (deltaTime > desiredTime) {
//took too much time, don't wait
            } else {
                try {
                    Thread.sleep(desiredTime - deltaTime);
                } catch (Exception e) {
                };
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// creates a windows to show my game
        JFrame frame = new JFrame("My Game");

// creates an instance of my game
        GeometryDash game = new GeometryDash();
// sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
// adds the game to the window
        frame.add(game);

// sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
// shows the window to the user
        frame.setVisible(true);

//add the listeners
        frame.addKeyListener(game);
//Keyboard 
        game.addMouseListener(game);
        game.addMouseMotionListener(game);

// starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            jump = true;
        }
//press enter to chnge screens
        int Enter = e.getKeyCode();
        if (Enter == KeyEvent.VK_ENTER) {
            screen = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            jump = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}