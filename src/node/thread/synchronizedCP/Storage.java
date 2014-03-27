package node.thread.synchronizedCP;

public class Storage {

	public int curnum = 0;
	public int max_size = 100;
	
	public Storage(int curnum, int max_size){
		this.curnum = curnum;
		this.max_size = max_size;
	}
	
	public synchronized void produce(int neednum){
		while(neednum + curnum > max_size){
			try{
				Thread.sleep(1000);
				System.out.println("要生产的产品数量"+neednum+"超过剩余库存量"+(max_size - curnum)+"，暂时不能执行生产任务！");
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		curnum += neednum;
		System.out.println("已经生产了"+neednum+"个产品，现在仓储量为"+curnum);
		notify();
	}
	
	public synchronized void consume(int neednum){
		while(curnum < neednum)	{
			try{
				Thread.sleep(1000);
				System.out.println("仓储量为："+curnum+"，不够消费："+neednum);
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		curnum -= neednum;
		System.out.println("已经消费了"+neednum+"个产品，现在仓储量为"+curnum);
		notify();
	}
}
