package edu.lernia.labb5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class YatziTest {
	Die[] dice = new Die[5];
		
    @Test
    void isYatziWhenAllDiceMatches() {    	       
        for(int i = 0; i < 5; i++) {
            dice[i] = new Die();        
            dice[i].value = 6;
        } 

        boolean yatzi = true;
        
        for(int j = 1; j < 5; j++) {
        	if(dice[j].value != dice[j-1].value) {
        		yatzi = false;
        		break;
        	}
        }
                
        assertEquals(yatzi, true);
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        for(int i = 0; i < 5; i++) {
            dice[i] = new Die();        
            dice[i].value = 6;
        }
        dice[1].value = 1;

        boolean yatzi = true;
        
        for(int j = 1; j < 5; j++) {
        	if(dice[j].value != dice[j-1].value) {
        		yatzi = false;
        		break;
        	}
        }
	    
	    assertEquals(yatzi, false);
    }
}