package com.v1.e_learningsmantigda.MateriPelajaran;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by Oclemy on 6/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * 1.SAVE DATA TO FIREBASE
 * 2. RETRIEVE
 * 3.RETURN AN ARRAYLIST
 */
public class matpel_firebasehelper {

    DatabaseReference db;
    Boolean saved=null;
    ArrayList<matpel_spacecraft> matpelspacecrafts =new ArrayList<>();

    public matpel_firebasehelper(DatabaseReference db) {
        this.db = db;
    }

    //WRITE IF NOT NULL
    public Boolean save(matpel_spacecraft matpelspacecraft)
    {
        if(matpelspacecraft ==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("Materi Pelajaran").push().setValue(matpelspacecraft);
                saved=true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }

        return saved;
    }
    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchData(DataSnapshot dataSnapshot)
    {
        matpelspacecrafts.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            matpel_spacecraft matpelspacecraft =ds.getValue(matpel_spacecraft.class);
            matpelspacecrafts.add(matpelspacecraft);
        }
    }
    //READ BY HOOKING ONTO DATABASE OPERATION CALLBACKS
    public ArrayList<matpel_spacecraft> retrieve() {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return matpelspacecrafts;
    }
}



















