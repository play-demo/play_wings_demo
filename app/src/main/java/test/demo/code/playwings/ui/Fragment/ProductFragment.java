package test.demo.code.playwings.ui.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;
import test.demo.code.playwings.R;
import test.demo.code.playwings.data.Realm.Beers;

public class ProductFragment extends Fragment {
    Listener listener;

    private static final String PRODUCT_ID = "test.demo.code.playwings.ui.Fragment.ProductFragment.PRODUCT_ID";
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_tag_line)
    TextView tvTagLine;
    @BindView(R.id.first_brewed)
    TextView firstBrewed;
    @BindView(R.id.tv_abv)
    TextView tvAbv;
    @BindView(R.id.tv_ibu)
    TextView tvIbu;
    @BindView(R.id.tv_srm)
    TextView tvSrm;
    @BindView(R.id.tv_attenuation)
    TextView tvAttenuation;
    @BindView(R.id.tv_ph)
    TextView tvPh;
    @BindView(R.id.iv_product)
    ImageView ivProduct;

    public static ProductFragment newInstance(int id) {
        Bundle args = new Bundle();
        ProductFragment fragment = new ProductFragment();
        args.putInt(PRODUCT_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        try {
            listener = (Listener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement " + Listener.class);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this, view);
        RealmResults<Beers> puppies = Realm.getDefaultInstance().where(Beers.class).equalTo("id", getArguments().getInt(PRODUCT_ID)).findAll();
        Beers data = puppies.get(0);
        Glide.with(getActivity()).load(data.getImageUrl()).into(ivProduct);
        tvName.setText(data.getName());
        tvAbv.setText(String.valueOf(data.getAbv()));
        tvAttenuation.setText(String.valueOf(data.getAttenuation_level()));
        tvIbu.setText(String.valueOf(data.getIbu()));
        tvPh.setText(String.valueOf(data.getPh()));
        tvSrm.setText(String.valueOf(data.getSrm()));
        tvTagLine.setText(data.getTagline());
        firstBrewed.setText(data.getFirstBrewed());
        return view;
    }

    @OnClick(R.id.btn_payment)
    public void onViewClicked() {
        listener.buyProduct();
    }

    public interface Listener {
        void buyProduct();
    }
}
