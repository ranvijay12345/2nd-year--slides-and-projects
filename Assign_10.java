import java.util.LinkedList;



public class Assign_10 {

	public static void main(String [] args) 
		throws InterruptedException
		{
			final PC pc = new PC();
			
			//create producer thread
			Thread t1 = new Thread (new Runnable() {
				@Override 
				public void run()
				{
					try {
						pc.produce();
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			// create consumer Thread 
			Thread t2 = new Thread (new Runnable() {
				@Override 
				public void run()
				{
					try {
						 pc.consume();
					}
					catch (InterruptedException e) {
						e.printStackTrace ();
					}
				}
			});
			
			t1.start();  //start thread 1
			t2.start();  //start thread 2
			
			//t1 finishes before f2
			t1.join();
			t2.join();
		}
	//List of producer and consumer 
	
	public static class PC {
		LinkedList <Integer> list = new LinkedList<>();
		int capacity = 2;
		
		//Function called by producer thread 
		public void produce() throws InterruptedException 
		{
			int value = 0;
			while(true) {
				synchronized ( this ) {
					{
						//producer waits while thread s full
						while (list.size() == capacity)
							wait();
						
						System.out.println("Producer Produced - "+ value);
						
						list.add( value++ );
						
						notify();
						
						Thread.sleep(2000);
					}
				}
			}
		}
			
			// Function called by consumer 
			public void consume() throws InterruptedException 
			{ 
				while ( true ) {
					synchronized ( this )
					{
						//consumer wait while list is empty 
						while (list.size() == 0) 
						{
							wait();
						}
						
						int val = list.removeFirst();
						
						System.out.println("Consumer Consumed - "+ val);
						
						notify();
						
						Thread.sleep(2000);
					}
				}
				
			}
		}
	}
