package pro.i_it.learn.server.model;

/**
 * Created by syn on 01.03.17.
 */
public class HelloModel {
    private int count;

    public int getCount() {
        return count++;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Привет ты уже " + getCount() + " посетитель.";
    }
}
