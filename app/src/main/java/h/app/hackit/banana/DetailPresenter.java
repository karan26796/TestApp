package h.app.hackit.banana;

import java.util.List;

public class DetailPresenter {
    private DetailView detailView;
    private FindItemsInteractor interactor;

    public DetailPresenter(DetailView detailView, FindItemsInteractor interactor) {
        this.detailView = detailView;
        this.interactor = interactor;
    }

    void onResume() {
        if (detailView != null) {
            detailView.showProgress();
        }

        interactor.findItems((FindItemsInteractor.OnFinishedListener) this);
    }

    void onItemClicked(String item) {
        if (detailView != null) {
            detailView.showMessage(String.format("%s clicked", item));
        }
    }

    void onDestroy() {
        detailView = null;
    }

    public void onFinished(List<Person> items) {
        if (detailView != null) {
            detailView.setItems(items);
            detailView.hideProgress();
        }
    }

    public DetailView getMainView() {
        return detailView;
    }
}
