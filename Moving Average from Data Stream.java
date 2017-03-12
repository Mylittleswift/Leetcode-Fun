/**
*Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

class MovingAverage {

  public MovingAverage(int size) {

  }

  public double next(int val) {

  }
}
For example,

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/


//solution 1: O(1) time
public class MovingAverage {
    private int [] window;
    private int n, insert;
    private long sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }
    
    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;        
        return (double)sum / n;
    }
}


// solution 2: queue

public class MovingAverage {
    private int size;
    private int sum;
    private Queue<Integer> window;

    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.window = new ArrayDeque<>();
    }

    public double next(int val) {
        window.offer(val);
        if (window.size() > size) {
            sum -= window.poll();
        }
        sum += val;
        return (double) sum / window.size();
    }
}
