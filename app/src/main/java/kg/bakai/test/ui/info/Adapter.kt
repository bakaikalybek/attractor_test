package kg.bakai.test.ui.info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kg.bakai.test.R
import kg.bakai.test.domain.model.Company

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var list = mutableListOf<Company>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rv_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =list[position]
        holder.apply {
            companyName.text = item.name
            companyPosition.text = item.position
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitItems(items: List<Company>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val companyName: TextView = view.findViewById(R.id.tv_company_name)
        val companyPosition: TextView = view.findViewById(R.id.tv_position)
    }
}