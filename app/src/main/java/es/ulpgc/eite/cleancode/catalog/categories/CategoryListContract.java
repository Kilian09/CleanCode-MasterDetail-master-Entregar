package es.ulpgc.eite.cleancode.catalog.categories;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public interface CategoryListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(CategoryListViewModel viewModel);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void onResume();

        void onStart();

        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();
    }

    interface Model {

        List<ProductItem> fetchProductListData();
    }

}
