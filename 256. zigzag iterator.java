/*
Given two 1d vectors, implement an iterator to return their elements alternately.
For example, given two 1d vectors:
v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
*/

public class ZigzagIterator {  
    List<Iterator<Integer> > iters = new ArrayList<Iterator<Integer> >();   
      
    int count = 0;  
  
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {  
        if( !v1.isEmpty() ) iters.add(v1.iterator());  
        if( !v2.isEmpty() ) iters.add(v2.iterator());  
    }  
  
    public int next() {  
        int x = iters.get(count).next();  
        if(!iters.get(count).hasNext()) iters.remove(count);  
        else count++;  
          
        if(iters.size()!=0) count %= iters.size();  
        return x;  
    }  
  
    public boolean hasNext() {  
        return !iters.isEmpty();  
    }  
}  

