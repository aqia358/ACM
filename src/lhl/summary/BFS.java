package lhl.summary;

import java.util.List;
import java.util.Set;


/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start
 * to end, such that:
 * • Only one letter can be changed at a time
 * • Each intermediate word must exist in the dictionary
 * For example, Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 *	 ["hit","hot","dot","dog","cog"],
 *	 ["hit","hot","lot","log","cog"]
 * ]
 * @author aqia358
 *
 */
public interface BFS {

	public List<List<String>> findLadders(String start, String end, Set<String> dict);
}
