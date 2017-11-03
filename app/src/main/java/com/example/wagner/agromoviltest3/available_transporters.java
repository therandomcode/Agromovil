package com.example.wagner.agromoviltest3;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ListView;

        import java.util.Hashtable;
        import java.util.List;
        import java.util.ArrayList;


public class available_transporters extends AppCompatActivity {

    ListView lst;
    DBHandler db = new DBHandler(this);
    String[] transportername = {"a", "b", "c"};
    String[] make_car={"1996 Toyota Tacoma","2002 Nissan Navara","2000 Agrale Marrua"};
    Integer[] imgid={R.drawable.image1,R.drawable.image2,R.drawable.image3};
    String[] addresses={"Cra. 88c #42 Sur-98 a 42 Sur-2, Bogotá, Colombia",
            "Cl. 134 #104-79 a 104-1, Bogotá, Colombia", "Cl. 163 #1a Este-68 a 1a Este-2, Bogotá, Colombia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_transporters);

        // Creating dummy data
        Hashtable<Integer, String> hash1 = new Hashtable<>();
        for (int i = 10; i < 13; i++) hash1.put(i, "AM");
        Hashtable<Integer, String> hash2 = new Hashtable<>();
        for (int i = 1; i < 15; i++) hash2.put(i, "ALL DAY");
        Hashtable<Integer, String> hash3 = new Hashtable<>();
        for (int i = 1; i < 3; i++) hash3.put(i, "AM");
        for (int i = 3; i < 6; i++) hash3.put(i, "PM");
        for (int i = 6; i < 11; i++) hash3.put(i, "ALL DAY");

        // Delete all rows
        List<Transporter> Transporters = db.getAllTransporters();
        for (Transporter transporter : Transporters) {
            db.deleteTransporter(transporter);
        }

        // Inserting Transporters/Rows
        db.addTransporter(new Transporter("Miguel", "Sanchez1",
                "Cra. 88c #42 Sur-98 a 42 Sur-2, Bogotá, Colombia", make_car[0], imgid[0], hash1));
        db.addTransporter(new Transporter("Carlos", "Gonzales2",
                "Cl. 134 #104-79 a 104-1, Bogotá, Colombia", make_car[1], imgid[1], hash2));
        db.addTransporter(new Transporter("Roberto", "Santos3",
                "Cl. 163 #1a Este-68 a 1a Este-2, Bogotá, Colombia", make_car[2], imgid[2], hash3));

//        int date = getCurrentDate();
//        String time = getCurrentTime();

        int date = 10;
        String time = "AM";
        int counter = 0;
        int backcounter = 0;
        String[] names = new String[3];
        String[] addresses2 = new String[3];
        String[] car_make = new String[3];
        Integer[] imgid_alist = new Integer[3];


        Transporters = db.getAllTransporters();
        for (Transporter transporter : Transporters) {
            if (transporter.isAvailable(date, time)) {
                names[counter] = transporter.getFirstName() + " " + transporter.getLastName();
                addresses2[counter] = transporter.getAddress();
                car_make[counter] = transporter.getCarMake();
                imgid_alist[counter] = Integer.valueOf(transporter.getImgid());
                counter++;
            }
            else {
                names[2 - backcounter] = " ";
                addresses2[2 - backcounter] = " ";
                car_make[2 - backcounter] = " ";
                imgid_alist[2 - backcounter] = Integer.valueOf(transporter.getImgid());;
                backcounter++;
            }
        }

        lst= findViewById(R.id.listview);
        CustomListview customListview = new CustomListview(this,names,addresses2,car_make,imgid_alist);
        lst.setAdapter(customListview);
    }
}