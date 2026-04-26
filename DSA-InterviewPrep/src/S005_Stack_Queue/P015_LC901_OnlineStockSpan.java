package S005_Stack_Queue;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class StockSpanner{
    List<Integer> stock;
    public StockSpanner() {
        stock = new ArrayList<>();
    }

    public int next(int price) {
        stock.add(price);
        int size = stock.size();
        int span = 0;   //including the current one
        for(int ind = size-1; ind >= 0; ind--){
            //System.out.println(price + " " + stock.get(ind));
            if(stock.get(ind) > price) break;
            span++;
        }

        return span;
    }
}


class Pair{
    int value;
    int index;

    public Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
}

class StockSpannerOptimized {
    int index = -1;
    Stack<Pair> st;
    public StockSpannerOptimized() {
        index = -1;
        st = new Stack<>();
    }

    public int next(int price) {
        index = index+1;

        while(!st.isEmpty() && st.peek().value <= price) st.pop();
        int span = index - (st.isEmpty() ? -1 : st.peek().index);
        st.push(new Pair(price, index));
        return span;
    }
}

//https://leetcode.com/problems/online-stock-span/description/
public class P015_LC901_OnlineStockSpan {
    public static void main(String[] args){
        //call from here...
    }
}
