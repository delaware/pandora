package gui;

import model.Image;
import org.neuroph.core.NeuralNetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private final static String APPLICATION_TITLE = "Pandora - A Smiley Mood Recognition Software";
    Image image = new Image();
    JButton update = new JButton("update");
    JTextArea output = new JTextArea();
    ImagePanel matrix = new ImagePanel(image,true,Color.GREEN);
    PreviewFrame preview = new PreviewFrame(image);

    public MainFrame()
    {
        setMinimumSize(new java.awt.Dimension(630, 480));
        setPreferredSize(new java.awt.Dimension(630, 480));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(APPLICATION_TITLE);
        getContentPane().setBackground(Color.WHITE);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initPanels();
    }

    private void initPanels()
    {
        {
            JLabel label_working = new JLabel();
            JButton calculate = new JButton();
            JLabel label_output = new JLabel();
            JButton clear = new JButton();
            JButton reset = new JButton();
            JButton preview = new JButton();
            JPanel working = new JPanel();

            working.setMinimumSize(new java.awt.Dimension(250, 250));
            working.setPreferredSize(new java.awt.Dimension(250, 250));

            javax.swing.GroupLayout workingLayout = new javax.swing.GroupLayout(working);
            working.setLayout(workingLayout);
            workingLayout.setHorizontalGroup(
                    workingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 250, Short.MAX_VALUE)
            );
            workingLayout.setVerticalGroup(
                    workingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 0, Short.MAX_VALUE)
            );

            working.add(matrix);

            label_working.setText("smiley input matrix:");

            clear.setText("Clear");

            reset.setText("Reset");

            preview.setText("Preview");

            output.setText("...");
            output.setMinimumSize(new java.awt.Dimension(200, 250));
            output.setPreferredSize(new java.awt.Dimension(200, 250));
            output.setFont(new Font("Courier New", 1, 12));

            calculate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            calculate.setText(">");

            label_output.setText("mood likeliness output:");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(label_working, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                            .addComponent(working, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(preview)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                    .addComponent(calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(65, 65, 65)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label_output, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(output, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(82, 82, 82))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(label_working, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_output))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(output, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(working, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(clear)
                                            .addComponent(reset)
                                            .addComponent(preview))
                                    .addContainerGap(111, Short.MAX_VALUE))
            );

            pack();

            preview.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    preview();
                }
            });

            calculate.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calculate();
                }
            });

            reset.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double[] values = {
                            0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,1,0,1,1,0,1,1,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0
                    };
                    matrix.updateImageValues(values);
                    matrix.updateButtons();
                }
            });

            clear.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double[] values = {
                            0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0
                    };
                    matrix.updateImageValues(values);
                    matrix.updateButtons();
                }
            });
        }// </editor-fold>
    }

    public void preview() {
        preview.updateButtons(matrix.getImage());
        preview.setVisible(true);
    }

    public void calculate() {
//        NeuralNetwork network = NeuralNetwork.load("C:\\Users\\markus\\Documents\\NetBeansProjects\\pandora\\Neural Networks\\Network.nnet");
        NeuralNetwork network = NeuralNetwork.load(ClassLoader.getSystemResourceAsStream("Network.nnet"));

        double[] testSet = image.getValues();

        network.setInput(testSet);
        network.calculate();

        double[] output = network.getOutput();

        for(int n = 0; n<output.length;n++) {
            output[n] = (int)Math.round(output[n]*100);
        }

        int maxIndex = 0;
        for (int i = 1; i < output.length; i++){
            double newnumber = output[i];
            if ((newnumber > output[maxIndex])){
                maxIndex = i;
            }
        }

        String likeliness;
        switch(maxIndex) {
            case 0:
                likeliness = "happy";
                break;
            case 1:
                likeliness = "sad";
                break;
            case 2:
                likeliness = "surprised";
                break;
            case 3:
                likeliness = "angry";
                break;
            default:
                likeliness = "not sure!";
                break;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("happy:        ").append(output[0]).append(" %").append(System.lineSeparator());
        sb.append("sad:          ").append(output[1]).append(" %").append(System.lineSeparator());
        sb.append("surprised:    ").append(output[2]).append(" %").append(System.lineSeparator());
        sb.append("angry:        ").append(output[3]).append(" %").append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("most likely:  ").append(likeliness);

        this.output.setText(sb.toString());

    }
}
