/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.agitman.customserializer.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gitmaal
 */
public class DateDeserializer implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        SimpleDateFormat sdf = new SimpleDateFormat(JsonName.DATE_FORMAT);
        Date date = null;
        try {
            date = sdf.parse(json.getAsJsonPrimitive().getAsString());
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
