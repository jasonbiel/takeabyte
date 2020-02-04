package co.za.takeabyte.gradalot2020.productdescription;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProvider;

import co.za.takeabyte.gradalot2020.R;
import co.za.takeabyte.gradalot2020.productdescription.viewmodel.ViewModelProductDescription;

//TODO: Price information needs to be added.

public class ProductDescriptionActivity extends AppCompatActivity implements IProductDescriptionView {

    public static final String PRODUCT_DESCRIPTION_BUNDLE = "pdp_bundle";
    public static final String PRODUCT_DESCRIPTION_TITLE = "pdp_bundle_title";
    public static final String PRODUCT_DESCRIPTION_IMAGE = "pdp_bundle_image";
    public static final String PRODUCT_DESCRIPTION_TRANSITION_NAME = "pdp_bundle_transition_name";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_description_layout);

        ViewModelProductDescription viewModelProductDescription = new ViewModelProvider(this).get(ViewModelProductDescription.class);

        getLifecycle().addObserver(viewModelProductDescription);

        viewModelProductDescription.setContext(this);
        viewModelProductDescription.setDataBundle(getIntent().getBundleExtra(PRODUCT_DESCRIPTION_BUNDLE));

        setupSharedElementTransition();
    }

    @Override
    public void renderImage(int imageRes) {
        ImageView imageView = findViewById(R.id.pdpParentCarouselImage);
        if (imageView != null) {
            imageView.setImageResource(imageRes);
        }
    }

    @Override
    public void renderTitle(String title) {
        TextView textView = findViewById(R.id.pdpParentTitle);
        if (textView != null) {
            textView.setText(title);
        }
    }

    private void setupSharedElementTransition() {
        Bundle bundle = getIntent().getBundleExtra(PRODUCT_DESCRIPTION_BUNDLE);

        if (bundle != null) {
            String transitionName = bundle.getString(PRODUCT_DESCRIPTION_TRANSITION_NAME);

            if (transitionName != null) {
                getWindow().setSharedElementEnterTransition(
                        TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition_image));

                ViewCompat.setTransitionName(
                        findViewById(R.id.pdpParentCarouselImage),
                        transitionName);
            }
        }
    }
}
