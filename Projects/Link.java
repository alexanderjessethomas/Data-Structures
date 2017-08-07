public class Link {
    private int data;
    private Link next; 
    private Link down;
    
    public Link(){
        data = 0;
        next = null;
        down = null;
    }
    
    public void displayLink(){
        System.out.print(data + " ");
    }
    
    public void setData(int d){
        data = d;
    }
    
    public void setNext(Link n){
        next = n;
    }
    
    public void setDown(Link d){
        down = d;
    }
    
    public int getData(){
        return data;
    }
    
    public Link getNext(){
        return next;
    }
    
    public Link getDown(){
        return down;
    }
     
}