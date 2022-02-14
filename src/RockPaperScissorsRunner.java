import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissorsRunner extends JFrame
{
    JPanel mainPnl;
    JPanel statsPnl; //top
    JPanel displayPnl; //mid
    JPanel controlPnl; //bottom

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel playerLbl;
    JLabel computerLbl;
    JLabel tieLbl;

    //button images
    ImageIcon rockIcon;
    ImageIcon scissorsIcon;
    ImageIcon paperIcon;

    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    //array for three possible moves
    ArrayList<String> move = new ArrayList<>();

    //stats displayed
    int playerWins = 0;
    int computerWins = 0;
    int ties = 0;

    int gamesPlayed = 1;

    //player moves
    String playerMove;

    //comp moves
    String computerMove;
    Random rnd = new Random();


    public RockPaperScissorsRunner()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createStatsPanel();
        mainPnl.add(statsPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createStatsPanel()
    {
        statsPnl = new JPanel();

        playerLbl = new JLabel("Player Wins: " + playerWins + " ");

        computerLbl = new JLabel("Computer Wins: " + computerWins + " ");

        tieLbl = new JLabel("Ties: " + ties + " ");

        statsPnl.add(playerLbl);
        statsPnl.add(computerLbl);
        statsPnl.add(tieLbl);
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(15,45);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }

    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        move.add("r");
        move.add("p");
        move.add("s");

        //displayTA.append(gamesPlayed + " " + message + "\n");

        rockIcon = new ImageIcon("src/rock.png");
        rockBtn = new JButton(rockIcon);
        rockBtn.addActionListener((ActionEvent ae) ->
        {
            playerMove = "r";
            computerMove = move.get(rnd.nextInt(3));

            if(playerMove == computerMove)
            {
                displayTA.append(gamesPlayed + " Both players chose Rock (Tie)\n");
                ties++;
                tieLbl.setText("Ties: " + ties + " ");
            }
            else if(computerMove.equals("p"))
            {
                displayTA.append(gamesPlayed + " Paper covers Rock (Computer Wins)\n");
                computerWins++;
                computerLbl.setText("Computer Wins: " + computerWins + " ");
            }
            else if(computerMove.equals("s"))
            {
                displayTA.append(gamesPlayed + " Rock breaks Scissors (Player Wins)\n");
                playerWins++;
                playerLbl.setText("Player Wins:" + playerWins + " ");
            }

            gamesPlayed++;
        });

        paperIcon = new ImageIcon("src/paper.png");
        paperBtn = new JButton(paperIcon);
        paperBtn.addActionListener((ActionEvent ae) ->
        {
            playerMove = "p";
            computerMove = move.get(rnd.nextInt(3));

            if(playerMove == computerMove)
            {
                displayTA.append(gamesPlayed + " Both players chose Paper (Tie)\n");
                ties++;
                tieLbl.setText("Ties: " + ties + " ");
            }
            else if(computerMove.equals("r"))
            {
                displayTA.append(gamesPlayed + " Paper covers Rock (Player Wins)\n");
                playerWins++;
                playerLbl.setText("Player Wins:" + playerWins + " ");
            }
            else if(computerMove.equals("s"))
            {
                displayTA.append(gamesPlayed + " Scissors cuts Paper (Computer Wins)\n");
                computerWins++;
                computerLbl.setText("Computer Wins: " + computerWins + " ");
            }

            gamesPlayed++;
        });

        scissorsIcon = new ImageIcon("src/scissors.png");
        scissorsBtn = new JButton(scissorsIcon);
        scissorsBtn.addActionListener((ActionEvent ae) ->
        {
            playerMove = "s";
            computerMove = move.get(rnd.nextInt(3));

            if(playerMove == computerMove)
            {
                displayTA.append(gamesPlayed + " Both players chose Scissors (Tie)\n");
                ties++;
                tieLbl.setText("Ties: " + ties + " ");
            }
            else if(computerMove.equals("p"))
            {
                displayTA.append(gamesPlayed + " Scissors cuts Paper (Player Wins)\n");
                playerWins++;
                playerLbl.setText("Player Wins:" + playerWins + " ");
            }
            else if(computerMove.equals("r"))
            {
                displayTA.append(gamesPlayed + " Rock breaks Scissors (Computer Wins)\n");
                computerWins++;
                computerLbl.setText("Computer Wins: " + computerWins + " ");
            }

            gamesPlayed++;
        });

        quitBtn = new JButton("Quit");

        controlPnl.add(rockBtn);
        controlPnl.add(paperBtn);
        controlPnl.add(scissorsBtn);
        controlPnl.add(quitBtn);
        quitBtn.addActionListener(ActiveEvent_ae -> System.exit(0));
    }
}
