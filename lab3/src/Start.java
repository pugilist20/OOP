

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Start {
    private JFrame title = new JFrame("Лабораторная работа №1");
    private JButton butCircles = new JButton("Окружности");
    private JButton butQuadrilaterals = new JButton("Четырёхугольники");
    private JButton butBackFirst = new JButton("Назад");
    private JButton butTCircle = new JButton("Окружность");
    private JButton butTEllipse = new JButton("Эллипс");
    private JButton butTQuadrilaterals = new JButton("Четырёхугольник");
    private JButton butTRectangle = new JButton("Прямоугольник");
    private JButton butTRomb = new JButton("Ромб");
    private JButton butTTrapeze = new JButton("Трапеция");
    private JButton butBackSecond = new JButton("Назад");
    private JButton butCreate = new JButton("Создать");
    private JButton butMove = new JButton("Переместить");
    private JButton butDelete = new JButton("Удалить");
    private JButton butChangeRad = new JButton("Изменить радиус");
    private JButton butTurn = new JButton("Повернуть на 90");
    private JButton butChangeSize = new JButton("Изменить размер");
    private JButton butVisible = new JButton("Сделать видимым/невидимым");
    private JButton butNext = new JButton("Следующая фигура");
    private JButton butPrevious = new JButton("Предыдущая фигура");
    ArrayList<TCircle> listTCircle = new ArrayList<>();
    int selectedTCircle = -1;
    ArrayList<TEllipse> listTEllipse = new ArrayList<>();
    int selectedTEllipse = -1;
    ArrayList<TQuadrilaterals> listTQuadrilaterals = new ArrayList<>();
    int selectedTQuadrilaterals = -1;
    ArrayList<TRectangle> listTRectangle = new ArrayList<>();
    int selectedTRectangle = -1;
    ArrayList<TRomb> listTRomb = new ArrayList<>();
    int selectedTRomb = -1;
    ArrayList<TTrapeze> listTTrapeze = new ArrayList<>();
    int selectedTTrapeze = -1;
    private int numBut;
    private JPanel cP = centerPanel();
    private JPanel sP = southPanel();
    private JPanel circle = null;
    private JPanel ellipse = null;
    private JPanel quadrilaterals = null;
    private JPanel rectangle = null;
    private JPanel romb = null;
    private JPanel trapeze = null;
    private int coords1;
    private int coords2;
    private int coords3;
    private int coords4;
    private int coords5;
    private int coords6;
    private int coords7;
    private int coords8;
    private boolean visionTCircle = false;
    private boolean visionTEllipse = false;
    private boolean visionTQuadrilaterals = false;
    private boolean visionTRectangle = false;
    private boolean visionTRhomb = false;
    private boolean visionTTrapeze = false;

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
        p.add(butCircles).setBackground(Color.LIGHT_GRAY);
        p.add(butQuadrilaterals).setBackground(Color.LIGHT_GRAY);
        butCircles.addActionListener((e) -> {
            sP.removeAll();
            sP.add(butBackFirst).setBackground(Color.LIGHT_GRAY);
            sP.add(butTCircle).setBackground(Color.LIGHT_GRAY);
            sP.add(butTEllipse).setBackground(Color.LIGHT_GRAY);
            sP.revalidate();
            sP.repaint();
            butBackFirst.addActionListener((e1) -> {
                sP.removeAll();
                sP.add(butCircles).setBackground(Color.LIGHT_GRAY);
                sP.add(butQuadrilaterals).setBackground(Color.LIGHT_GRAY);
                sP.revalidate();
                sP.repaint();
            });
            butTCircle.addActionListener((e2) -> {
                sP.removeAll();
                sP.add(butBackSecond).setBackground(Color.LIGHT_GRAY);
                sP.add(butCreate).setBackground(Color.LIGHT_GRAY);
                sP.add(butMove).setBackground(Color.LIGHT_GRAY);
                sP.add(butDelete).setBackground(Color.LIGHT_GRAY);
                sP.add(butChangeRad).setBackground(Color.LIGHT_GRAY);
                sP.add(butVisible).setBackground(Color.LIGHT_GRAY);
                sP.add(butPrevious).setBackground(Color.LIGHT_GRAY);
                sP.add(butNext).setBackground(Color.LIGHT_GRAY);
                sP.revalidate();
                sP.repaint();
                if (!listTCircle.isEmpty()) {
                    listTCircle.get(selectedTCircle - 1).setColor(Color.RED);
                }
                cP.revalidate();
                cP.repaint();
                numBut = 1;
            });
            butTEllipse.addActionListener((e3) -> {
                sP.removeAll();
                sP.add(butBackSecond).setBackground(Color.LIGHT_GRAY);
                sP.add(butCreate).setBackground(Color.LIGHT_GRAY);
                sP.add(butMove).setBackground(Color.LIGHT_GRAY);
                sP.add(butDelete).setBackground(Color.LIGHT_GRAY);
                sP.add(butVisible).setBackground(Color.LIGHT_GRAY);
                sP.add(butTurn).setBackground(Color.LIGHT_GRAY);
                sP.add(butPrevious).setBackground(Color.LIGHT_GRAY);
                sP.add(butNext).setBackground(Color.LIGHT_GRAY);
                sP.revalidate();
                sP.repaint();
                if (!listTEllipse.isEmpty()) {
                    listTEllipse.get(selectedTEllipse - 1).setColor(Color.RED);
                }
                cP.revalidate();
                cP.repaint();
                numBut = 2;
            });
        });
        butQuadrilaterals.addActionListener((e) -> {
            sP.removeAll();
            sP.add(butBackFirst).setBackground(Color.LIGHT_GRAY);
            sP.add(butTQuadrilaterals).setBackground(Color.LIGHT_GRAY);
            sP.add(butTRectangle).setBackground(Color.LIGHT_GRAY);
            sP.add(butTRomb).setBackground(Color.LIGHT_GRAY);
            sP.add(butTTrapeze).setBackground(Color.LIGHT_GRAY);
            sP.revalidate();
            sP.repaint();
            butBackFirst.addActionListener((e1) -> {
                sP.removeAll();
                sP.add(butCircles).setBackground(Color.LIGHT_GRAY);
                sP.add(butQuadrilaterals).setBackground(Color.LIGHT_GRAY);
                sP.revalidate();
                sP.repaint();
            });
            butTRectangle.addActionListener((e2) -> {
                sP.removeAll();
                sP.add(butBackSecond).setBackground(Color.LIGHT_GRAY);
                sP.add(butCreate).setBackground(Color.LIGHT_GRAY);
                sP.add(butMove).setBackground(Color.LIGHT_GRAY);
                sP.add(butDelete).setBackground(Color.LIGHT_GRAY);
                sP.add(butChangeSize).setBackground(Color.LIGHT_GRAY);
                sP.add(butVisible).setBackground(Color.LIGHT_GRAY);
                sP.add(butPrevious).setBackground(Color.LIGHT_GRAY);
                sP.add(butNext).setBackground(Color.LIGHT_GRAY);
                sP.revalidate();
                sP.repaint();
                if (!listTRectangle.isEmpty()) {
                    listTRectangle.get(selectedTRectangle - 1).setColor(Color.RED);
                }
                cP.revalidate();
                cP.repaint();
                numBut = 3;
            });
            butTRomb.addActionListener((e2) -> {
                sP.removeAll();
                sP.add(butBackSecond).setBackground(Color.LIGHT_GRAY);
                sP.add(butCreate).setBackground(Color.LIGHT_GRAY);
                sP.add(butMove).setBackground(Color.LIGHT_GRAY);
                sP.add(butDelete).setBackground(Color.LIGHT_GRAY);
                sP.add(butChangeSize).setBackground(Color.LIGHT_GRAY);
                sP.add(butVisible).setBackground(Color.LIGHT_GRAY);
                sP.add(butPrevious).setBackground(Color.LIGHT_GRAY);
                sP.add(butNext).setBackground(Color.LIGHT_GRAY);
                sP.revalidate();
                sP.repaint();
                if (!listTRomb.isEmpty()) {
                    listTRomb.get(selectedTRomb - 1).setColor(Color.RED);
                }
                cP.revalidate();
                cP.repaint();
                numBut = 4;
            });
            butTTrapeze.addActionListener((e2) -> {
                sP.removeAll();
                sP.add(butBackSecond).setBackground(Color.LIGHT_GRAY);
                sP.add(butCreate).setBackground(Color.LIGHT_GRAY);
                sP.add(butMove).setBackground(Color.LIGHT_GRAY);
                sP.add(butDelete).setBackground(Color.LIGHT_GRAY);
                sP.add(butChangeSize).setBackground(Color.LIGHT_GRAY);
                sP.add(butVisible).setBackground(Color.LIGHT_GRAY);
                sP.add(butPrevious).setBackground(Color.LIGHT_GRAY);
                sP.add(butNext).setBackground(Color.LIGHT_GRAY);
                sP.revalidate();
                sP.repaint();
                if (!listTTrapeze.isEmpty()) {
                    listTTrapeze.get(selectedTTrapeze - 1).setColor(Color.RED);
                }
                cP.revalidate();
                cP.repaint();
                numBut = 5;
            });
            butTQuadrilaterals.addActionListener((e2) -> {
                sP.removeAll();
                sP.add(butBackSecond).setBackground(Color.LIGHT_GRAY);
                sP.add(butCreate).setBackground(Color.LIGHT_GRAY);
                sP.add(butMove).setBackground(Color.LIGHT_GRAY);
                sP.add(butDelete).setBackground(Color.LIGHT_GRAY);
                sP.add(butChangeSize).setBackground(Color.LIGHT_GRAY);
                sP.add(butVisible).setBackground(Color.LIGHT_GRAY);
                sP.add(butPrevious).setBackground(Color.LIGHT_GRAY);
                sP.add(butNext).setBackground(Color.LIGHT_GRAY);
                sP.revalidate();
                sP.repaint();
                if (!listTQuadrilaterals.isEmpty()) {
                    listTQuadrilaterals.get(selectedTQuadrilaterals - 1).setColor(Color.RED);
                }
                cP.revalidate();
                cP.repaint();
                numBut = 6;
            });
        });
        butCreate.addActionListener((e) -> {
            switch (numBut) {
                case 1:
                    visionTCircle = true;
                    coords1 = (int) (Math.random() * 1223.0);
                    coords2 = (int) (Math.random() * 590.0);
                    if (Math.min(1260 - coords1, 615 - coords2) < Math.min(coords1, coords2)) {
                        coords3 = 15 + (int) (Math.random() * (Math.min(1220 - coords1, 580 - coords2)));
                    } else {
                        coords3 = (int) (Math.random() * (Math.min(coords1, coords2)));
                    }
                    if (!listTCircle.isEmpty()) {
                        circle = new TCircle(coords1, coords2, coords3, Color.RED);
                        listTCircle.add((TCircle) circle);
                        if (listTCircle.size() >= 2) {
                            if (selectedTCircle == 0) {
                                listTCircle.get(selectedTCircle).setColor(Color.BLACK);
                            } else {
                                listTCircle.get(selectedTCircle - 1).setColor(Color.BLACK);
                            }

                        }
                    }
                    if (listTCircle.isEmpty()) {
                        circle = new TCircle(coords1, coords2, coords3, Color.RED);
                        listTCircle.add((TCircle) circle);
                    }

                    ((TCircle) circle).Show(visionTCircle);
                    cP.add(circle, "Center");
                    cP.revalidate();
                    selectedTCircle = listTCircle.size();
                    break;


                case 2:
                    visionTEllipse = true;
                    coords1 = (int) (Math.random() * 1223.0);
                    coords2 = (int) (Math.random() * 590.0);
                    int maxCoords = Math.min(1260 - coords1, 615 - coords2);
                    coords3 = (int) (Math.random() * (Math.min(maxCoords, Math.min(coords1, coords2))));
                    if (!listTEllipse.isEmpty()) {
                        int width = coords3;
                        int height = coords3 / 2;
                        if (Math.random() * 2 > 1) {
                            ellipse = new TEllipse(coords1, coords2, width, height, Color.RED);
                        } else {
                            ellipse = new TEllipse(coords1, coords2, height, width, Color.RED);
                        }
                        listTEllipse.add((TEllipse) ellipse);
                        int index = Math.max(0, selectedTEllipse - 1);
                        listTEllipse.get(index).setColor(Color.BLACK);
                    } else {
                        ellipse = new TEllipse(coords1, coords2, coords3, coords3 / 2, Color.RED);
                        listTEllipse.add((TEllipse) ellipse);
                    }
                    ((TEllipse) ellipse).Show(visionTEllipse);
                    cP.add(ellipse, "Center");
                    cP.revalidate();
                    selectedTEllipse = listTEllipse.size();
                    break;
                case 3:
                    visionTRectangle = true;
                    coords1 = (int) (Math.random() * 1240.0);
                    coords2 = (int) (Math.random() * 590.0);
                    coords3 = 3 + (int) (Math.random() * (1260.0 - coords1));
                    coords4 = 3 + (int) (Math.random() * (605.0 - coords2));
                    if (!listTRectangle.isEmpty()) {
                        rectangle = new TRectangle(coords1, coords2, coords3, coords4, Color.RED);
                        listTRectangle.add((TRectangle) rectangle);
                        if (listTRectangle.size() >= 2) {
                            if (selectedTRectangle == 0) {
                                listTRectangle.get(selectedTRectangle).setColor(Color.BLACK);
                            } else {
                                listTRectangle.get(selectedTRectangle - 1).setColor(Color.BLACK);
                            }

                        }
                    }
                    if (listTRectangle.isEmpty()) {
                        rectangle = new TRectangle(coords1, coords2, coords3, coords4, Color.RED);
                        listTRectangle.add((TRectangle) rectangle);
                    }

                    ((TRectangle) rectangle).Show(visionTRectangle);
                    cP.add(rectangle, "Center");
                    cP.revalidate();
                    selectedTRectangle = listTRectangle.size();
                    break;


                case 4:
                    visionTRhomb = true;
                    coords1 = (int) (Math.random() * 1240.0);
                    coords2 = (int) (Math.random() * 590.0);
                    coords3 = 3 + (int) (Math.random() * (1260.0 - coords1));
                    coords4 = 3 + (int) (Math.random() * (605.0 - coords2));
                    if (!listTRomb.isEmpty()) {
                        romb = new TRomb(coords1, coords2, coords3, coords4, Color.RED);
                        listTRomb.add((TRomb) romb);
                        if (listTRomb.size() >= 2) {
                            if (selectedTRomb == 0) {
                                listTRomb.get(selectedTRomb).setColor(Color.BLACK);
                            } else {
                                listTRomb.get(selectedTRomb - 1).setColor(Color.BLACK);
                            }

                        }
                    }
                    if (listTRomb.isEmpty()) {
                        romb = new TRomb(coords1, coords2, coords3, coords4, Color.RED);
                        listTRomb.add((TRomb) romb);
                    }

                    ((TRomb) romb).Show(visionTRhomb);
                    cP.add(romb, "Center");
                    cP.revalidate();
                    selectedTRomb = listTRomb.size();
                    break;
                case 5:
                    visionTTrapeze = true;
                    coords1 = (int) (Math.random() * 1220.0);
                    coords2 = (int) (Math.random() * 570.0);
                    coords3 = 20 + (int) (Math.random() * (1240.0 - coords1));
                    coords4 = 20 + (int) (Math.random() * (585.0 - coords2));
                    coords5 = (int) (Math.random() * 50);
                    if (!listTTrapeze.isEmpty()) {
                        trapeze = new TTrapeze(coords1, coords2, coords3, coords4, coords5, Color.RED);
                        listTTrapeze.add((TTrapeze) trapeze);
                        if (listTTrapeze.size() >= 2) {
                            if (selectedTTrapeze == 0) {
                                listTTrapeze.get(selectedTTrapeze).setColor(Color.BLACK);
                            } else {
                                listTTrapeze.get(selectedTTrapeze - 1).setColor(Color.BLACK);
                            }

                        }
                    }
                    if (listTTrapeze.isEmpty()) {
                        trapeze = new TTrapeze(coords1, coords2, coords3, coords4, coords5, Color.RED);
                        listTTrapeze.add((TTrapeze) trapeze);
                    }

                    ((TTrapeze) trapeze).Show(visionTTrapeze);
                    cP.add(trapeze, "Center");
                    cP.revalidate();
                    selectedTTrapeze = listTTrapeze.size();
                    break;
                case 6:
                    visionTQuadrilaterals = true;
                    coords1 = (int) (Math.random() * 610.0);
                    coords2 = (int) (Math.random() * 285.0);
                    coords3 = 610+ (int) (Math.random() * 610);
                    coords4 = (int) (Math.random() * 285.0);
                    coords5 = 610+ (int) (Math.random() * 610);
                    coords6 = 285+ (int) (Math.random() * 285.0);
                    coords7 = (int) (Math.random() * 610);
                    coords8 = 285+ (int) (Math.random() * 285.0);
                    if (!listTQuadrilaterals.isEmpty()) {
                        quadrilaterals = new TQuadrilaterals(coords1, coords2, coords3, coords4, coords5, coords6, coords7, coords8, Color.RED);
                        listTQuadrilaterals.add((TQuadrilaterals) quadrilaterals);
                        if (listTQuadrilaterals.size() >= 2) {
                            if (selectedTQuadrilaterals == 0) {
                                listTQuadrilaterals.get(selectedTQuadrilaterals).setColor(Color.BLACK);
                            } else {
                                listTQuadrilaterals.get(selectedTQuadrilaterals - 1).setColor(Color.BLACK);
                            }
                        }
                    }
                    if (listTQuadrilaterals.isEmpty()) {
                        quadrilaterals = new TQuadrilaterals(coords1, coords2, coords3, coords4, coords5, coords6, coords7, coords8, Color.RED);
                        listTQuadrilaterals.add((TQuadrilaterals) quadrilaterals);
                    }
                    ((TQuadrilaterals) quadrilaterals).Show(visionTQuadrilaterals);
                    cP.add(quadrilaterals, "Center");
                    cP.revalidate();
                    selectedTQuadrilaterals = listTQuadrilaterals.size();
                    break;
            }
        });
        butBackSecond.addActionListener((e) -> {
            switch (numBut) {
                case 1, 2:
                    sP.removeAll();
                    sP.add(butBackFirst).setBackground(Color.LIGHT_GRAY);
                    sP.add(butTCircle).setBackground(Color.LIGHT_GRAY);
                    sP.add(butTEllipse).setBackground(Color.LIGHT_GRAY);
                    break;
                case 3, 4, 5, 6:
                    sP.removeAll();
                    sP.add(butBackFirst).setBackground(Color.LIGHT_GRAY);
                    sP.add(butTQuadrilaterals).setBackground(Color.LIGHT_GRAY);
                    sP.add(butTRectangle).setBackground(Color.LIGHT_GRAY);
                    sP.add(butTRomb).setBackground(Color.LIGHT_GRAY);
                    sP.add(butTTrapeze).setBackground(Color.LIGHT_GRAY);
            }
            if (!listTCircle.isEmpty()) {
                listTCircle.get(selectedTCircle - 1).setColor(Color.BLACK);
            }
            if (!listTEllipse.isEmpty()) {
                listTEllipse.get(selectedTEllipse - 1).setColor(Color.BLACK);
            }
            if (!listTRectangle.isEmpty()) {
                listTRectangle.get(selectedTRectangle - 1).setColor(Color.BLACK);
            }
            if (!listTRomb.isEmpty()) {
                listTRomb.get(selectedTRomb - 1).setColor(Color.BLACK);
            }
            if (!listTTrapeze.isEmpty()) {
                listTTrapeze.get(selectedTTrapeze - 1).setColor(Color.BLACK);
            }
            if(!listTQuadrilaterals.isEmpty()){
                listTQuadrilaterals.get(selectedTQuadrilaterals-1).setColor(Color.BLACK);
            }
            cP.revalidate();
            cP.repaint();
            sP.revalidate();
            sP.repaint();
        });

        butMove.addActionListener((e) ->

        {
            coords1 = -50 + (int) (Math.random() * 100);
            coords2 = -50 + (int) (Math.random() * 100);
            switch (numBut) {
                case 1:
                    if (selectedTCircle != 0 && selectedTCircle != -1) {
                        listTCircle.get(selectedTCircle - 1).MoveTo(coords1, coords2);
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Окружность не найдена");
                    }
                    coords1 = coords2 = 0;
                    break;

                case 2:
                    if (selectedTEllipse != 0 && selectedTEllipse != -1) {
                        listTEllipse.get(selectedTEllipse - 1).MoveTo(coords1, coords2);
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Эллипс не найден");
                    }
                    coords1 = coords2 = 0;
                    break;

                case 3:
                    if (selectedTRectangle != 0 && selectedTRectangle != -1) {
                        listTRectangle.get(selectedTRectangle - 1).MoveTo(coords1, coords2);
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
                case 4:
                    if (selectedTRomb != 0 && selectedTRomb != -1) {
                        listTRomb.get(selectedTRomb - 1).MoveTo(coords1, coords2);
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
                case 5:

                    if (selectedTTrapeze != 0 && selectedTTrapeze != -1) {
                        listTTrapeze.get(selectedTTrapeze - 1).MoveTo(coords1, coords2);
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
                case 6:
                    if (selectedTQuadrilaterals != 0 && selectedTQuadrilaterals != -1) {
                        listTQuadrilaterals.get(selectedTQuadrilaterals - 1).MoveTo(coords1, coords2);
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
            }

        });
        butDelete.addActionListener((e) ->{
            switch (numBut) {
                case 1:
                    if (listTCircle.size() > 1) {
                        int indexToRemove = (selectedTCircle == 1) ? 0 : selectedTCircle - 1;
                        cP.remove(listTCircle.get(indexToRemove));
                        listTCircle.remove(indexToRemove);
                        selectedTCircle = (selectedTCircle == 1) ? listTCircle.size() : selectedTCircle - 1;
                        listTCircle.get(selectedTCircle - 1).setColor(Color.RED);
                        cP.revalidate();
                        cP.repaint();
                    } else if (listTCircle.size() == 1) {
                        cP.remove(listTCircle.get(0));
                        listTCircle.remove(0);
                        selectedTCircle = -1;
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Окружность не найдена");
                    }
                    break;
                case 2:
                    if (listTEllipse.size() > 1) {
                        int indexToRemove = (selectedTEllipse == 1) ? 0 : selectedTEllipse - 1;
                        cP.remove(listTEllipse.get(indexToRemove));
                        listTEllipse.remove(indexToRemove);
                        selectedTEllipse = (selectedTEllipse == 1) ? listTEllipse.size() : selectedTEllipse - 1;
                        listTEllipse.get(selectedTEllipse - 1).setColor(Color.RED);
                        cP.revalidate();
                        cP.repaint();
                    } else if (listTEllipse.size() == 1) {
                        cP.remove(listTEllipse.get(0));
                        listTEllipse.remove(0);
                        selectedTEllipse = -1;
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Эллипс не найден");
                    }
                    break;
                case 3:
                    if (listTRectangle.size() > 1) {
                        int indexToRemove = (selectedTRectangle == 1) ? 0 : selectedTRectangle - 1;
                        cP.remove(listTRectangle.get(indexToRemove));
                        listTRectangle.remove(indexToRemove);
                        selectedTRectangle = (selectedTRectangle == 1) ? listTRectangle.size() : selectedTRectangle - 1;
                        listTRectangle.get(selectedTRectangle - 1).setColor(Color.RED);
                        cP.revalidate();
                        cP.repaint();
                    } else if (listTRectangle.size() == 1) {
                        cP.remove(listTRectangle.get(0));
                        listTRectangle.remove(0);
                        selectedTRectangle = -1;
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    break;
                case 4:
                    if (listTRomb.size() > 1) {
                        int indexToRemove = (selectedTRomb == 1) ? 0 : selectedTRomb - 1;
                        cP.remove(listTRomb.get(indexToRemove));
                        listTRomb.remove(indexToRemove);
                        selectedTRomb = (selectedTRomb == 1) ? listTRomb.size() : selectedTRomb - 1;
                        listTRomb.get(selectedTRomb - 1).setColor(Color.RED);
                        cP.revalidate();
                        cP.repaint();
                    } else if (listTRomb.size() == 1) {
                        cP.remove(listTRomb.get(0));
                        listTRomb.remove(0);
                        selectedTRomb = -1;
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    break;
                case 5:
                    if (listTTrapeze.size() > 1) {
                        int indexToRemove = (selectedTTrapeze == 1) ? 0 : selectedTTrapeze - 1;
                        cP.remove(listTTrapeze.get(indexToRemove));
                        listTTrapeze.remove(indexToRemove);
                        selectedTTrapeze = (selectedTTrapeze == 1) ? listTTrapeze.size() : selectedTTrapeze - 1;
                        listTTrapeze.get(selectedTTrapeze - 1).setColor(Color.RED);
                        cP.revalidate();
                        cP.repaint();
                    } else if (listTTrapeze.size() == 1) {
                        cP.remove(listTTrapeze.get(0));
                        listTTrapeze.remove(0);
                        selectedTTrapeze = -1;
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    break;
                case 6:
                    if (listTQuadrilaterals.size() > 1) {
                        int indexToRemove = (selectedTQuadrilaterals == 1) ? 0 : selectedTQuadrilaterals - 1;
                        cP.remove(listTQuadrilaterals.get(indexToRemove));
                        listTQuadrilaterals.remove(indexToRemove);
                        selectedTQuadrilaterals = (selectedTQuadrilaterals == 1) ? listTQuadrilaterals.size() : selectedTQuadrilaterals - 1;
                        listTQuadrilaterals.get(selectedTQuadrilaterals - 1).setColor(Color.RED);
                        cP.revalidate();
                        cP.repaint();
                    } else if (listTQuadrilaterals.size() == 1) {
                        cP.remove(listTQuadrilaterals.get(0));
                        listTQuadrilaterals.remove(0);
                        selectedTQuadrilaterals = -1;
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Четырёхугольник не найден");
                    }
                    break;
            }
        });
        butChangeRad.addActionListener((e) ->

        {
            if (numBut == 1) {
                coords1 = -25 + (int) (Math.random() * 50.0);
                if (selectedTCircle != 0 && selectedTCircle != -1) {
                    if (listTCircle.get(selectedTCircle - 1).getR() + coords1 >= 10) {
                        listTCircle.get(selectedTCircle - 1).chRad(coords1);
                        coords1 = 0;
                        cP.revalidate();
                        cP.repaint();
                    }
                } else {
                    JOptionPane.showMessageDialog(title, "Окружность не найдена");
                }
            }
        });
        butTurn.addActionListener((e) ->

        {
            if (numBut == 2) {
                if (selectedTEllipse != 0 && selectedTEllipse != -1) {
                    listTEllipse.get(selectedTEllipse - 1).turn();
                    cP.revalidate();
                    cP.repaint();
                }
            } else {
                JOptionPane.showMessageDialog(title, "Окружность не найдена");
            }
        });
        butChangeSize.addActionListener((e) ->

        {
            coords1 = -25 + (int) (Math.random() * 50.0);
            coords2 = -25 + (int) (Math.random() * 50.0);
            switch (numBut) {
                case 3:
                    if (selectedTRectangle != 0 && selectedTRectangle != -1) {
                        listTRectangle.get(selectedTRectangle - 1).chSize(coords1, coords2);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
                case 4:
                    if (selectedTRomb != 0 && selectedTRomb != -1) {
                        listTRomb.get(selectedTRomb - 1).chSize(coords1, coords2);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
                case 5:
                    if (selectedTTrapeze != 0 && selectedTTrapeze != -1) {
                        listTTrapeze.get(selectedTTrapeze - 1).chSize(coords1, coords2);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
                case 6:
                    if (selectedTQuadrilaterals != 0 && selectedTQuadrilaterals != -1) {
                        listTQuadrilaterals.get(selectedTQuadrilaterals - 1).chSize(coords1, coords2);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    coords1 = coords2 = 0;
                    break;
            }
        });
        butVisible.addActionListener((e) ->

        {
            switch (numBut) {
                case 1:
                    if (selectedTCircle != 0 && selectedTCircle != -1) {
                        visionTCircle = !visionTCircle;
                        listTCircle.get(selectedTCircle - 1).Show(visionTCircle);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Окружность не найдена");
                    }
                    break;
                case 2:
                    if (selectedTEllipse != 0 && selectedTEllipse != -1) {
                        visionTEllipse = !visionTEllipse;
                        listTEllipse.get(selectedTEllipse - 1).Show(visionTEllipse);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Эллипс не найден");
                    }
                    break;
                case 3:
                    if (selectedTRectangle != 0 && selectedTRectangle != -1) {
                        visionTRectangle = !visionTRectangle;
                        listTRectangle.get(selectedTRectangle - 1).Show(visionTRectangle);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Прямоугольник не найден");
                    }
                    break;
                case 4:
                    if (selectedTRomb != 0 && selectedTRomb != -1) {
                        visionTRhomb = !visionTRhomb;
                        listTRomb.get(selectedTRomb - 1).Show(visionTRhomb);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Треугольник не найден");
                    }
                    break;
                case 5:
                    if (selectedTTrapeze != 0 && selectedTTrapeze != -1) {
                        visionTTrapeze = !visionTTrapeze;
                        listTTrapeze.get(selectedTTrapeze - 1).Show(visionTTrapeze);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Треугольник не найден");
                    }
                    break;
                case 6:
                    if (selectedTQuadrilaterals != 0 && selectedTQuadrilaterals != -1) {
                        visionTQuadrilaterals = !visionTQuadrilaterals;
                        listTQuadrilaterals.get(selectedTQuadrilaterals - 1).Show(visionTQuadrilaterals);
                        cP.revalidate();
                        cP.repaint();
                    } else {
                        JOptionPane.showMessageDialog(title, "Треугольник не найден");
                    }
                    break;
            }
        });
        butPrevious.addActionListener((e) ->

        {
            switch (numBut) {
                case 1:
                    selectedTCircle = (selectedTCircle - 1 + listTCircle.size()) % listTCircle.size();

                    if (selectedTCircle == 0) {
                        selectedTCircle = listTCircle.size();
                        listTCircle.get(selectedTCircle - 1).setColor(Color.RED);
                        listTCircle.get(0).setColor(Color.BLACK);
                    } else {
                        listTCircle.get(selectedTCircle - 1).setColor(Color.RED);
                        listTCircle.get(selectedTCircle).setColor(Color.BLACK);
                    }
                    cP.repaint();
                    break;
                case 2:
                    selectedTEllipse = (selectedTEllipse - 1 + listTEllipse.size()) % listTEllipse.size();

                    if (selectedTEllipse == 0) {
                        selectedTEllipse = listTEllipse.size();
                        listTEllipse.get(selectedTEllipse - 1).setColor(Color.RED);
                        listTEllipse.get(0).setColor(Color.BLACK);
                    } else {
                        listTEllipse.get(selectedTEllipse - 1).setColor(Color.RED);
                        listTEllipse.get(selectedTEllipse).setColor(Color.BLACK);
                    }
                    cP.repaint();
                    break;
                case 3:
                    selectedTRectangle = (selectedTRectangle - 1 + listTRectangle.size()) % listTRectangle.size();
                    if (selectedTRectangle == 0) {
                        selectedTRectangle = listTRectangle.size();
                        listTRectangle.get(selectedTRectangle - 1).setColor(Color.RED);
                        listTRectangle.get(0).setColor(Color.BLACK);
                    } else {
                        listTRectangle.get(selectedTRectangle - 1).setColor(Color.RED);
                        listTRectangle.get(selectedTRectangle).setColor(Color.BLACK);
                    }
                    cP.repaint();
                    break;
                case 4:
                    selectedTRomb = (selectedTRomb - 1 + listTRomb.size()) % listTRomb.size();
                    if (selectedTRomb == 0) {
                        selectedTRomb = listTRomb.size();
                        listTRomb.get(selectedTRomb - 1).setColor(Color.RED);
                        listTRomb.get(0).setColor(Color.BLACK);
                    } else {
                        listTRomb.get(selectedTRomb - 1).setColor(Color.RED);
                        listTRomb.get(selectedTRomb).setColor(Color.BLACK);
                    }
                    cP.repaint();
                    break;
                case 5:
                    selectedTTrapeze = (selectedTTrapeze - 1 + listTTrapeze.size()) % listTTrapeze.size();
                    if (selectedTTrapeze == 0) {
                        selectedTTrapeze = listTTrapeze.size();
                        listTTrapeze.get(selectedTTrapeze - 1).setColor(Color.RED);
                        listTTrapeze.get(0).setColor(Color.BLACK);
                    } else {
                        listTTrapeze.get(selectedTTrapeze - 1).setColor(Color.RED);
                        listTTrapeze.get(selectedTTrapeze).setColor(Color.BLACK);
                    }
                    cP.repaint();
                    break;
                case 6:
                    selectedTQuadrilaterals = (selectedTQuadrilaterals - 1 + listTQuadrilaterals.size()) % listTQuadrilaterals.size();
                    if (selectedTQuadrilaterals == 0) {
                        selectedTQuadrilaterals = listTQuadrilaterals.size();
                        listTQuadrilaterals.get(selectedTQuadrilaterals - 1).setColor(Color.RED);
                        listTQuadrilaterals.get(0).setColor(Color.BLACK);
                    } else {
                        listTQuadrilaterals.get(selectedTQuadrilaterals - 1).setColor(Color.RED);
                        listTQuadrilaterals.get(selectedTQuadrilaterals).setColor(Color.BLACK);
                    }
                    cP.repaint();
                    break;
            }
        });
        butNext.addActionListener((e) ->

        {
            switch (numBut) {
                case 1:
                    selectedTCircle = (selectedTCircle) % listTCircle.size();
                    if (selectedTCircle == 0) {
                        listTCircle.get(0).setColor(Color.RED);
                        listTCircle.get(listTCircle.size() - 1).setColor(Color.BLACK);
                        selectedTCircle = 1;

                    } else {
                        listTCircle.get(selectedTCircle).setColor(Color.RED);
                        listTCircle.get(selectedTCircle - 1).setColor(Color.BLACK);
                        selectedTCircle += 1;
                    }
                    cP.repaint();
                    break;
                case 2:
                    selectedTEllipse = (selectedTEllipse) % listTEllipse.size();
                    if (selectedTEllipse == 0) {
                        listTEllipse.get(0).setColor(Color.RED);
                        listTEllipse.get(listTEllipse.size() - 1).setColor(Color.BLACK);
                        selectedTEllipse = 1;

                    } else {
                        listTEllipse.get(selectedTEllipse).setColor(Color.RED);
                        listTEllipse.get(selectedTEllipse - 1).setColor(Color.BLACK);
                        selectedTEllipse += 1;
                    }
                    cP.repaint();
                    break;
                case 3:
                    selectedTRectangle = (selectedTRectangle) % listTRectangle.size();
                    if (selectedTRectangle == 0) {
                        listTRectangle.get(0).setColor(Color.RED);
                        listTRectangle.get(listTRectangle.size() - 1).setColor(Color.BLACK);
                        selectedTRectangle = 1;

                    } else {
                        listTRectangle.get(selectedTRectangle).setColor(Color.RED);
                        listTRectangle.get(selectedTRectangle - 1).setColor(Color.BLACK);
                        selectedTRectangle += 1;
                    }
                    cP.repaint();
                    break;
                case 4:
                    selectedTRomb = (selectedTRomb) % listTRomb.size();
                    if (selectedTRomb == 0) {
                        listTRomb.get(0).setColor(Color.RED);
                        listTRomb.get(listTRomb.size() - 1).setColor(Color.BLACK);
                        selectedTRomb = 1;

                    } else {
                        listTRomb.get(selectedTRomb).setColor(Color.RED);
                        listTRomb.get(selectedTRomb - 1).setColor(Color.BLACK);
                        selectedTRomb += 1;
                    }
                    cP.repaint();
                    break;
                case 5:
                    selectedTTrapeze = (selectedTTrapeze) % listTTrapeze.size();
                    if (selectedTTrapeze == 0) {
                        listTTrapeze.get(0).setColor(Color.RED);
                        listTTrapeze.get(listTTrapeze.size() - 1).setColor(Color.BLACK);
                        selectedTTrapeze = 1;

                    } else {
                        listTTrapeze.get(selectedTTrapeze).setColor(Color.RED);
                        listTTrapeze.get(selectedTTrapeze - 1).setColor(Color.BLACK);
                        selectedTTrapeze += 1;
                    }
                    cP.repaint();
                    break;
                case 6:
                    selectedTQuadrilaterals = (selectedTQuadrilaterals) % listTQuadrilaterals.size();
                    if (selectedTQuadrilaterals == 0) {
                        listTQuadrilaterals.get(0).setColor(Color.RED);
                        listTQuadrilaterals.get(listTQuadrilaterals.size() - 1).setColor(Color.BLACK);
                        selectedTQuadrilaterals = 1;

                    } else {
                        listTQuadrilaterals.get(selectedTQuadrilaterals).setColor(Color.RED);
                        listTQuadrilaterals.get(selectedTQuadrilaterals - 1).setColor(Color.BLACK);
                        selectedTQuadrilaterals += 1;
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
