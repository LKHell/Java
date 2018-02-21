import sun.jvm.hotspot.utilities.Interval;

// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
  public List<Interval> merge(List<Interval> intervals) {
      if(intervals.size() <= 1) {
        return intervals;
      }

      intervals.sort((i1,i2) -> Integer.compare(i1.start, i2.start));
      //lambda expression
      
      List<Interval> ans = new LinkedList<>();
      int start = intervals.get(0).start;
      int end = intervals.get(0).end;

      for (Interval i : intervals) {
        if ( i.start <= end) {
          end = Math.max(end, i.end);
        }
        else {
          ans.add(new Interval(start, end));
          start = i.start;
          end = i.end;
        }
      }
      ans.add(new Interval(start, end));
      return ans;
  }
}

//

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    // sort start&end
    int n = intervals.size();
    int[] starts = new int[n];
    int[] ends = new int[n];
    for (int i = 0; i < n; i++) {
      starts[i] = intervals.get(i).start;
      ends[i] = intervals.get(i).end;
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    // loop through
    List<Interval> res = new ArrayList<Interval>();
    for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
      if (i == n - 1 || starts[i + 1] > ends[i]) {
        res.add(new Interval(starts[j], ends[i]));
        j = i + 1;
      }
    }
    return res;
  }
}