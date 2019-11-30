package com.weightwatchers.ww_exercise_01.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.weightwatchers.ww_exercise_01.R
import com.weightwatchers.ww_exercise_01.databinding.ItemviewLayoutBinding
import com.weightwatchers.ww_exercise_01.model.FoodModel
import kotlinx.android.synthetic.main.itemview_layout.view.*

class FoodAdapter(val foodList: ArrayList<FoodModel>) : RecyclerView.Adapter<FoodAdapter.FoodHolder>()
        , FoodClickListener {

    fun updateFoodList(newFoodList: List<FoodModel>) {
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemviewLayoutBinding>(inflater, R.layout.itemview_layout, parent, false)
        return FoodHolder(view)

    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.view.food = foodList[position]

    }


    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onFoodClicker(view: View) {

        Snackbar.make(view, "Looks good?",
                Snackbar.LENGTH_LONG).show()
    }

    class FoodHolder(var view: ItemviewLayoutBinding) : RecyclerView.ViewHolder(view.root)
}