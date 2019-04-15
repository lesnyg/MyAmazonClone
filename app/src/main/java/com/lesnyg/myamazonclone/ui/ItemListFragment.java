package com.lesnyg.myamazonclone.ui;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lesnyg.myamazonclone.R;
import com.lesnyg.myamazonclone.databinding.ItemProductBinding;
import com.lesnyg.myamazonclone.models.Product;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemListFragment extends Fragment {

    public ItemListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        ProductAdapter adapter = new ProductAdapter();
        recyclerView.setAdapter(adapter);

        //가짜데이터
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        List<String> phototUrls = new ArrayList<>();
        phototUrls.add("https://images-na.ssl-images-amazon.com/images/I/41l7MzrUaNL.jpg");
        phototUrls.add("https://images-na.ssl-images-amazon.com/images/I/41d7bXX4XZL.jpg");
        product1.setPhotoUrls(phototUrls);
        product1.setTitle("TRITTON Halo Professional Condenser Microphone, Game Live Professional Recording Microphone, with Desktop Stand for Gaming,YouTube Video, Recording Podcast,Studio,for PC,Laptop,Tablet");
        product1.setPrice(160000);
        productList.add(product1);
        Product product2 = new Product();
        List<String> phototUrls2 = new ArrayList<>();
        phototUrls2.add("https://images-na.ssl-images-amazon.com/images/I/41d7bXX4XZL.jpg");
        phototUrls2.add("https://images-na.ssl-images-amazon.com/images/I/41l7MzrUaNL.jpg");
        product2.setPhotoUrls(phototUrls2);
        product2.setTitle("sfgsfhshsdfgdfgsdgfsdfgsdfgdfgsdfg");
        product2.setPrice(230000);
        productList.add(product2);

        //데이터를 어댑터에 set 시킨다.
        adapter.setmItems(productList);
    }

    private static class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
        private List<Product> mItems = new ArrayList<>();

        public void setmItems(List<Product> items){
            mItems = items;
            notifyDataSetChanged();
        }
        @NonNull
        @Override
        public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_product, viewGroup, false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder productViewHolder, int i) {
            productViewHolder.binding.setProduct(mItems.get(i));
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public static class ProductViewHolder extends RecyclerView.ViewHolder {
            private ItemProductBinding binding;

            public ProductViewHolder(@NonNull View itemView) {
                super(itemView);
                binding = DataBindingUtil.bind(itemView);
            }
        }
    }
}
