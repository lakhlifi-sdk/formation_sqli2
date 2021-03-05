import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationkt.R
import com.example.myapplicationkt.ui.UserInfo
import com.example.myapplicationkt.models.User
import com.squareup.picasso.Picasso

class UserAdapter( val context: Context) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    lateinit private var user: List<User>

    //get view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val userView = inflater.inflate(R.layout.item_user, parent, false)
        // Return a new holder instance
        return ViewHolder(userView)
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {

        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val user_name = itemView.findViewById<TextView>(R.id.user_name)
        val user_email = itemView.findViewById<TextView>(R.id.user_email)
        val user_image=itemView.findViewById<ImageView>(R.id.user_image)

    }


    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: UserAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val user: User = user.get(position)
        // Set item views based on your views and data model
        val textViewName = viewHolder.user_name
        val textViewEmail=viewHolder.user_email
        val image_user=viewHolder.user_image

        textViewName.setText(user.name)
        textViewEmail.setText(user.email)

        Picasso.get().load("https://picsum.photos/seed/picsum/200/300").into(viewHolder.user_image);

        viewHolder.itemView.setOnClickListener {
            val i = Intent(context, UserInfo::class.java)
            i.putExtra("code", user.code)
            context.startActivity(i)
        }
    }

    fun setAndRefresh(users: MutableList<User>) {
        this.user = users
        notifyDataSetChanged()
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return user.size
    }

}