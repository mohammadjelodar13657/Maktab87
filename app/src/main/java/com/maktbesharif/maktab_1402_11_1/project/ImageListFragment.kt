package com.maktbesharif.maktab_1402_11_1.project

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.maktbesharif.maktab_1402_11_1.R
import com.maktbesharif.maktab_1402_11_1.databinding.FragmentImageListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImageListFragment : Fragment(R.layout.fragment_image_list) {

    private lateinit var binding: FragmentImageListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        val retrofit = Retrofit.Builder()
            .baseUrl("https://picsum.photos/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val imageReceiverApi = retrofit.create(ImageReceiverApi::class.java)

        val call = imageReceiverApi.getImages()

        call.enqueue(object : Callback<List<GetImageList>>{
            override fun onResponse(
                call: Call<List<GetImageList>>,
                response: Response<List<GetImageList>>
            ) {
                val image = response.body()

                if(image != null) {

                }
            }

            override fun onFailure(call: Call<List<GetImageList>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}