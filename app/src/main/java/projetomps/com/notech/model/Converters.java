package projetomps.com.notech.model;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Converters {

    private static Gson gson = new Gson();

    @TypeConverter
    public static ArrayList<Integer> jsonToArrayList(String json) {
        if(json == null)
            return new ArrayList<Integer>();

        Type listType = new TypeToken<List<Integer>>() {}.getType();

        return gson.fromJson(json, listType);
    }

    @TypeConverter
    public static String listToString(ArrayList<Integer> lista) {
        return gson.toJson(lista);
    }

    @TypeConverter
    public static Date fromTimestamp(Long valor) {
        return valor == null ? null : new Date(valor);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date data) {
        return data == null ? null : data.getTime();
    }
}
