package application;

import javafx.animation.FillTransition;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AppController implements Runnable{
    public AppController() {
        t = new Thread(this, "Controller");
    }
    @FXML
    private Rectangle C2, D2, E2, F2, G2, A2, B2
                            , C3, D3, E3, F3, G3, A3, B3
                            , CS2, DS2, FS2, GS2, AS2
                            , CS3, DS3, FS3, GS3, AS3;

    private Rectangle rectangles[] = {C2, D2, E2, F2, G2, A2, B2
                            , C3, D3, E3, F3, G3, A3, B3
                            , CS2, DS2, FS2, GS2, AS2
                            , CS3, DS3, FS3, GS3, AS3};

    private String[] objectReference = {"#C2", "#D2", "#E2", "#F2", "#G2", "#A2", "#B2"
                                    ,"#CS2", "#DS2", "#FS2", "#GS2", "#AS2"
                                    , "#C3", "#D3", "#E3", "#F3", "#G3", "#A3", "#B3"
                                    , "#CS3", "#DS3", "#FS3", "#GS3", "#AS3"
                                };
    
    private Parent root;
    public void initiate(Parent p) {
        root = p;
        assignObject();
    }
    
    private void assignObject() {
        for(int i = 0; i<rectangles.length; i++) {
            rectangles[i] = (Rectangle) root.lookup(objectReference[i]);
        }
    }
    private FillTransition ft = new FillTransition();
    private void animation(int location) {
        
        ft.setShape(rectangles[location]);
        ft.setDuration(Duration.millis(150.0));
        ft.setCycleCount(2);
        ft.setToValue(Color.rgb(0, 0, 0));
        ft.setAutoReverse(true);
        ft.play();
    }

    MusicAccess control = new MusicAccess();
    private void onKeyPress(KeyEvent key) {
        switch(key.getCode()) {
            case A -> {
                animation(0);
                control.C2();
            }
            case S -> {
                animation(1);
                control.D2();
            }
            case D -> {
                animation(2);
                control.E2();
            }
            case F -> {
                animation(3);
                control.F2();
            }
            case G -> {
                animation(4);
                control.G2();
            }
            case H -> {
                animation(5);
                control.A2();
            }
            case J -> {
                animation(6);
                control.B2();
            }

            case Q-> {
                animation(7);
                control.CS2();
            }
            case W-> {
                animation(8);
                control.DS2();
            }
            case E-> {
                animation(9);
                control.FS2();
            }
            case R-> {
                animation(10);
                control.GS2();
            }
            case T-> {
                animation(11);
                control.AS2();
            }

            case  K-> {
                animation(12);
                control.C3();
            }
            case L -> {
                animation(13);
                control.D3();
            }
            case SEMICOLON -> {
                animation(14);
                control.E3();
            }
            case QUOTE -> {
                animation(15);
                control.F3();
            }
            case OPEN_BRACKET -> {
                animation(16);
                control.G3();
            }
            case CLOSE_BRACKET -> {
                animation(17);
                control.A3();
            }
            case BACK_SLASH -> {
                animation(18);
                control.B3();
            }

            case Y-> {
                animation(19);
                control.CS3();
            }
            case U-> {
                animation(20);
                control.DS3();
            }
            case I-> {
                animation(21);
                control.FS3();
            }
            case O-> {
                animation(22);
                control.GS3();
            }
            case P-> {
                animation(23);
                control.AS3();
            }
            default-> {break;}
        }
    }
    public Thread t;
    public KeyEvent key;
    @Override
    public void run() {
        onKeyPress(key);
        t = new Thread(this);
    }
}
