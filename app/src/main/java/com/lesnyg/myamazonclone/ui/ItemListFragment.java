package com.lesnyg.myamazonclone.ui;


import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lesnyg.myamazonclone.R;
import com.lesnyg.myamazonclone.databinding.ItemProductBinding;
import com.lesnyg.myamazonclone.models.Product;
import com.lesnyg.myamazonclone.viewmodels.MainViewModel;

import java.util.ArrayList;
import java.util.List;


public class ItemListFragment extends Fragment {

    public ItemListFragment() {
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
        MainViewModel model = ViewModelProviders.of(requireActivity()).get(MainViewModel.class);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        ProductAdapter adapter = new ProductAdapter(product -> {
            //Detail 화면으로 전환
            model.selectedProduct = product;
            Navigation.findNavController(view).navigate(R.id.action_itemListFragment_to_itemDetailFragment);
        });
        recyclerView.setAdapter(adapter);


        model.products.observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                //데이터를 어댑터에 set 시킨다.
                adapter.setmItems(products);
            }
        });

        //DB에서 데이터 긁어오기
       model.fetch();
    }

    private static class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
        private List<Product> mItems = new ArrayList<>();

        interface OnProductItemClickListener {
            void onProductItemClick(Product item);
        }

        private OnProductItemClickListener mListener;


        public ProductAdapter(OnProductItemClickListener listener) {
            mListener = listener;
        }

        public void setmItems(List<Product> items) {
            mItems = items;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_product, viewGroup, false);
            ProductViewHolder viewHolder = new ProductViewHolder(view);
            view.setOnClickListener(v -> mListener.onProductItemClick(mItems.get(viewHolder.getAdapterPosition())));
            return viewHolder;
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
