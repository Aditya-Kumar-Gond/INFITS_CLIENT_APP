//package com.example.infits;
//
//import android.app.AlarmManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Handler;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link MealtrackerTodays_Breakfast#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class MealtrackerTodays_Breakfast extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public MealtrackerTodays_Breakfast() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment MealtrackerTodays_Breakfast.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static MealtrackerTodays_Breakfast newInstance(String param1, String param2) {
//        MealtrackerTodays_Breakfast fragment = new MealtrackerTodays_Breakfast();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_mealtracker_todays__breakfast, container, false);
//    }
//}

package com.example.infits;

        import static android.content.Context.MODE_PRIVATE;

        import android.app.AlarmManager;
        import android.app.PendingIntent;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;

        import androidx.activity.OnBackPressedCallback;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentTransaction;
        import androidx.navigation.NavController;
        import androidx.navigation.Navigation;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Handler;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.android.volley.AuthFailureError;
        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.HashMap;
        import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTodays_BreakFast#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MealtrackerTodays_Breakfast extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    ImageView calorieImgback;
    LinearLayout linear_layout1, linear_layout2,rcview;

    Todays_BreakFast_info todays_breakFast_info;

    MealtrackerFinalAdapter mealtrackerFinalAdapter;


    ArrayList<Todays_BreakFast_info> todays_breakFast_infos;
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView DoneButtonView,headerTitle,doneMeal;
    String url = String.format("%ssaveMeal_Meal_Tracker.php", DataFromDatabase.ipConfig);

    SharedPreferences sharedPreferences;
    RecyclerView recyclerView_Todays_breakfast;
    SimpleDateFormat todayDate;
    SimpleDateFormat todayTime;
    Date date;

    public void FragmentTodays_BreakFast() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTodays_BreakFast.
     */
    // TODO: Rename and change types and number of parameters
    public static MealtrackerTodays_Breakfast newInstance(String param1, String param2) {
        MealtrackerTodays_Breakfast fragment = new MealtrackerTodays_Breakfast();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        todays_breakFast_infos = new ArrayList<>();
        todays_breakFast_infos.clear();

//            SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE);
//            String json = preferences.getString("mealInfotransfer", null);
//            if (json != null) {
//                try {
//                    JSONArray jsonArray = new JSONArray(json);
////                    mealInfotransfer = new ArrayList<>();
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        todays_breakFast_infos.add(jsonArray.getString(i));
//                        Toast.makeText(this, jsonArray.getString(i), Toast.LENGTH_SHORT).show();
//                    }
//                    // do something with mealInfotransfer
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }

        View view = inflater.inflate(R.layout.fragment_mealtracker_todays__breakfast, container, false);
        todayDate = new SimpleDateFormat("d MMM yyyy");

        todayTime = new SimpleDateFormat("h.m.s a");

        date=new Date();

        //set correct header title
        headerTitle = view.findViewById(R.id.header_title);
//        doneMeal = view.findViewById(R.id.done_meal);
        headerTitle.setText(getMeal()); //open after connected
//        doneMeal.setText(getMeal());

        //recycleview
        rcview = view.findViewById(R.id.rcview);
        recyclerView_Todays_breakfast = view.findViewById(R.id.recyclerView_Todays_breakfast);
        recyclerView_Todays_breakfast.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        //Correcting the Sharedpref
//        correctPref();

        //displaying data
        DisplayDataInList();
//        todays_breakFast_infos.clear();

        mealtrackerFinalAdapter = new MealtrackerFinalAdapter(getContext(), todays_breakFast_infos);
        recyclerView_Todays_breakfast.setAdapter(mealtrackerFinalAdapter);

        //backbutton
        calorieImgback = view.findViewById(R.id.calorieImgback);
        calorieImgback.setOnClickListener(v -> requireActivity().onBackPressed());

        //DoneButtonView
        linear_layout1 = view.findViewById(R.id.linear_layout1);
        linear_layout2 = view.findViewById(R.id.linear_layout2);

        DoneButtonView = view.findViewById(R.id.DoneButtonView);
        DoneButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    linear_layout1.setVisibility(View.GONE);
                    linear_layout2.setVisibility(View.VISIBLE);
                    AddDatatoTable(view);
                    storeData();
                } catch (Exception e) {
                    Log.d("Exception123", e.toString());
                }
            }
        });

        //delete shared preference

//        DeleteSharedPreference();
        return view;
    }

