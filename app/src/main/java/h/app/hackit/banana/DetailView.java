package h.app.hackit.banana;

import java.util.List;

public interface DetailView {
    void showProgress();

    void hideProgress();

    void setItems(List<Person> items);

    void showMessage(String message);
}
