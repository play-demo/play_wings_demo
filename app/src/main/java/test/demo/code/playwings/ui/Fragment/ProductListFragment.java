package test.demo.code.playwings.ui.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.demo.code.playwings.Constants;
import test.demo.code.playwings.R;
import test.demo.code.playwings.data.Gson.GsBeers;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL;
import static test.demo.code.playwings.Constants.URL.BEER_API_URL;
import static test.demo.code.playwings.Constants.importFromJson;

public class ProductListFragment extends Fragment {
    Listener listener;
    @BindView(R.id.product_rv)
    RecyclerView productRv;
    @BindView(R.id.progress)
    CardView progress;
    private int page = 1;

    private boolean filter = false;
    private ProductRvAdapter productRvAdapter;
    List<GsBeers> beersItem = new ArrayList<>();

    public static ProductListFragment newInstance() {
        Bundle args = new Bundle();
        ProductListFragment fragment = new ProductListFragment();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        productRv.setLayoutManager(lm);
        productRvAdapter = new ProductRvAdapter();
        productRvAdapter.setLinearLayoutManager(lm);
        productRv.setAdapter(productRvAdapter);
        productRvAdapter.setRecyclerView(productRv);
        page = 1;
        loadBeer();
        return view;
    }

    private void loadBeer() {

        Constants.URL.RetrofitService service = BEER_API_URL.getRetroService();
        Call<String> Repos = service.beerData(page);
        Repos.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                String data = response.body();
                Log.e("데이터 체크!!", response.body());
                try {
                    importFromJson(data);
                    List<GsBeers> beers = new Gson().fromJson(data, new TypeToken<List<GsBeers>>() {
                    }.getType());
                    if (beers.size() != 0) {
                        if (filter) {
                            beersItem.clear();
                            filter = false;
                        }
                        beersItem.addAll(beers);
                        productRvAdapter.notifyDataSetChanged();
                        productRvAdapter.setMoreLoading();
                    }
                    progress.setVisibility(View.GONE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
            }
        });
    }


    @OnClick({R.id.abv_up, R.id.abv_down, R.id.ibu_up, R.id.ibu_down, R.id.name_up, R.id.date_up, R.id.date_down, R.id.no_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.abv_up:
                numDialog("abv_gt");
                break;
            case R.id.abv_down:
                numDialog("abv_lt");
                break;
            case R.id.ibu_up:
                numDialog("ibu_gt");
                break;
            case R.id.ibu_down:
                numDialog("ibu_lt");
                break;
            case R.id.name_up:
                nameDialog();
                break;
            case R.id.date_up:
                dateDialog("brewed_before");
                break;
            case R.id.date_down:
                dateDialog("brewed_after");
                break;
            case R.id.no_filter:
                page = 1;
                loadBeer();
                break;
        }
    }

    private void numDialog(final String filter) {
        this.filter = true;
        final EditText editText = new EditText(getActivity());
        editText.setInputType(TYPE_CLASS_NUMBER);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("수치입력");
        builder.setView(editText);
        builder.setPositiveButton("선택",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Constants.URL.RetrofitService service = BEER_API_URL.getRetroService();
                        Map<String, Integer> map = new HashMap<>();
                        map.put(filter, Integer.parseInt(editText.getText().toString()));
                        Call<String> Repos = service.filterDoubleBeerData(map);
                        Log.e("확인", Repos.toString());
                        Repos.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                                String data = response.body();
                                Log.e("데이터 체크!!", response.body());
                                try {
                                    importFromJson(data);
                                    List<GsBeers> beers = new Gson().fromJson(data, new TypeToken<List<GsBeers>>() {
                                    }.getType());
                                    beersItem.clear();
                                    beersItem = beers;
                                    productRvAdapter.notifyDataSetChanged();
                                    progress.setVisibility(View.GONE);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                            }
                        });
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    private void nameDialog() {
        this.filter = true;
        final EditText editText = new EditText(getActivity());
        editText.setInputType(TYPE_CLASS_TEXT);
        editText.setSingleLine();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("맥주 이름");
        builder.setView(editText);
        builder.setPositiveButton("입력",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Constants.URL.RetrofitService service = BEER_API_URL.getRetroService();
                        Map<String, String> map = new HashMap<>();
                        map.put("beer_name", editText.getText().toString());
                        Call<String> Repos = service.filterStringBeerData(map);
                        Repos.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                                String data = response.body();
                                Log.e("데이터 체크!!", response.body());
                                try {
                                    importFromJson(data);
                                    List<GsBeers> beers = new Gson().fromJson(data, new TypeToken<List<GsBeers>>() {
                                    }.getType());
                                    beersItem.clear();
                                    beersItem = beers;
                                    productRvAdapter.notifyDataSetChanged();
                                    progress.setVisibility(View.GONE);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                            }
                        });
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    private void dateDialog(final String filter) {
        this.filter = true;
        final DatePicker datePicker = new DatePicker(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("날짜 선택");
        builder.setView(datePicker);
        builder.setPositiveButton("선택",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Constants.URL.RetrofitService service = BEER_API_URL.getRetroService();
                        Map<String, String> map = new HashMap<>();
                        map.put(filter, datePicker.getMonth() + "-" + datePicker.getYear());
                        Call<String> Repos = service.filterStringBeerData(map);
                        Repos.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                                String data = response.body();
                                Log.e("데이터 체크!!", response.body());
                                try {
                                    importFromJson(data);
                                    List<GsBeers> beers = new Gson().fromJson(data, new TypeToken<List<GsBeers>>() {
                                    }.getType());
                                    beersItem.clear();
                                    beersItem = beers;
                                    productRvAdapter.notifyDataSetChanged();
                                    progress.setVisibility(View.GONE);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                            }
                        });
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    public interface Listener {
        void showProduct(int id);
    }

    public void onLoadMore() {
        progress.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                loadBeer();
            }
        }, 2000);
    }

    class ProductRvAdapter extends RecyclerView.Adapter<ProductRvAdapter.productViewHolde> {
        private LinearLayoutManager mLinearLayoutManager;
        private boolean isMoreLoading = false;

        void setLinearLayoutManager(LinearLayoutManager linearLayoutManager) {
            this.mLinearLayoutManager = linearLayoutManager;
        }

        void setRecyclerView(RecyclerView mView) {
            mView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    int visibleItemCount = recyclerView.getChildCount();
                    int totalItemCount = mLinearLayoutManager.getItemCount();
                    int firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
                    int lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
                    Log.d("total", totalItemCount + "");
                    Log.d("visible", visibleItemCount + "");

                    Log.d("first", firstVisibleItem + "");
                    Log.d("last", lastVisibleItem + "");

                    if (!filter && !isMoreLoading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + 1)) {
                        onLoadMore();
                        isMoreLoading = true;
                    }
                }
            });
        }


        @NonNull
        @Override
        public productViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // 리사이클러뷰에서 사용할 아이템의 레이아웃을 불러옵니다.
            final String nameAb = "AB";
            final String imageKeg = "keg.png";
            int resId = R.layout.item_product_list;
            if (beersItem.get(viewType).getName().contains(nameAb)) {
                resId = R.layout.item_product_list2;
            } else if (beersItem.get(viewType).getImageUrl().contains(imageKeg)) {
                resId = R.layout.item_product_list3;
            }
            View view = LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
            productViewHolde viewHolder = new BeerViewHolder(view);
            if (beersItem.get(viewType).getName().contains(nameAb)) {
                viewHolder = new BeerViewHolder(view);
            } else if (beersItem.get(viewType).getImageUrl().contains(imageKeg)) {
                viewHolder = new BeerViewHolder(view);
            }
            return viewHolder;
        }

        @SuppressLint("SetJavaScriptEnabled")
        @Override
        public void onBindViewHolder(@NonNull productViewHolde holder, int position) {
            holder.bind(beersItem.get(position));
        }

        @Override
        public int getItemCount() {
            return beersItem.size();
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        private void setResIv(String url, ImageView iv) {
            Glide.with(getActivity())
                    .load(url)
                    .into(iv);
        }

        void setMoreLoading() {
            isMoreLoading = false;
        }


        abstract class productViewHolde extends RecyclerView.ViewHolder {
            productViewHolde(View view) {
                super(view);
            }

            abstract void bind(GsBeers item);
        }

        class BeerViewHolder extends productViewHolde {
            @BindView(R.id.image)
            ImageView image;
            @BindView(R.id.title)
            TextView title;
            @BindView(R.id.content)
            TextView content;
            @BindView(R.id.etc)
            TextView etc;

            @OnClick(R.id.list_item)
            void onClick() {
                listener.showProduct(beersItem.get(getAdapterPosition()).getId());
            }

            BeerViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            @Override
            void bind(GsBeers beerData) {
                title.setText(getActivity().getString(R.string.beer_name, beerData.getName()));
                content.setText(getActivity().getString(R.string.beer_tag, beerData.getTagline()));
                etc.setText(getActivity().getString(R.string.first_brewed, beerData.getFirstBrewed()));
                setResIv(beerData.getImageUrl(), image);
            }
        }

        class abBeerViewHolder extends productViewHolde {
            @BindView(R.id.image)
            ImageView image;
            @BindView(R.id.title)
            TextView title;
            @BindView(R.id.content)
            TextView content;
            @BindView(R.id.etc)
            TextView etc;

            @OnClick(R.id.list_item)
            void onClick() {
                listener.showProduct(beersItem.get(getAdapterPosition()).getId());
            }

            abBeerViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            @Override
            void bind(GsBeers beerData) {
                title.setText(getActivity().getString(R.string.beer_name, beerData.getName()));
                content.setText(getActivity().getString(R.string.beer_tag, beerData.getTagline()));
                etc.setText(getActivity().getString(R.string.first_brewed, beerData.getFirstBrewed()));
                setResIv(beerData.getImageUrl(), image);
            }
        }

        class kegBeerViewHolder extends productViewHolde {
            @BindView(R.id.image)
            ImageView image;
            @BindView(R.id.title)
            TextView title;
            @BindView(R.id.content)
            TextView content;
            @BindView(R.id.etc)
            TextView etc;

            @OnClick(R.id.list_item)
            void onClick() {
                listener.showProduct(beersItem.get(getAdapterPosition()).getId());
            }

            kegBeerViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            @Override
            void bind(GsBeers beerData) {
                title.setText(getActivity().getString(R.string.beer_name, beerData.getName()));
                content.setText(getActivity().getString(R.string.beer_tag, beerData.getTagline()));
                etc.setText(getActivity().getString(R.string.first_brewed, beerData.getFirstBrewed()));
                setResIv(beerData.getImageUrl(), image);
            }
        }

    }
}
