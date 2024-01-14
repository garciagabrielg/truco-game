# Welcome to the game of Truco

## The game is based upon the popular game of cards in Brazil called "Truco".

#### Under construction

The idea is to implement using Java as the backend and the frontend as a webApp.

The rules are simple:
- You and the opponent get 3 cards;
- 1 Card is the "Turn" or "vira";
- If you have the face value of the card as the next value of the vira (vira +1) you have a "Manilha";
- If both players have "Manilhas", then we analize the shape in the order of strongest to weakest being:
  - Clubs, Hearts, Spades and Diamonds;
- Else, the order of the cards are, from strongest to weakest: 3, 2, A, K, J, Q, 7, 6, 5, 4.
- If one of the parties reach 2 points, then you get a round point;
- Game finishes at 15 points;
- If one the players reach 14 points, they can choose to go or not;
  - If they go and lose, the opposite party win 3 round point;
  - If they don't go, the opposite party win 1 points;
  - If they go and win, they win the game;

##### Needs to implement
- [ ] Opponent Logic;
- [ ] 14 round points logic;
- [ ] Web app.
- [ ] Correct minor bugs;
