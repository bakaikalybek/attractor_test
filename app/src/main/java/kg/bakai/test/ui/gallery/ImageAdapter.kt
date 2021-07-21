package kg.bakai.test.ui.gallery

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.bakai.test.R

class ImageAdapter: RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    private var list = mutableListOf<Uri>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rv_image, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =list[position]
        holder.apply {
            Glide.with(image.context)
                .load(item)
                .into(image)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitItems(items: List<Uri>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
    }
}