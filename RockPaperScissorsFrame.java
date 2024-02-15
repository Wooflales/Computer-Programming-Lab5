import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl;
    JPanel buttonPnl;
    JPanel statPnl;
    JPanel resultPnl;
    JButton rockBtn;
    JButton scissorsBtn;
    JButton paperBtn;
    JButton quitBtn;
    ImageIcon rockPic;
    ImageIcon scissorsPic;
    ImageIcon paperPic;
    JLabel playerWinLbl;
    JLabel playerLoseLbl;
    JLabel tieLbl;
    JTextField winTF;
    JTextField loseTF;
    JTextField tieTF;
    int winCnt;
    int loseCnt;
    int tieCnt;
    String cntConvert;
    JTextArea resultTA;
    JScrollPane scroller;
    Random rnd = new Random();

    public RockPaperScissorsFrame()
    {
        setTitle("Rock Paper Scissors Game");
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createStatPanel();
        mainPnl.add(statPnl, BorderLayout.NORTH);
        createResultPanel();
        mainPnl.add(resultPnl, BorderLayout.CENTER);
        createButtonPanel();
        mainPnl.add(buttonPnl, BorderLayout.SOUTH);
        add(mainPnl);
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void createStatPanel()
    {
        statPnl = new JPanel();
        statPnl.setLayout(new BorderLayout());
        winTF = new JTextField("0",3);
        playerWinLbl = new JLabel("Win count: "+winTF.getText());
        loseTF = new JTextField("0",3);
        playerLoseLbl = new JLabel("Loss count: "+loseTF.getText());
        tieTF = new JTextField("0",3);
        tieLbl = new JLabel("Tie count: "+tieTF.getText());
        statPnl.add(playerWinLbl, BorderLayout.NORTH);
        statPnl.add(playerLoseLbl, BorderLayout.CENTER);
        statPnl.add(tieLbl, BorderLayout.SOUTH);

    }
    private void createResultPanel()
    {
        resultPnl = new JPanel();
        resultTA = new JTextArea(10, 25);
        resultTA.setEditable(false);
        scroller = new JScrollPane(resultTA);
        resultPnl.add(scroller);

    }
    private void createButtonPanel()
    {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1, 4));
        buttonPnl.setBorder(new TitledBorder(new EtchedBorder(),"Buttons"));

        rockBtn = new JButton("Rock");
        rockPic = new ImageIcon("src/rock.png");
        rockBtn.setIcon(rockPic);
        rockBtn.addActionListener((ActionEvent ae) ->
        {
            int rndConverter = rnd.nextInt(3);
            if (rndConverter == 0)
            {
                tieCnt++;
                cntConvert = Integer.toString(tieCnt);
                tieLbl.setText("Tie Count: "+cntConvert);
                resultTA.append("Rock, tie.\n");
            }
            else if (rndConverter == 1)
            {
                loseCnt++;
                cntConvert = Integer.toString(loseCnt);
                playerLoseLbl.setText("Loss Count: "+cntConvert);
                resultTA.append("Paper, computer wins.\n");
            }
            else if (rndConverter == 2)
            {
                winCnt++;
                cntConvert = Integer.toString(winCnt);
                playerWinLbl.setText("Win Count: "+cntConvert);
                resultTA.append("Scissors, player wins.\n");
            }

        });
        paperBtn = new JButton("Paper");
        paperPic = new ImageIcon("src/paper.png");
        paperBtn.setIcon(paperPic);
        paperBtn.addActionListener((ActionEvent ae) ->
        {
            int rndConverter = rnd.nextInt(3);
            if (rndConverter == 0)
            {
                winCnt++;
                cntConvert = Integer.toString(winCnt);
                playerWinLbl.setText("Win Count: "+cntConvert);
                resultTA.append("Rock, player wins.\n");
            }
            else if (rndConverter == 1)
            {
                tieCnt++;
                cntConvert = Integer.toString(tieCnt);
                tieLbl.setText("Tie Count: "+cntConvert);
                resultTA.append("Paper, tie.\n");
            }
            else if (rndConverter == 2)
            {
                loseCnt++;
                cntConvert = Integer.toString(loseCnt);
                playerLoseLbl.setText("Loss Count: "+cntConvert);
                resultTA.append("Scissors, computer wins.\n");
            }

        });
        scissorsBtn = new JButton("Scissors");
        scissorsPic = new ImageIcon("src/scissors.png");
        scissorsBtn.setIcon(scissorsPic);
        scissorsBtn.addActionListener((ActionEvent ae) ->
        {
            int rndConverter = rnd.nextInt(3);
            if (rndConverter == 0)
            {
                loseCnt++;
                cntConvert = Integer.toString(loseCnt);
                playerLoseLbl.setText("Loss Count: "+cntConvert);
                resultTA.append("Rock, computer wins.\n");
            }
            else if (rndConverter == 1)
            {
                winCnt++;
                cntConvert = Integer.toString(winCnt);
                playerWinLbl.setText("Win Count: "+cntConvert);
                resultTA.append("Paper, player wins.\n");
            }
            else if (rndConverter == 2)
            {
                tieCnt++;
                cntConvert = Integer.toString(tieCnt);
                tieLbl.setText("Tie Count: "+cntConvert);
                resultTA.append("Scissors, tie.\n");
            }

        });
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            System.exit(0);
        });
        buttonPnl.add(rockBtn);
        buttonPnl.add(paperBtn);
        buttonPnl.add(scissorsBtn);
        buttonPnl.add(quitBtn);

    }


}
