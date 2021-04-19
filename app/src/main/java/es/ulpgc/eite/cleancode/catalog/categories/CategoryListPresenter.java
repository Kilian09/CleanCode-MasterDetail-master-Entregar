package es.ulpgc.eite.cleancode.catalog.categories;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;

public class CategoryListPresenter implements CategoryListContract.Presenter {

    public static String TAG = CategoryListPresenter.class.getSimpleName();

    private WeakReference<CategoryListContract.View> view;
    private CategoryListState state;
    private CategoryListContract.Model model;
    private CatalogMediator mediator;

    public CategoryListPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCategoryListState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new CategoryListState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        /*
        // use passed state if is necessary
        PreviousToCategoryListState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }
         */

    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        /*
        // use passed state if is necessary
        NextToCategoryListState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }
*/

          // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }
/*
    private NextToCategoryListState getStateFromNextScreen() {
        return mediator.getNextCategoryListScreenState();
    }

    private void passStateToNextScreen(CategoryListToNextState state) {
        mediator.setNextCategoryListScreenState(state);
    }

    private void passStateToPreviousScreen(CategoryListToPreviousState state) {
        mediator.setPreviousCategoryListScreenState(state);
    }

    private PreviousToCategoryListState getStateFromPreviousScreen() {
        return mediator.getPreviousCategoryListScreenState();
    }
*/
    @Override
    public void injectView(WeakReference<CategoryListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CategoryListContract.Model model) {
        this.model = model;
    }

}
