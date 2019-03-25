package route.com.g2holyquran.Model;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/14/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class Verse {
    String text;
    int position;

    public Verse(String text, int position) {
        this.text = text;
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
