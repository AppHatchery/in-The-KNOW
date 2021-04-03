package com.example.intheknow.ui.logger

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.intheknow.R
import com.example.intheknow.data.Converter
import com.example.intheknow.data.LogEntry
import java.util.*

import kotlinx.android.synthetic.main.logger_list_item2.view.*

class LogEntryAdapter(
    private val logList : List<LogEntry>,
    private val deleteListener : OnLogItemDeleteListener,
    private val editListener : OnLogItemEditListener
) : RecyclerView.Adapter<LogEntryAdapter.LogEntryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogEntryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.logger_list_item2,
            parent, false)
        return LogEntryViewHolder(itemView)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: LogEntryViewHolder, position: Int) {
        val currentItem = logList[position]
        val calendar : GregorianCalendar = currentItem.dateOfEntry
        holder.dateLogged.text = Converter.gregorianCalendarToPrettyStr(calendar)
        holder.sexCategoryText.text = currentItem.sexCategory

        /*
        var lightSalmon = Color.valueOf(1.0f, 0.625f, 0.4765625f)
        var deepBlue = Color.valueOf(0f, 0.7461f, 1.0f)
        var plum = Color.valueOf(0.86328f, 0.625f, 0.86328f)

        if (currentItem.sexCategory == LogEntry.ANAL) {
            holder.loggerLayout.setBackgroundColor(deepBlue.toArgb())
        } else if (currentItem.sexCategory == LogEntry.ORAL) {
            holder.loggerLayout.setBackgroundColor(plum.toArgb())
        } else if (currentItem.sexCategory == LogEntry.VAGINAL) {
            holder.loggerLayout.setBackgroundColor(lightSalmon.toArgb())
        } else {
            holder.loggerLayout.setBackgroundColor(Color.WHITE)
        }
         */

        if (currentItem.condom == LogEntry.CONDOM) {
            holder.protectionText.text = "with condom"
        } else {
            holder.protectionText.text = ""
        }
        holder.logText.text = currentItem.log
    }

    override fun getItemCount() = logList.size

    inner class LogEntryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val dateLogged : TextView = itemView.findViewById(R.id.date_logged)
        val sexCategoryText : TextView = itemView.findViewById(R.id.sex_category)
        val protectionText : TextView = itemView.findViewById(R.id.protection_text)
        val logText : TextView = itemView.findViewById(R.id.log_text)
        val loggerLayout : RelativeLayout = itemView.findViewById(R.id.logger2_card_holder)

        init {
            itemView.btnDelete.setOnClickListener(this)
            itemView.btnEdit.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position : Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if (v != null) {
                    if (v.id == R.id.btnDelete) {
                        deleteListener.onLogItemDelete(position)
                    }
                    else {
                        editListener.onLogItemEdit(position, itemView)
                    }
                }
            }
        }

    }

    interface OnLogItemDeleteListener {
        fun onLogItemDelete(position: Int)
    }
    interface OnLogItemEditListener {
        fun onLogItemEdit(position: Int, itemView : View)
    }
}