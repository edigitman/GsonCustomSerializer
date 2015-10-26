/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.agitman.customserializer.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import ro.agitman.customserializer.entity.AbstractSerializer;
import ro.agitman.customserializer.entity.C;

/**
 *
 * @author gitmaal
 */
public class CustomSerializer implements JsonSerializer<AbstractSerializer> {

    @Override
    public JsonElement serialize(AbstractSerializer t, Type type, JsonSerializationContext jsc) {

        JsonObject object = new JsonObject();
        String clazz = t.getClass().getName();
        object.addProperty("ClazzName", clazz);

        Map<String, JsonElement> map = new HashMap<>();
        Class aClass = t.getClass();
        Field[] fields = aClass.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), jsc.serialize(field.get(t)));
            }
        }catch(IllegalArgumentException | IllegalAccessException iae){
          iae.printStackTrace();
        } 
        
        object.add("Properties", jsc.serialize(map));
        
        return object;
    }
    
}
