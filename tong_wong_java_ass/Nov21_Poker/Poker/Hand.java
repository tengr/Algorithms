import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Hand implements Comparable<Hand>{
	public ArrayList<Card> cards;
	private int size;
	private int[] ranks;
	private boolean isStraight;
	private boolean isFlush;
	private static enum Classification{
		StraightFlush, FourOfAKind, FullHouse, Flush, Straight, ThreeOfAKind, TwoPair, OnePair, HighCard
	};
	private Classification classification;
	
	private static enum Key{
		Four, Three, BiggerTwo, SmallerTwo
	}
	
	private HashMap<Key, Card> config;

	
	public Hand(ArrayList<Card> cards){
		Collections.sort(cards);
		this.cards = cards;
		this.size = cards.size();
		this.setState();
	}
	
	public boolean isFlush(){
		return this.isFlush;
	}
	
	public boolean isStraight() {
		return this.isStraight;
	}
		
	public void setState(){
		this.CheckIsStraight();
		this.CheckIsFlush();
		this.CheckNOfAKind();
		if(this.isStraight && this.isFlush) {
			this.classification = Classification.StraightFlush;
		}
		else if(this.isStraight) { 
			this.classification = Classification.Straight;
		}
		else if(this.isFlush) {
			this.classification = Classification.Flush;
		}
		else if (this.config.containsKey(Key.Four)) {
			this.classification = Classification.FourOfAKind;
		}
		else if (this.config.containsKey(Key.Three)) {
			if(this.config.containsKey(Key.BiggerTwo)) {
				this.classification = Classification.FullHouse;
			}
			else {
				this.classification = Classification.ThreeOfAKind;
			}
		}
		else if(this.config.containsKey(Key.BiggerTwo)){
			if(this.config.containsKey(Key.SmallerTwo)) {
				this.classification = Classification.TwoPair;
			}
			else {
				this.classification = Classification.OnePair;
			}
		}
		else {
			this.classification = Classification.HighCard;
		}
	}
	
	
	public void CheckIsStraight(){
		for(int i = 0; i < this.size - 1; i++) {
			if(cards.get(i + 1).getRank() != cards.get(i).getRank() + 1) {
				this.isStraight = false;
				return;
			}
		}
		this.isStraight = true;
	}
	
	public void CheckIsFlush(){
		for(int i = 0; i < this.size - 1; i++) {
			if(!cards.get(i + 1).getSuit().equals(cards.get(i).getSuit())) {
				this.isFlush = false;
				return;
			}
		}
		this.isFlush = true;
	}
	
	public void CheckNOfAKind(){
		this.ranks = new int[this.size];
		this.config = new HashMap<Key, Card>();
		for(int i = 0; i < this.ranks.length; i++){
			this.ranks[i] = cards.get(i).getRank(); //first 5 bits are the ranks
		}
		//no need to go forward if is straight
		if (this.isStraight) {
			return;
		}

		int num = 1;
		for(int i = this.size - 1; i >= 0; i--) {
			Card thisCard = cards.get(i);
			if(i == 0 || thisCard.getRank() != cards.get(i - 1).getRank()){
				//more than one of a kind
				if (num > 1){				
					if(num == 4){
						this.config.put(Key.Four, thisCard);
					}
					else if(num == 3) {
						this.config.put(Key.Three, thisCard);
					}
					else if(num == 2){
						if(this.config.containsKey(Key.BiggerTwo)){
							this.config.put(Key.SmallerTwo, thisCard);
						}
						else this.config.put(Key.BiggerTwo, thisCard);
					}
					num = 1;
				}
			}
			else{
				//equal
				num++;
			}
		}
	}
	
	@Override
	public int compareTo(Hand anotherHand) {
		if(this.classification.ordinal() != anotherHand.classification.ordinal()){
			return (new Integer(this.classification.ordinal()).compareTo(anotherHand.classification.ordinal())) * (-1);
		}
		else{
			for(Key key : Key.values()){
				//System.out.println(key);
				if(this.config.containsKey(key) && anotherHand.config.containsKey(key)) {
					if(this.config.get(key).getRank() != anotherHand.config.get(key).getRank()) {
						return new Integer(this.config.get(key).getRank()).compareTo(anotherHand.config.get(key).getRank());
					}
				}
			}
			for(int i = this.ranks.length - 1; i >= 0; i-- ){
				if(this.ranks[i] != anotherHand.ranks[i]) {
					return new Integer(this.ranks[i]).compareTo(anotherHand.ranks[i]);
				}
			}
		}
		return 0;
	}

	@Override
    public  String toString() {
    	switch(this.classification){
	    	case StraightFlush:
	            	return this.cards.get(cards.size() - 1).rank + "-high straight flush";
			case Flush:
					return this.cards.get(cards.size() - 1).rank + "-high flush";
			case FourOfAKind:
					return "Four " + this.config.get(Key.Four).rank + "s";
			case FullHouse:
					return this.config.get(Key.Three).rank + "s full of " + this.config.get(Key.BiggerTwo).rank + "s";
			case HighCard:
					return this.cards.get(cards.size() - 1).rank + "-high";
			case OnePair:
					return "Pair of " + this.config.get(Key.BiggerTwo).rank + "s"; 
			case Straight:
					return  this.cards.get(cards.size() - 1).rank + "-high straight";
			case ThreeOfAKind:
					return "Three " + this.config.get(Key.Three).rank + "s";
			case TwoPair:
					return this.config.get(Key.BiggerTwo).rank + "s over " + this.config.get(Key.SmallerTwo).rank + "s";
			default:
				return null;
	    	}    	
    }
}
