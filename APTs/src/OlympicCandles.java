import java.util.ArrayList;
import java.util.PriorityQueue;

public class OlympicCandles{
   public int numberOfNights(int[] candles){
      // write code
	   PriorityQueue<Integer> candleQueue=new PriorityQueue<Integer>();
	   	   for(int t:candles){
		   candleQueue.add(-t);
	   }
	   int night=0;	   
	   if(candleQueue.peek()<0)
		   night=1;
	   
	   while(!candleQueue.isEmpty()){	   
	   ArrayList<Integer> usedcandles=new ArrayList<Integer>();  
	   for(int i=0;i<night;i++){		   
		   usedcandles.add(candleQueue.remove()+1);
	   }
	   candleQueue.addAll(usedcandles);
	   
	   night++;
	   }
	   return night;
   }
 }