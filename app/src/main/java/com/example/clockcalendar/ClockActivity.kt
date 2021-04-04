package com.example.clockcalendar

//import android.R
import android.R.drawable
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import java.lang.reflect.Field
import java.util.*


class ClockActivity : AppWidgetProvider() {

    fun getDrawableName(ctx: Context, str: String?): Int {
        return ctx.resources.getIdentifier(str, "drawable", ctx.packageName)
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        Log.v("hi", "updating");
        // Perform this loop procedure for each App Widget that belongs to this provider
        appWidgetIds.forEach { appWidgetId ->
            RemoteViews(context.packageName, R.layout.clock_layout).also { views->
                val time: Date = Calendar.getInstance().time
                val month = time.month
                val day = time.date
                val id_string = "ic_clock_hand_" + month + "_" + day
                Log.v("id", id_string)
                val myhand = getDrawableName(context, id_string)
                //val myhand = getResId(id_string, drawable::class.java)
                views.setImageViewResource(R.id.clock_hand, myhand)
                appWidgetManager.updateAppWidget(appWidgetId, views)
            }
        }
    }

    override fun onAppWidgetOptionsChanged(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId : Int,
        newOptions: Bundle
    ){
        Log.d("hello", "updating clock hand in resize for no reason")
        RemoteViews(context.packageName, R.layout.clock_layout).also { views->
            val time: Date = Calendar.getInstance().time
            val month = time.month
            val day = time.date
            val id_string = "ic_clock_hand_" + month + "_" + day
            Log.v("id", id_string)
            val myhand = getDrawableName(context, id_string)
            //val myhand = getResId(id_string, drawable::class.java)
            views.setImageViewResource(R.id.clock_hand, myhand)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clock_layout)
        Log.d("hello", "this should not be called")
    }
}

