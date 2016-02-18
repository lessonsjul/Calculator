package gui;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import listeners.ButtonAction;
import listeners.ChangeSkinListener;
import listeners.KeyTextFieldsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator extends JFrame{

    private static final int WIDTH = 293;
    private static final int HEIGHT = 300;
    public static final int MAX_TEXT_FIELD_COLUMS = 16;

    public static final String INPUT_CHISLO = "Введите число";
    private Image iconImage = new ImageIcon(getClass().getResource("../images/icon.png")).getImage();
    private Icon backSpaceIcon = new ImageIcon(getClass().getResource("../images/backspace.png"));
    private java.util.List<MyJButton> buttonsList = new ArrayList<>();

    public Calculator() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents(){

        //настройки для Frame - главного окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setIconImage(iconImage);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);

        //создание Panels
        //панель ввода и вывода
        //панель кнопок
        createMenu();
        createPanels();
        createTextFields();

        //создаем пукты меню
        createMenuItems();

        //создем кнопки
        createButtons();

        popService.add(skin1);
        popService.add(skin2);
        popService.add(skin3);

        for(JButton btn: buttonsList)
            ButtonsPanel.add(btn);

        IOPanel.add(textField);

        getContentPane().add(MenuPanel,BorderLayout.NORTH);
        getContentPane().add(IOPanel, BorderLayout.CENTER);
        getContentPane().add(ButtonsPanel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
        }catch(UnsupportedLookAndFeelException ex){
            ex.printStackTrace();
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    private void createMenu(){
        MenuPanel = new JMenuBar();
        popService = new JMenu("Service");

        MenuPanel.add(popService);
    }

    private void createMenuItems(){
        skin1 = new JMenuItem("Default");
        skin2 = new JMenuItem("HiFi Theme");
        skin3 = new JMenuItem("Mint Theme");

        addChangeSkinListener();
    }

    private void createPanels(){
        IOPanel = new MyJPanel("IOPanel", WIDTH, (int)(HEIGHT * 0.2), new FlowLayout(FlowLayout.LEFT));
        ButtonsPanel = new MyJPanel("ButtonsPanel", WIDTH, (int)(HEIGHT * 0.6),new GridLayout(5,4));
    }

    private void createButtons(){

        buttonsList.addAll(Arrays.asList(
                btnClear = new MyJButton("CE",Color.RED),
                btnRemove = new MyJButton(backSpaceIcon, "BACK SPACE"),
                btnProcent = new MyJButton("%"),
                btnUnary = new MyJButton("+/-"),
                btnNine = new MyJButton("9"),
                btnEight = new MyJButton("8"),
                btnSeven = new MyJButton("7"),
                btnDivid = new MyJButton("/"),
                btnSix = new MyJButton("6"),
                btnFive = new MyJButton("5"),
                btnFour = new MyJButton("4"),
                btnMulty = new MyJButton("*"),
                btnThree = new MyJButton("3"),
                btnTwo = new MyJButton("2"),
                btnOne = new MyJButton("1"),
                btnMinus = new MyJButton("-"),
                btnZero = new MyJButton("0"),
                btnPoint = new MyJButton("."),
                btnResult = new MyJButton("="),
                btnAdd = new MyJButton("+")
                ));

        addButtonsListeners();
    }

    private void createTextFields(){
        textField = new MyJTextField(MAX_TEXT_FIELD_COLUMS);
        textField.setText("0");

        addTextFieldsListeners();
    }

    private void addButtonsListeners(){
        btnActionListener = new ButtonAction(textField);

       for(MyJButton btn: buttonsList)
           btn.addActionListener(btnActionListener);
    }

    private void addTextFieldsListeners(){
        textField.addKeyListener(new KeyTextFieldsListener());
    }

    private void addChangeSkinListener(){
        skin1.addActionListener(new ChangeSkinListener(this, new AluminiumLookAndFeel()));
        skin2.addActionListener(new ChangeSkinListener(this, new HiFiLookAndFeel()));
        skin3.addActionListener(new ChangeSkinListener(this, new MintLookAndFeel()));
    }

    //объявление всех компонентов калькулятора
    private JMenuBar MenuPanel;
    private MyJPanel IOPanel;
    private MyJPanel ButtonsPanel;
    private MyJButton btnRemove;
    private MyJButton btnClear;
    private MyJButton btnAdd;
    private MyJButton btnMinus;
    private MyJButton btnMulty;
    private MyJButton btnDivid;
    private MyJButton btnProcent;
    private MyJButton btnUnary;
    private MyJButton btnResult;
    private MyJButton btnZero;
    private MyJButton btnPoint;
    private MyJButton btnOne;
    private MyJButton btnTwo;
    private MyJButton btnThree;
    private MyJButton btnFour;
    private MyJButton btnFive;
    private MyJButton btnSix;
    private MyJButton btnSeven;
    private MyJButton btnEight;
    private MyJButton btnNine;
    private MyJTextField textField;
    private JMenu popService;
    private JMenuItem skin1;
    private JMenuItem skin2;
    private JMenuItem skin3;
    private ActionListener btnActionListener;
}