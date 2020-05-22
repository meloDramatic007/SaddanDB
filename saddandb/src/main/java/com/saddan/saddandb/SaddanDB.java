package com.saddan.saddandb;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaddanDB
{
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SaddanDB(Context appContext)
    {
        //this.preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
         preferences=appContext.getSharedPreferences("access_token",Context.MODE_PRIVATE);
        // editor = preferences.edit();
    }

    private void putListObject(String key, ArrayList<Object> objArray)
    {
        checkForNullKey(key);
        Gson gson = new Gson();

        ArrayList<String> objStrings = new ArrayList<String>();
        for(Object obj : objArray){
            objStrings.add(gson.toJson(obj));
        }
        putListString(key, objStrings);
    }

    private ArrayList<Object> getListObject(String key, Class<?> mClass){
        Gson gson = new Gson();

        ArrayList<String> objStrings = getListString(key);
        ArrayList<Object> objects =  new ArrayList<Object>();

        for(String jObjString : objStrings){
            Object value  = gson.fromJson(jObjString,  mClass);
            objects.add(value);
        }
        return objects;
    }

    private void checkForNullKey(String key)
    {
        if (key == null){
            throw new NullPointerException();
        }
    }


    private void putListString(String key, ArrayList<String> stringList)
    {
        checkForNullKey(key);
        String[] myStringList = stringList.toArray(new String[stringList.size()]);
        preferences.edit().putString(key, TextUtils.join("‚‗‚", myStringList)).apply();
    }

    private ArrayList<String> getListString(String key)
    {
        return new ArrayList<String>(Arrays.asList(TextUtils.split(preferences.getString(key, ""), "‚‗‚")));
    }

 public void setList(String key, List<? extends Object> list)
    {
        ArrayList<Object> trendingObject = new ArrayList<Object>();
        for(Object a : list){
            trendingObject.add((Object) a);
        }


        putListObject(key, trendingObject);
    }

    //@SuppressWarnings("unchecked")
    public <T> List<? extends Object> getList(String key,Class<T> Typex)
    {
        ArrayList<Object> trendingObject =getListObject(key, Typex);
        ArrayList<T> list = new ArrayList<>();

        for(Object objs : trendingObject)
        {
            list.add((T) objs);
        }



        return list;
    }

    public void ClearData(){

        preferences.edit().clear();
        preferences.edit().apply();
    }

}
