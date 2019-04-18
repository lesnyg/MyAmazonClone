package com.lesnyg.myamazonclone.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.lesnyg.myamazonclone.models.Product;

import java.util.List;

public class MainViewModel extends ViewModel {
    public MutableLiveData<List<Product>> products = new MutableLiveData<>();
    private static final String TAG = MainViewModel.class.getSimpleName();

    public  Product selectedProduct;

    public void fetch() {
        FirebaseFirestore.getInstance().collection("item")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            List<Product> productList = task.getResult().toObjects(Product.class);

                            products.setValue(productList);

                            Log.d(TAG,"onComplete(): "+productList);

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
