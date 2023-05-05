
public class Counter {
	private PowerSet<Card> cardps;
	private Card starter;
	
	public Counter(Card[] hand, Card starter) {
	    // initializing the starter and the powerSet
		this.starter = starter;
	    cardps = new PowerSet<>(hand);

        
    } // method Counter - constructor
	
	
	public int countPoints() {
		int score = 0;
		
		
		// looping through all powerSets
		// this will be used to run through all power sets for fifteen, pairs, his knobs, and flushes
		for(int i = 0; i < cardps.getLength(); i++) { 
			// subset is made to make the code much more readable and efficient
			Set<Card> subset = cardps.getSet(i);
			
			// PAIRS - 2 points each
			int pairScore = 0;
			
			 // must only be done with a combination of 2 cards
			if (subset.getLength() ==  2) {
				// if both cards have the same number
				if (subset.getElement(0).getLabel().equals(subset.getElement(1).getLabel())) {
						pairScore += 2;
				} // if
				score += pairScore;
			} // if limit
			
		

			// FIFTEEN - 2 points per sum of 15
			int totalValue = 0;
			
			// loops through whole set, checks if the numbers add to 15
			for (int j = 0; j < subset.getLength(); j++) { 
				totalValue += subset.getElement(j).getFifteenRank();
			}  // for 
			
			if (totalValue ==  15) {
				score += 2;
			} // if
			
			
			
			// FLUSH - 4 points for full hand, 5 for whole group
			// only checking the power set with all the cards (5)
			if(subset.getLength() ==  5) { 
				// flushType sets the standard - the other cards must have the same suit as flushType
				String flushType = subset.getElement(0).getSuit();
				int count = 0;
				
				// checks if the cards hold the same suit
				for(int j = 0; j < 4; j++) {
					 if(flushType ==  subset.getElement(j).getSuit()) {
						 count += 1;
					 } // if
				} // for j
				
				// if the starter also has the same suit as the first 4 cards, award 5 points
				if(starter.getSuit() ==  flushType && count ==  4) {
					score += 5;
				} // if
				
				// if the hand (the first 4 cards) hold the same suit
				else if (count ==  4) {
					score += 4;
				}
			} // if 5
			
			
			
			// HIS KNOBS - 1 point maximum
			// must be done with the combination of all the cards
			if(subset.getLength() ==  5) { 
				int knobScore = 0;
				
				// goes card by card checking to see if there is a jack
				for(int j = 0; j < 5; j++) {
					if (subset.getElement(j).getLabel() ==  "J") {
						// checks if the jack card has the same suit as the starter card
						if(subset.getElement(j).getSuit() ==  starter.getSuit()) { 
							score += 1;
						} // if	
					} // if
				} // for j
			} // if 
		
		
		} // for i - the all-encapsulating for-loop
		
		
		
		//RUNS - awards points per longest streak (minimum 3)
		int runScore = 0;
		int longestRun = 0;
		
		// same for loop to the one at the top of this file
		for(int i = 0; i < cardps.getLength(); i++) {
			Set<Card> subset = cardps.getSet(i);
			
			// if a run is found
	        if (subset.getLength() >=  3 && isRun(subset)) { 
	        	// record if its the longest run
	        	if(subset.getLength() > longestRun) {
	        		longestRun = subset.getLength();
	        		runScore = subset.getLength();
	        	} // if
	        	
	        	// if its not the longest run, add the points
	        	else if(subset.getLength() ==  longestRun) {
	        		runScore = runScore + subset.getLength();
	        	} // else if
	        }// if
        } // for i
        score += runScore;
        
        
        //finally, return the final score 
		return score;
		
	} // method count points

	
	
	// IS RUN, given in the assignment and used at the very bottom of countPoints
	private boolean isRun (Set<Card> set) {
		
		int n = set.getLength();
		
		if (n <= 2) return false; // Run must be at least 3 in length.
		
		int[] rankArr = new int[13];
		for (int i = 0; i < 13; i++) rankArr[i] = 0; // Ensure the default values are all 0.
		
		for (int i = 0; i < n; i++) {
			rankArr[set.getElement(i).getRunRank()-1] += 1;
		}

		// Now search in the array for a sequence of n consecutive 1's.
		int streak = 0;
		int maxStreak = 0;
		for (int i = 0; i < 13; i++) {
			if (rankArr[i] ==  1) {
				streak++;
				if (streak > maxStreak) maxStreak = streak;
			} else {
				streak = 0;
			}
		}
		if (maxStreak ==  n) { // Check if this is the maximum streak.
			return true;
		} else {
			return false;
		}

	} // method isRun
	
	
} // class counter
