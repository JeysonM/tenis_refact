
public class TennisGame2 implements TennisGame
{    
		private static final int _Love = 0;
		private static final int _Fifteen = 1;
		private static final int _Thirty = 2;
		private static final int _Forty = 3;
		
		public int player1Points = 0;
	    public int player2Points = 0;
	    
	    public String statePlayer1 = "";
	    public String statePlayer2 = "";

	    public String convertScoreToLiteral(){
	        String literalScore = "";
	        literalScore = isTiedNotDeuce(literalScore);
	        literalScore = isDeuce(literalScore);	        
	        literalScore = player2orPlayer1isWinning(literalScore);
	        literalScore = player2orPlayer1WiningNotDeuce(literalScore);         
	        literalScore = advantagePlayer2orPlayer1(literalScore);	        
	        literalScore = winForPlayer1orPlayer2(literalScore);
	        return literalScore;
	    }

		private String winForPlayer1orPlayer2(String literalScore) {
			
			if (setAfterDeuceAndPlayer2HaveTwoPoints())
	            literalScore="Win for player2";
			if (setAfterDeuceAndPlayer1HaveTwoPoints())
	            literalScore = "Win for player1";		
			return literalScore;
		}

		private boolean setAfterDeuceAndPlayer1HaveTwoPoints() {
			return player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2;
		}

		private boolean setAfterDeuceAndPlayer2HaveTwoPoints() {
			return player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=2;
		}
		private String advantagePlayer2orPlayer1(String literalScore) {
			if (player2HaveAdvantage())
	            literalScore = "Advantage player2";
			if (player1haveAdvantage())
	            literalScore = "Advantage player1";
			return literalScore;
		}

		private boolean player1haveAdvantage() {
			return player1isBiggerThanPlayer2() && player2Points >= 3;
		}

		private boolean player2HaveAdvantage() {
			return player2isBiggerThanPlayer1() && player1Points >= 3;
		}

		private String player2orPlayer1WiningNotDeuce(String literalScore) {
			if (player2isBiggerThanPlayer1() && setNotEndFor(player2Points))
	        {
				statePlayer2 = returnStatePlayer(player2Points);
				statePlayer1 = returnStatePlayer(player1Points);
	            literalScore = statePlayer1 + "-" + statePlayer2;
	        }
			if (player1isBiggerThanPlayer2() && setNotEndFor(player1Points))
	        {
				statePlayer1 = returnStatePlayer(player1Points);
				statePlayer2 = returnStatePlayer(player2Points);
	            literalScore = statePlayer1 + "-" + statePlayer2;
	        }
			return literalScore;
		}

		private boolean setNotEndFor(int player) {
			return player < 4;
		}

		private boolean player1isBiggerThanPlayer2() {
			return player1Points>player2Points;
		}

		private boolean player2isBiggerThanPlayer1() {
			return player2Points>player1Points;
		}
		
		private String player2orPlayer1isWinning(String literalScore) {
			if (player2isBiggerThanPlayer1AndPlayer1isLove())
	        {
				statePlayer2 = returnStatePlayer(player2Points);
	            literalScore = statePlayer1 + "-" + statePlayer2;
	        }
			if (player1isBiggerThanPlayer2AndPlayer2isLove())
	        {
				statePlayer1 = returnStatePlayer(player1Points);
	            literalScore = statePlayer1 + "-" + statePlayer2;
	        }
			return literalScore;
		}

		private boolean player1isBiggerThanPlayer2AndPlayer2isLove() {
			return player1Points > 0 && player2Points==0;
		}

		private boolean player2isBiggerThanPlayer1AndPlayer1isLove() {
			return player2Points > 0 && player1Points==0;
		}
		
		private String returnStatePlayer(int playerPoints) {
			String state = "";
			if (playerPoints==_Love)
			    state = "Love";
			if (playerPoints==_Fifteen)
			    state = "Fifteen";
			if (playerPoints==_Thirty)
			    state = "Thirty";
			if (playerPoints==_Forty)
			    state = "Forty";
			return state;
		}

		private String isDeuce(String literalScore) {
			if (player1PointsEqualsPlayer2points() && player1Points>=3)
	            literalScore = "Deuce";
			return literalScore;
		}

		private String isTiedNotDeuce(String literalScore) {
			if (player1PointsEqualsPlayer2points() && player1Points < 4)
	        {
				literalScore = returnStatePlayer(player1Points);
	            literalScore += "-All";
	        }
			return literalScore;
		}

		private boolean player1PointsEqualsPlayer2points() {
			return player1Points == player2Points;
		}
	    
	    public void SetP1Score(int number){
	        
	        for (int i = 0; i < number; i++)
	        {
	            P1Score();
	        }
	            
	    }
	    
	    public void SetP2Score(int number){
	        
	        for (int i = 0; i < number; i++)
	        {
	            P2Score();
	        }
	            
	    }
	    
	    public void P1Score(){
	        player1Points++;
	    }
	    
	    public void P2Score(){
	        player2Points++;
	    }

	    public void wonPoint(String player) {
	        if (player == "player1")
	            P1Score();
	        else
	            P2Score();
	    }
}