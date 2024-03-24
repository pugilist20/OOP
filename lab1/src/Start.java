

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Start {
    private JFrame title = new JFrame("Лабораторная работа №1");
    private JButton butBack = new JButton("Назад");
    private JButton butLine = new JButton("Линия");
    private JButton butCircle = new JButton("Окружность");
    private JButton butRectangle = new JButton("Прямоугольник");
    private JButton butTriangle = new JButton("Треугольник");
    private JButton butCreate = new JButton("Создать");
    private JButton butMove = new JButton("Переместить");
    private JButton butDelete = new JButton("Удалить");
    private JButton butRotate = new JButton("Повернуть на 45");
    private JButton butChageRad = new JButton("Изменить радиус");
    private JButton butChangeSize = new JButton("Изменить размер");
    private JButton butVisible = new JButton("Сделать видимым/невидимым");
    private JButton butNext = new JButton("Следующая фигура");
    private JButton butPrevious = new JButton("Предыдущая фигура");
    ArrayList<Line> listLine = new ArrayList<Line>();
    int selectedLine = -1;
    ArrayList<Circle> listCircle = new ArrayList<>();
    int selectedCircle = -1;
    ArrayList<Rectangle> listRectangle = new ArrayList<>();
    int selectedRectangle = -1;
    ArrayList<Triangle> listTriangle = new ArrayList<>();
    int selectedTriangle = -1;

    private int numBut;
    private JPanel cP = centerPanel();
    private JPanel sP = southPanel();
    private JPanel line = null;
    private JPanel circle = null;
    private JPanel rectangle = null;
    private JPanel triangle = null;
    private int coords1;
    private int coords2;
    private int coords3;
    private int coords4;
    private int coords5;
    private int coords6;
    private boolean visionLine = false;
    private boolean visionCircle = false;
    private boolean visionRectangle = false;
    private boolean visionTriangle = false;

    private Start() {
        title.setLayout(new BorderLayout());
        title.setSize(1280, 680);
        title.add(cP, "Center");
        title.add(sP, "South");
        title.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        title.setVisible(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - title.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - title.getHeight()) / 2);
        title.setLocation(x, y);
        title.setResizable(false);
    }

    private JPanel centerPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBackground(Color.white);
        return p;
    }

    private JPanel southPanel() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.setBackground(Color.white);
        p.add(butLine).setBackground(Color.LIGHT_GRAY);
        p.add(butCircle).setBackground(Color.LIGHT_GRAY);
        p.add(butRectangle).setBackground(Color.LIGHT_GRAY);
        p.add(butTriangle).setBackground(Color.LIGHT_GRAY);
        butLine.addActionListener((e) -> {
            sP.removeAll();
            sP.add(butBack).setBackground(Color.LIGHT_GRAY);
            sP.add(butCreate).setBackground(Color.LIGHT_GRAY);
            sP.add(butMove).setBackground(Color.LIGHT_GRAY);
            sP.add(butDelete).setBackground(Color.LIGHT_GRAY);
            sP.add(butRotate).setBackground(Color.LIGHT_GRAY);
            sP.add(butVisible).setBackground(Color.LIGHT_GRAY);
            sP.add(butPrevious).setBackground(Color.LIGHT_GRAY);
            sP.add(butNext).setBackground(Color.LIGHT_GRAY);
            sP.revalidate();
            sP.repaint();
            if(!listLine.isEmpty()){
                listLine.get(selectedLine-1).setColor(Color.RED);
            }
            cP.revalidate();
            cP.repaint();
            numBut = 1;
        });
        butCircle.addActionListener((e) -> {
            sP.removeAll();
            sP.add(butBack).setBackground(Color.LIGHT_GRAY);
            sP.add(butCreate).setBackground(Color.LIGHT_GRAY);
            sP.add(butMove).setBackground(Color.LIGHT_GRAY);
            sP.add(butDelete).setBackground(Color.LIGHT_GRAY);
            sP.add(butChageRad).setBackground(Color.LIGHT_GRAY);
            sP.add(butVisible).setBackground(Color.LIGHT_GRAY);
            sP.add(butPrevious).setBackground(Color.LIGHT_GRAY);
            sP.add(butNext).setBackground(Color.LIGHT_GRAY);
            sP.revalidate();
            sP.repaint();
            if(!listCircle.isEmpty()){
                listCircle.get(selectedCircle-1).setColor(Color.RED);
            }
            cP.revalidate();
            cP.repaint();
            numBut = 2;
        });
        butRectangle.addActionListener((e) -> {
            sP.removeAll();
            sP.add(butBack).setBackground(Color.LIGHT_GRAY);
            sP.add(butCreate).setBackground(Color.LIGHT_GRAY);
            sP.add(butMove).setBackground(Color.LIGHT_GRAY);
            sP.add(butDelete).setBackground(Color.LIGHT_GRAY);
            sP.add(butChangeSize).setBackground(Color.LIGHT_GRAY);
            sP.add(butVisible).setBackground(Color.LIGHT_GRAY);
            sP.add(butPrevious).setBackground(Color.LIGHT_GRAY);
            sP.add(butNext).setBackground(Color.LIGHT_GRAY);
            sP.revalidate();
            sP.repaint();
            if(!listRectangle.isEmpty()){
                listRectangle.get(selectedRectangle-1).setColor(Color.RED);
            }
            cP.revalidate();
            cP.repaint();
            numBut = 3;
        });
        butTriangle.addActionListener((e) -> {
            sP.removeAll();
            sP.add(butBack).setBackground(Color.LIGHT_GRAY);
            sP.add(butCreate).setBackground(Color.LIGHT_GRAY);
            sP.add(butMove).setBackground(Color.LIGHT_GRAY);
            sP.add(butDelete).setBackground(Color.LIGHT_GRAY);
            sP.add(butChangeSize).setBackground(Color.LIGHT_GRAY);
            sP.add(butVisible).setBackground(Color.LIGHT_GRAY);
            sP.add(butPrevious).setBackground(Color.LIGHT_GRAY);
            sP.add(butNext).setBackground(Color.LIGHT_GRAY);
            sP.revalidate();
            sP.repaint();
            if(!listTriangle.isEmpty()){
                listTriangle.get(selectedTriangle-1).setColor(Color.RED);
            }
            cP.revalidate();
            cP.repaint();
            numBut = 4;
        });
        butCreate.addActionListener((e) -> {
            switch (numBut) {
                case 1:
                    visionLine = true;
                    coords1 = (int) (Math.random() * 1260.0);
                    coords2 = (int) (Math.random() * 610.0);
                    coords3 = (int) (Math.random() * 1260.0);
                    coords4 = (int) (Math.random() * 610.0);
                    if (!listLine.isEmpty()) {
                        line = new Line(coords1, coords2, coords3, coords4, Color.RED);
                        listLine.add((Line) line);
                        if (listLine.size() >= 2) {
                            if (selectedLine == 0) {
                                listLine.get(selectedLine).setColor(Color.BLACK);
                            } else {
                                listLine.get(selectedLine - 1).setColor(Color.BLACK);
                            }
                        }
                    }
                    if (listLine.isEmpty()) {
                        line = new Line(coords1, coords2, coords3, coords4, Color.RED);
                        listLine.add((Line) line);
                    }

                    ((Line) line).Show(visionLine);
                    cP.add(line, "Center");
                    cP.revalidate();
                    selectedLine = listLine.size();
                    break;

                case 2:
                    visionCircle = true;
                    coords1 = 15 + (int) (Math.random() * 1223.0);
                    coords2 = 15 + (int) (Math.random() * 590.0);
                    if (Math.min(1260 - coords1, 615 - coords2) < Math.min(coords1, coords2)) {
                        coords3 = 10 + (int) (Math.random() * (Math.min(1245 - coords1, 605 - coords2)));
                    } else {
                        coords3 = 10 + (int) (Math.random() * (Math.min(coords1, coords2)));
                    }
                    if (!listCircle.isEmpty()) {
                        circle = new Circle(coords1, coords2, coords3, Color.RED);
                        listCircle.add((Circle) circle);
                        if (listCircle.size() >= 2) {
                            if (selectedCircle ==0) {
                                listCircle.get(selectedCircle).setColor(Color.BLACK);
                            } else {
                                listCircle.get(selectedCircle - 1).setColor(Color.BLACK);
                            }

                        }
                    }
                    if (listCircle.isEmpty()) {
                        circle = new Circle(coords1, coords2, coords3, Color.RED);
                        listCircle.add((Circle) circle);
                    }

                    ((Circle) circle).Show(visionCircle);
                    cP.add(circle, "Center");
                    cP.revalidate();
                    selectedCircle = listCircle.size();
                    break;

                case 3:
                    visionRectangle = true;
                    coords1 = (int) (Math.random() * 1240.0);
                    coords2 = (int) (Math.random() * 590.0);
                    coords3 = 3 + (int) (Math.random() * (1260.0 - coords1));
                    coords4 = 3 + (int) (Math.random() * (605.0 - coords2));
                    if (!listRectangle.isEmpty()) {
                        rectangle = new Rectangle(coords1, coords2, coords3, coords4, Color.RED);
                        listRectangle.add((Rectangle) rectangle);
                        if (listRectangle.size() >= 2) {
                            if (selectedRectangle==0) {
                                listRectangle.get(selectedRectangle).setColor(Color.BLACK);
                            } else {
                                listRectangle.get(selectedRectangle - 1).setColor(Color.BLACK);
                            }

                        }
                    }
                    if (listRectangle.isEmpty()) {
                        rectangle = new Rectangle(coords1, coords2, coords3, coords4, Color.RED);
                        listRectangle.add((Rectangle) rectangle);
                    }

                    ((Rectangle) rectangle).Show(visionRectangle);
                    cP.add(rectangle, "Center");
                    cP.revalidate();
                    selectedRectangle = listRectangle.size();
                    break;

                case 4:
                    visionTriangle = true;
                    coords1 = 15 + (int) (Math.random() * 1200.0);
                    coords2 = 15 + (int) (Math.random() * 1200.0);
                    coords3 = 15 + (int) (Math.random() * 1200.0);
                    coords4 = 15 + (int) (Math.random() * 570.0);
                    coords5 = 15 + (int) (Math.random() * 580.0);
                    coords6 = 15 + (int) (Math.random() * 590.0);
                    if (!listTriangle.isEmpty()) {
                        triangle = new Triangle(coords1, coords2, coords3, coords4, coords5, coords6, Color.RED);
                        listTriangle.add((Triangle) triangle);
                        if (listTriangle.size() >= 2) {
                            if (selectedTriangle==0) {
                                listTriangle.get(selectedTriangle).setColor(Color.BLACK);
                            } else {
                                listTriangle.get(selectedTriangle - 1).setColor(Color.BLACK);
                            }

                        }
                    }
                    if (listTriangle.isEmpty()) {
                        triangle = new Triangle(coords1, coords2, coords3, coords4, coords5, coords6, Color.RED);
                        listTriangle.add((Triangle) triangle);
                    }

                    ((Triangle) triangle).Show(visionTriangle);
                    cP.add(triangle, "Center");
                    cP.revalidate();
                    selectedTriangle = listTriangle.size();
                    break;
            }
        });
        butBack.addActionListener((e) -> {
            switch (numBut) {
                case 1:
                case 2:
                case 3:
                case 4:
                    sP.removeAll();
                    sP.add(butLine).setBackground(Color.LIGHT_GRAY);
                    sP.add(butCircle).setBackground(Color.LIGHT_GRAY);
                    sP.add(butRectangle).setBackground(Color.LIGHT_GRAY);
                    sP.add(butTriangle).setBackground(Color.LIGHT_GRAY);
                    break;

            }
            if(!listLine.isEmpty()){
                listLine.get(selectedLine-1).setColor(Color.BLACK);
            }
            if(!listCircle.isEmpty()){
                listCircle.get(selectedCircle-1).setColor(Color.BLACK);
            }
            if(!listRectangle.isEmpty()){
                listRectangle.get(selectedRectangle-1).setColor(Color.BLACK);
            }
            if(!listTriangle.isEmpty()){
                listTriangle.get(selectedTriangle-1).setColor(Color.BLACK);
            }
            cP.revalidate();
            cP.repaint();
            sP.revalidate();
            sP.repaint();
        });

        butMove.addActionListener((e) -> {
            coords1 = -50 + (int) (Math.random() * 100);
            coords2 = -50 + (int) (Math.random() * 100);
            switch (numBut) {
                case 1:
                    if (selectedLine != 0 && selectedLine != -1) {
                        listLine.get(selectedLine - 1).MoveTo(coords1, coords2);
                        cP.repaint();

                    } else {
                        JOptionPane.showMessageDialog(title, "Линия не найдена");
                    }
                    break;

                case 2:
                    if (selectedCircle != 0 && selectedCircle != -1) {
                        listCircle.get(selectedCircle - 1).MoveTo(coords1, coords2);
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Окружность не найдена");
                    }
                    coords1 = coords2 = 0;
                    break;

                case 3:
                    if (selectedRectangle != 0 && selectedRectangle != -1) {
                        listRectangle.get(selectedRectangle - 1).MoveTo(coords1, coords2);
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;

                case 4:
                    if (selectedTriangle != 0 && selectedTriangle != -1) {
                        listTriangle.get(selectedTriangle - 1).MoveTo(coords1, coords2);
                        cP.repaint();
                        cP.revalidate();
                    } else {
                        JOptionPane.showMessageDialog(title, "Треугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
            }

        });
        butDelete.addActionListener((e) -> {
            switch (numBut) {
                case 1:
                    if (listLine.size() > 1) {
                        int indexToRemove = (selectedLine == 1) ? 0 : selectedLine - 1;
                        cP.remove(listLine.get(indexToRemove));
                        listLine.remove(indexToRemove);
                        selectedLine = (selectedLine == 1) ? listLine.size() : selectedLine - 1;
                        listLine.get(selectedLine - 1).setColor(Color.RED);
                        cP.revalidate();
                        cP.repaint();
                    } else if (listLine.size() == 1) {
                        cP.remove(listLine.get(0));
                        listLine.remove(0);
                        selectedLine = -1;
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Линия не найдена");
                    }
                    break;
                case 2:
                    if (listCircle.size() > 1) {
                        int indexToRemove = (selectedCircle == 1) ? 0 : selectedCircle - 1;
                        cP.remove(listCircle.get(indexToRemove));
                        listCircle.remove(indexToRemove);
                        selectedCircle = (selectedCircle == 1) ? listCircle.size() : selectedCircle - 1;
                        listCircle.get(selectedCircle - 1).setColor(Color.RED);
                        cP.revalidate();
                        cP.repaint();
                    } else if (listCircle.size() == 1) {
                        cP.remove(listCircle.get(0));
                        listCircle.remove(0);
                        selectedCircle = -1;
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Окружность не найдена");
                    }
                    break;

                case 3:
                    if (listRectangle.size() > 1) {
                        int indexToRemove = (selectedRectangle == 1) ? 0 : selectedRectangle - 1;
                        cP.remove(listRectangle.get(indexToRemove));
                        listRectangle.remove(indexToRemove);
                        selectedRectangle = (selectedRectangle == 1) ? listRectangle.size() : selectedRectangle - 1;
                        listRectangle.get(selectedRectangle - 1).setColor(Color.RED);
                        cP.revalidate();
                        cP.repaint();
                    } else if (listRectangle.size() == 1) {
                        cP.remove(listRectangle.get(0));
                        listRectangle.remove(0);
                        selectedRectangle = -1;
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    break;

                case 4:
                    if (listTriangle.size() > 1) {
                        int indexToRemove = (selectedTriangle == 1) ? 0 : selectedTriangle - 1;
                        cP.remove(listTriangle.get(indexToRemove));
                        listTriangle.remove(indexToRemove);
                        selectedTriangle = (selectedTriangle == 1) ? listTriangle.size() : selectedTriangle - 1;
                        listTriangle.get(selectedTriangle - 1).setColor(Color.RED);
                        cP.revalidate();
                        cP.repaint();
                    } else if (listTriangle.size() == 1) {
                        cP.remove(listTriangle.get(0));
                        listTriangle.remove(0);
                        selectedTriangle = -1;
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Треугольник не найден");
                    }
                    break;

            }
        });
        butRotate.addActionListener((e) -> {
            if (numBut == 1) {
                if (selectedLine != 0 && selectedLine != -1) {
                    listLine.get(selectedLine - 1).Turn();
                    cP.revalidate();
                    cP.repaint();
                } else {
                    JOptionPane.showMessageDialog(title, "Линия не найдена");
                }
            }

        });
        butChageRad.addActionListener((e) -> {
            if (numBut == 2) {
                coords1 = 15 + (int) (Math.random() * 500.0);
                if (selectedCircle != 0 && selectedCircle != -1) {
                    listCircle.get(selectedCircle - 1).chRad(coords1);
                    coords1 = 0;
                    cP.revalidate();
                    cP.repaint();
                } else {
                    JOptionPane.showMessageDialog(title, "Окружность не найдена");
                }
            }

        });
        butChangeSize.addActionListener((e) -> {
            coords1 = 15 + (int) (Math.random() * 50.0);
            coords2 = 15 + (int) (Math.random() * 50.0);
            switch (numBut) {
                case 3:
                    if (selectedRectangle != 0 && selectedRectangle != -1) {
                        listRectangle.get(selectedRectangle - 1).chSize(coords1, coords2);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
                case 4:
                    if (selectedTriangle != 0 && selectedTriangle != -1) {
                        listTriangle.get(selectedTriangle - 1).chSize(coords1, coords2);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Треугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
            }
        });
        butVisible.addActionListener((e) -> {
            switch (numBut) {
                case 1:
                    if (selectedLine != 0 && selectedLine != -1) {
                        visionLine = !visionLine;
                        listLine.get(selectedLine - 1).Show(visionLine);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Линия не найдена");
                    }
                    break;
                case 2:
                    if (selectedCircle != 0 && selectedCircle != -1) {
                        visionCircle = !visionCircle;
                        listCircle.get(selectedCircle - 1).Show(visionCircle);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Окружность не найдена");
                    }
                    break;
                case 3:
                    if (selectedRectangle != 0 && selectedRectangle != -1) {
                        visionRectangle = !visionRectangle;
                        listRectangle.get(selectedRectangle - 1).Show(visionRectangle);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    break;
                case 4:
                    if (selectedTriangle != 0 && selectedTriangle != -1) {
                        visionTriangle = !visionTriangle;
                        listTriangle.get(selectedTriangle - 1).Show(visionTriangle);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Треугольник не найден");
                    }
                    break;
            }
        });
        butPrevious.addActionListener((e) -> {
            switch (numBut) {
                case 1:
                    selectedLine = (selectedLine - 1 + listLine.size()) % listLine.size();

                    if (selectedLine == 0) {
                        selectedLine = listLine.size();
                        listLine.get(selectedLine - 1).setColor(Color.RED);
                        listLine.get(0).setColor(Color.BLACK);
                    } else {
                        listLine.get(selectedLine - 1).setColor(Color.RED);
                        listLine.get(selectedLine).setColor(Color.BLACK);
                    }


                    cP.repaint();
                    break;
                case 2:
                    selectedCircle = (selectedCircle - 1 + listCircle.size()) % listCircle.size();

                    if (selectedCircle == 0) {
                        selectedCircle = listCircle.size();
                        listCircle.get(selectedCircle - 1).setColor(Color.RED);
                        listCircle.get(0).setColor(Color.BLACK);
                    } else {
                        listCircle.get(selectedCircle - 1).setColor(Color.RED);
                        listCircle.get(selectedCircle).setColor(Color.BLACK);
                    }
                    cP.repaint();
                    break;
                case 3:
                    selectedRectangle = (selectedRectangle - 1 + listRectangle.size()) % listRectangle.size();
                    if (selectedRectangle == 0) {
                        selectedRectangle = listRectangle.size();
                        listRectangle.get(selectedRectangle - 1).setColor(Color.RED);
                        listRectangle.get(0).setColor(Color.BLACK);
                    } else {
                        listRectangle.get(selectedRectangle - 1).setColor(Color.RED);
                        listRectangle.get(selectedRectangle).setColor(Color.BLACK);
                    }
                    cP.repaint();
                    break;
                case 4:
                    selectedTriangle = (selectedTriangle - 1 + listTriangle.size()) % listTriangle.size();
                    if (selectedTriangle == 0) {
                        selectedTriangle = listTriangle.size();
                        listTriangle.get(selectedTriangle - 1).setColor(Color.RED);
                        listTriangle.get(0).setColor(Color.BLACK);
                    } else {
                        listTriangle.get(selectedTriangle - 1).setColor(Color.RED);
                        listTriangle.get(selectedTriangle).setColor(Color.BLACK);
                    }
                    cP.repaint();
                    break;
            }
        });
        butNext.addActionListener((e) -> {
            switch (numBut) {
                case 1:
                    selectedLine = (selectedLine) % listLine.size();
                    if (selectedLine == 0) {
                        listLine.get(0).setColor(Color.RED);
                        listLine.get(listLine.size() - 1).setColor(Color.BLACK);
                        selectedLine = 1;

                    } else {
                        listLine.get(selectedLine).setColor(Color.RED);
                        listLine.get(selectedLine - 1).setColor(Color.BLACK);
                        selectedLine += 1;
                    }
                    cP.repaint();
                    break;
                case 2:
                    selectedCircle = (selectedCircle) % listCircle.size();
                    if (selectedCircle == 0) {
                        listCircle.get(0).setColor(Color.RED);
                        listCircle.get(listCircle.size() - 1).setColor(Color.BLACK);
                        selectedCircle = 1;

                    } else {
                        listCircle.get(selectedCircle).setColor(Color.RED);
                        listCircle.get(selectedCircle - 1).setColor(Color.BLACK);
                        selectedCircle += 1;
                    }
                    cP.repaint();
                    break;
                case 3:
                    selectedRectangle = (selectedRectangle) % listRectangle.size();
                    if (selectedRectangle == 0) {
                        listRectangle.get(0).setColor(Color.RED);
                        listRectangle.get(listRectangle.size() - 1).setColor(Color.BLACK);
                        selectedRectangle = 1;

                    } else {
                        listRectangle.get(selectedRectangle).setColor(Color.RED);
                        listRectangle.get(selectedRectangle - 1).setColor(Color.BLACK);
                        selectedRectangle += 1;
                    }
                    cP.repaint();
                    break;
                case 4:
                    selectedTriangle = (selectedTriangle) % listTriangle.size();
                    if (selectedTriangle == 0) {
                        listTriangle.get(0).setColor(Color.RED);
                        listTriangle.get(listTriangle.size() - 1).setColor(Color.BLACK);
                        selectedTriangle = 1;

                    } else {
                        listTriangle.get(selectedTriangle).setColor(Color.RED);
                        listTriangle.get(selectedTriangle - 1).setColor(Color.BLACK);
                        selectedTriangle += 1;
                    }
                    cP.repaint();
                    break;
            }
        });
        return p;
    }

    public static void main(String[] argc) {
        SwingUtilities.invokeLater(Start::new);
    }
}
