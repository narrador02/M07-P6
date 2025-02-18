package com.example.m07_p5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ConsumptionAdapter(
    private val consumptionList: List<ConsumptionItem>,
    private val onItemClick: (ConsumptionItem, Int) -> Unit
) : RecyclerView.Adapter<ConsumptionAdapter.ConsumptionViewHolder>() {

    class ConsumptionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodName: TextView = view.findViewById(R.id.food_name)
        val foodCalories: TextView = view.findViewById(R.id.food_calories)
        val foodDate: TextView = view.findViewById(R.id.food_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsumptionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_consumption, parent, false)
        return ConsumptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConsumptionViewHolder, position: Int) {
        val food = consumptionList[position]
        holder.foodName.text = food.name

        val cleanCalories = food.calories.replace(" kcal kcal", " kcal")
        holder.foodCalories.text = cleanCalories
        holder.foodDate.text = food.date

        holder.itemView.setOnClickListener {
            onItemClick(food, position)
        }
    }

    override fun getItemCount() = consumptionList.size
}