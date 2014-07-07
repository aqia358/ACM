package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> re = new ArrayList<Interval>();
		for(Interval t : intervals)
			indsert(re, t);
		return re;
	}

	public static void indsert(List<Interval> intervals, Interval a) {
		ListIterator<Interval> iter = intervals.listIterator();
		int start = a.start;
		int end = a.end;
		while (iter.hasNext()) {
			Interval t = iter.next();
			if (a.end < t.start) {
				iter.previous();
				iter.add(new Interval(start, end));
				return;
			} else {
				if(a.start <= t.end){
					start = Math.min(start, t.start);
					end = Math.max(end, t.end);
					iter.remove();
				}
			}
		}
		intervals.add(new Interval(start, end));
	}

	public static void main(String[] args) {
		List<Interval> l = new ArrayList<Interval>();
		l.add(new Interval(1, 4));
		l.add(new Interval(5, 6));
//		l.add(new Interval(3, 5));
		// l.add(new Interval(15,18));
		merge(l);
	}

}

class Interval {
	int start;
	int end;

	public Interval() {
		start = 0;
		end = 0;
	}

	public Interval(int s, int e) {
		start = s;
		end = e;
	}
}
