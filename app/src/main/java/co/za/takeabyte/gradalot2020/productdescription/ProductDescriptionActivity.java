package co.za.takeabyte.gradalot2020.productdescription;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import co.za.takeabyte.gradalot2020.R;
import co.za.takeabyte.gradalot2020.productdescription.viewmodel.ViewModelProductDescription;

public class ProductDescriptionActivity extends AppCompatActivity implements IProductDescriptionView {

    public static final String PRODUCT_DESCRIPTION_BUNDLE = "pdp_bundle";
    public static final String PRODUCT_DESCRIPTION_TITLE = "pdp_bundle_title";
    public static final String PRODUCT_DESCRIPTION_IMAGE = "pdp_bundle_image";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_description_layout);

        ViewModelProductDescription viewModelProductDescription = new ViewModelProvider(this).get(ViewModelProductDescription.class);

        getLifecycle().addObserver(viewModelProductDescription);

        viewModelProductDescription.setContext(this);
        viewModelProductDescription.setDataBundle(getIntent().getBundleExtra(PRODUCT_DESCRIPTION_BUNDLE));
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
}