//    private void correctPref() {
//        sharedPreferences = getActivity().getSharedPreferences("TodaysBreakFast", MODE_PRIVATE);
//        try{
//        JSONObject jsonObject = new JSONObject(sharedPreferences.getString("TodaysBreakFast", ""));
//        JSONArray jsonArray = jsonObject.getJSONArray("TodaysBreakFast");
//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//            String mealName = jsonObject1.getString("mealName");
//            boolean isDuplicate = false;
//            for (Todays_BreakFast_info info : todays_breakFast_infos) {
//                if (info.getMealName().equals(mealName)) {
//                    // Found a duplicate, increase quantity and remove duplicate object
//                    int quantity = Integer.parseInt(info.getQuantity()) + 1;
//                    info.setQuantity(String.valueOf(quantity));
//                    todays_breakFast_infos.remove(info);
//                    isDuplicate = true;
//                    break;
//                }
//            }
//            if (!isDuplicate) {
//                // Add new object to list if not a duplicate
//                todays_breakFast_infos.add(new Todays_BreakFast_info(getContext().getDrawable(R.drawable.pizza_img),
//                        mealName,
//                        jsonObject1.getString("calorieValue"),
//                        jsonObject1.getString("carbsValue"),
//                        jsonObject1.getString("fatValue"),
//                        jsonObject1.getString("proteinValue"),
//                        jsonObject1.getString("Quantity"),
//                        jsonObject1.getString("Size")));
//            }
//        }}catch (Exception e){
//
//        }
//
//    }

    public void AddDatatoTable(View view) {
        try {
            sharedPreferences = getActivity().getSharedPreferences("TodaysBreakFast", MODE_PRIVATE);
            JSONObject jsonObject = new JSONObject(sharedPreferences.getString("TodaysBreakFast", ""));
            JSONArray jsonArray = jsonObject.getJSONArray("TodaysBreakFast");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                // Get the SharedPreferences object
                String prefName = obj.getString("image");
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("BitMapInfo", Context.MODE_PRIVATE);

// Retrieve the value with the specified key, or return a default value if the key doesn't exist
                String myValue = sharedPreferences.getString(prefName, "image");
                obj.remove("image");
                obj.put("image",myValue);
                Log.d("TAG", "AddDatatoTable: got "+obj.getString("image"));
            }
            JSONObject jsonObject1 = jsonArray.getJSONObject(0);
            String mealName=jsonObject1.getString("mealName");
            String Meal_Type=jsonObject1.getString("Meal_Type");

            SharedPreferences sharedPreferences1=getActivity().getSharedPreferences("BitMapInfo", MODE_PRIVATE);
            Log.d("lastBreakFast", sharedPreferences1.getString("ClickedPhoto","").toString());
            String base64String=sharedPreferences1.getString("ClickedPhoto","").toString();


            RequestQueue queue= Volley.newRequestQueue(requireContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {
                Log.d("responseCalorie", response);

                if (response.contains("true")) {
                    try {
                        storeData();
                    } catch (Exception e) {
                        Toast.makeText(requireContext(), "Error storing data", Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "AddDatatoTable: "+e.toString());
                    }
                    DeleteImages();
                    linear_layout2.setVisibility(View.GONE);
                }
                else{
                    Toast.makeText(getContext(), "Error with database", Toast.LENGTH_SHORT).show();
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        FragmentManager fragmentManager = getParentFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        MealTrackerFragment mealTrackerFragment = new MealTrackerFragment();
                        fragmentTransaction.add(R.id.frameLayout, mealTrackerFragment).commit();
                    }
                }, 200);
            },

                    error -> {
                        Log.d("AddDatatoTable", "AddDatatoTable: "+error.toString());
                        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    String timeString = todayTime.format(date);
                    String dateString = todayDate.format(date);
                    data.put("name", mealName.toString());
//                    data.put("image", base64String);
                    data.put("date", dateString);
                    data.put("time", timeString);
                    //timeMeal is a Meal_Type
                    data.put("timeMeal", Meal_Type);
                    data.put("description","");
//                    data.put("clientID", DataFromDatabase.clientuserID.toString());
                    data.put("clientID", "test");
                    data.put("position",String.valueOf(jsonArray.length()-1));
                    data.put("jsonArray", jsonArray.toString());
                    return data;
                }



            };

            queue.add(stringRequest);


        } catch (Exception e) {
            Log.d("Exception", e.toString());
        }
    }
    private void storeData() throws Exception{
        sharedPreferences = getActivity().getSharedPreferences("TodaysBreakFast", MODE_PRIVATE);
                JSONArray Breakfast = new JSONArray();
                JSONArray Lunch = new JSONArray();
                JSONArray Dinner = new JSONArray();
                JSONArray Snacks = new JSONArray();
                JSONObject jsonObject = new JSONObject(sharedPreferences.getString("TodaysBreakFast", ""));
                JSONArray jsonArray = jsonObject.getJSONArray("TodaysBreakFast");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    jsonObject1.remove("image");
                    switch (jsonObject1.getString("Meal_Type")){
                        case "Breakfast":
//                            Log.d("TAG", "Breakfast: "+jsonArray.getString(i));
                            Breakfast.put(jsonObject1);
                            break;
                        case "Lunch":
                            Lunch.put(jsonObject1);
                            break;
                        case "Dinner":
                            Dinner.put(jsonObject1);
                            break;
                        case "Snack":
                            Snacks.put(jsonObject1);
                            break;
                }
            }
        Log.d("TAG", "storeData: no err");
        JSONObject meals = new JSONObject();
        if (Breakfast.length() != 0) meals.put("Breakfast", Breakfast);
        if (Lunch.length() != 0) meals.put("Lunch", Lunch);
        if (Dinner.length() != 0) meals.put("Dinner", Dinner);
        if (Snacks.length() != 0) meals.put("Snacks", Snacks);


        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
        String formattedDate = formatter.format(today);
        sharedPreferences = getActivity().getSharedPreferences("TodaysMeal"+formattedDate, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("meals",meals.toString());
        editor.apply();

        Log.d("TAG", "storeData: Finished" + meals.toString());

    }


    private String getMeal() {
        try {
            sharedPreferences = getActivity().getSharedPreferences("TodaysBreakFast", MODE_PRIVATE);
            JSONObject jsonObject = new JSONObject(sharedPreferences.getString("TodaysBreakFast", ""));
            JSONArray jsonArray = jsonObject.getJSONArray("TodaysBreakFast");
            JSONObject jsonObject1 = jsonArray.getJSONObject(jsonArray.length() - 1);
            return jsonObject1.getString("Meal_Type");
        }
        catch (Exception e){
            Log.d("getMeal: ",e.toString());
        }
        return null;
    }

    public void DisplayDataInList() {
        try {


//            //        holder.addmealIcon.
//            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("BitMapInfo", Context.MODE_PRIVATE);
//            String base64String = sharedPreferences.getString("ClickedPhoto", null);
//
//            // Decode the base64 string to a Bitmap object
//            byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
//            Bitmap decodedBitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            // Set the Bitmap as the Drawable of the ImageView

//        holder.addmealIcon.setImageDrawable(new BitmapDrawable(context.getResources(), decodedBitmap));
            sharedPreferences = getActivity().getSharedPreferences("TodaysBreakFast", MODE_PRIVATE);
            JSONObject jsonObject = new JSONObject(sharedPreferences.getString("TodaysBreakFast", ""));
            JSONArray jsonArray = jsonObject.getJSONArray("TodaysBreakFast");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                todays_breakFast_infos.add(new Todays_BreakFast_info(getContext().getDrawable(R.drawable.pizza_img),
//                        todays_breakFast_infos.add(new Todays_BreakFast_info(decodedBitmap,
                        jsonObject1.getString("mealName"),
                        jsonObject1.getString("calorieValue"),
                        jsonObject1.getString("carbsValue"),
                        jsonObject1.getString("fatValue"),
                        jsonObject1.getString("proteinValue"),
                        jsonObject1.getString("Quantity"),
                        jsonObject1.getString("Size")));
            }

        } catch (Exception e) {
            Log.d("Displaydatainlist", e.toString());
        }
    }

    private void DeleteImages() {
//        Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();
//        AlarmManager alarmManager = (AlarmManager) requireActivity().getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(getContext(), NotificationReceiver.class);
//        intent.putExtra("tracker", "TodaysBreakFast");
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 1, intent, PendingIntent.FLAG_IMMUTABLE);
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, 0L, 59 * 1000, pendingIntent);
        Log.d("TAG", "DeleteSharedPreference: " + "Deleted");
        sharedPreferences = getActivity().getSharedPreferences("TodaysBreakFast", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        sharedPreferences = getActivity().getSharedPreferences("BitMapInfo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}