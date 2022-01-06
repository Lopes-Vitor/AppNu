package co.tiagoaguiar.codelab.myapplication;

public class MainItem {
    private int id;
    private int drawable;
    private int color;
    private int textStringId;

    public MainItem(int id, int drawable, int textStringId, int color) {
        this.id = id;
        this.textStringId = textStringId;
        this.drawable = drawable;
        this.color = color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public int getDrawable() {
        return drawable;
    }

    public int getId() {
        return id;
    }

    public void setTextStringId(int textStringId) {
        this.textStringId = textStringId;
    }

    public int getTextStringId() {
        return textStringId;
    }
}
