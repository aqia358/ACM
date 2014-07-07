package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class InsertInterval {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int low = newInterval.start;
		int high = newInterval.end;
		ListIterator<Interval> iter = intervals.listIterator();
		while(iter.hasNext()){
			Interval it = iter.next();
			if(high < it.start){
				iter.previous();
				iter.add(new Interval(low, high));
				return intervals;
			}
			
			if(low > it.end){
				continue;
			}else{
				low = Math.min(low, it.start);
				high = Math.max(high, it.end);
				iter.remove();
			}
		}
		intervals.add(new Interval(low, high));
		return intervals;
	}
	public static List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
//		List<Interval> re = new ArrayList<Interval>();
		int s = 0;
		int e = intervals.size() - 1;
		Interval left = intervals.get(e--);
		Interval right = intervals.get(s++);
		while(e >= 0 && left.end >= newInterval.start){
			left = intervals.get(e--);
		}
		while(s < intervals.size() && right.end <= newInterval.end)
			right = intervals.get(s++);
		if(left.start > newInterval.end || right.end < newInterval.start)
			intervals.add(newInterval);
		else{
			if(left == right)
				left.end = Math.max(left.end, newInterval.end);
			else{
				for(int i = e; i > s; i--){
					intervals.remove(i);
				}
				left.end = right.end;
			}
		} 
		return intervals;
	}
	public static List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
//		List<Interval> re = new ArrayList<Interval>();
		int s = 0;
		int e = intervals.size() - 1;
		Interval left = null;
		Interval right = null;
		while(s <= e){
			left = intervals.get(s);
			if(left.end >= newInterval.start)
				break;
			s++;
		}
		while(s < e){
			right = intervals.get(e);
			if(right.start <= newInterval.end)
				break;
			e--;
		}
		if(s > e)
			intervals.add(newInterval);
		else{
			if(right == null || s == e)
				left.end = Math.max(left.end, newInterval.end);
			else{
				for(int i = e; i > s; i--){
					intervals.remove(i);
				}
				left.end = right.end;
			}
		} 
		return intervals;
	}
	
	public static void main(String[] args) {
		List<Interval> l = new ArrayList<Interval>();
		l.add(new Interval(1,4));
		l.add(new Interval(8,14));
		insert(l, new Interval(3,4));
	}

}
