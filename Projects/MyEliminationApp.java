import java.util.*;

public class MyEliminationApp implements EliminationInterface{
	private int numPlayers;
	private int elimNumber;
	private int current = 0;
	private String lost;
	private CircularLinkedList<Integer> list;
	
	@Override
	public void init(int numPlayers, int elimNumber) {
		list = new CircularLinkedList<Integer>();
		this.numPlayers = numPlayers;
		this.elimNumber = elimNumber;
		for(int i = 0; i < numPlayers +1; i++){
			list.insert(i);
		}
		list.createCircularPath();
	}

	@Override
	public boolean currentIsWinner() {
		if(getList().getListSize() == 1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int getEliminationNumber() {
		// TODO Auto-generated method stub
		return elimNumber;
	}

	@Override
	public String getCurrentPlayerName() {
		// TODO Auto-generated method stub
		if(current == 0){
			current = 1;
		}
		return list.find(current).toString();
	}

	@Override
	 public String tick(){
        if(current>=numPlayers){
        	current=0;
        }
        while (current != elimNumber) {
        	current++;
        }
 
        lost = getList().find(current).toString(); 
        list.delete(current); 
 
        numPlayers--;
 
 
        if(currentIsWinner()){
            System.out.println("Player "+ lost + " lost and was removed from the game");
            return("Player " + getCurrentPlayerName() + " was lucky and won the game");
        }else {
            return ("Player " + lost + " lost and was removed from the gamed");
        }
    }
	
	public CircularLinkedList<Integer> getList(){
		return list;
	}
	
	 public static void main(String[] args){
	        MyEliminationApp elimination = new MyEliminationApp();
	        Random rand = new Random(System.currentTimeMillis());
	        int play = 20;
	        int number = rand.nextInt(play)+1;
	        if(number < 0){
	        	number = 1;
	        }
	        System.out.println("In this elmimination game there are: "+ play + " players");
	        elimination.init(play, number);
	        System.out.println("The elimination # is " + elimination.getEliminationNumber());
	        for(int i = 0; i <play; i++){
	            System.out.println(elimination.tick());
	        }
	 }

}
