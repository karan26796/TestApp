package h.app.hackit.banana;

public class ModelOne extends Model {
    int progress;

    public ModelOne(String textOne, String textTwo, boolean isExpanded, int progress) {
        super(textOne, textTwo, isExpanded);
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
