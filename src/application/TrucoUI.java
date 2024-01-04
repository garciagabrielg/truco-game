package application;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import truco.TrucoMatch;

public class TrucoUI extends JFrame{
	private TrucoMatch trucoMatch;
	
	private JLabel playerGamePointsLabel;
	private JLabel opponentGamePointsLabel;
	private JLabel playerRoundPointsLabel;
	private JLabel opponentRoundPointsLabel;
	private JLabel playerHandLabel;
	private JLabel opponentHandLabel;
	private JButton playCardButton;
	
	public TrucoUI() {
		trucoMatch = new TrucoMatch();
		
		setTitle("Truco game ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setLayout(new BorderLayout());
		
	}
	
	private void setupUI() {
		playerRoundPointsLabel = new JLabel("Player Points: " + trucoMatch.getPlayer().getPlayerRoundPoints());
		playerGamePointsLabel = new JLabel("Player Game Points: " + trucoMatch.getPlayer().getPlayerGamePoints());
		opponentRoundPointsLabel = new JLabel("Opponent Points" + trucoMatch.getOpponent().getOpponentRoundPoints());
		opponentGamePointsLabel = new JLabel("Opponent Game Points: " + trucoMatch.getOpponent().getOpponentGamePoints());
		playerHandLabel = new JLabel("Player Hand: " + trucoMatch.getPlayer().getHand());
		opponentHandLabel = new JLabel("Opponent Hand: " + trucoMatch.getOpponent().getHand());
		
		playCardButton = new JButton("Play Card");
		playCardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(4,1));
		infoPanel.add(playerRoundPointsLabel);
		infoPanel.add(opponentRoundPointsLabel);
		infoPanel.add(playerGamePointsLabel);
		infoPanel.add(opponentGamePointsLabel);
		infoPanel.add(playerHandLabel);
		infoPanel.add(opponentHandLabel);
		
		add(infoPanel, BorderLayout.CENTER);
		add(playCardButton, BorderLayout.SOUTH);

	}
	private void playCard() {
		trucoMatch.getPlayer().playCard(trucoMatch.getPlayer().getPlayerCardOnTheTable());
		trucoMatch.getOpponent().opponentPlayedCard();
		updateUI();
		}
	
	private void updateUI() {
		playerRoundPointsLabel.setText("Player Points: " + trucoMatch.getPlayer().getPlayerRoundPoints());
		playerGamePointsLabel.setText("Player Game Points: " + trucoMatch.getPlayer().getPlayerGamePoints());
		opponentRoundPointsLabel.setText("Opponent Points" + trucoMatch.getOpponent().getOpponentRoundPoints());
		opponentGamePointsLabel.setText("Opponent Game Points: " + trucoMatch.getOpponent().getOpponentGamePoints());
		playerHandLabel.setText("Player Hand: " + trucoMatch.getPlayer().getHand());
		opponentHandLabel.setText("Opponent Hand: " + trucoMatch.getOpponent().getHand());
	}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TrucoUI().setVisible(true);
            }
        });
    }

}
