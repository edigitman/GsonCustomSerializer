/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.agitman.customserializer.utils;

import com.google.gson.*;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import ro.agitman.customserializer.entity.AbstractSerializer;

/**
 * @author gitmaal
 */
public class CustomDeserializer implements JsonDeserializer<AbstractSerializer> {

    @Override
    public AbstractSerializer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        String clazzName = jsonObject.get("ClazzName").getAsString();
        AbstractSerializer abstractSerializer = null;
        Class c = null;
        try {
            c = Class.forName(clazzName);
            abstractSerializer = (AbstractSerializer) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (abstractSerializer != null) {
            JsonObject jObject = jsonObject.get("Properties").getAsJsonObject();

            Map<String, Object> map = new HashMap<>();
            for (Map.Entry<String, JsonElement> entry : jObject.entrySet()) {

                if (entry.getValue().isJsonObject()) {
                    JsonElement clazzObj = entry.getValue().getAsJsonObject().get("ClazzName");
                    if (clazzObj != null) {
                        String clazz = clazzObj.getAsString();
                        try {
                            map.put(entry.getKey(), context.deserialize(entry.getValue(), Class.forName(clazz)));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    if (entry.getValue().isJsonArray()) {
                        List<AbstractSerializer> videos = context.deserialize(entry.getValue(), new TypeToken<List<AbstractSerializer>>() {
                        }.getType());
                        map.put(entry.getKey(), videos);
                    } else {
                        map.put(entry.getKey(), context.deserialize(entry.getValue(), Object.class));
                    }
                }
            }

            Field[] fields = c.getDeclaredFields();
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object obj = map.get(field.getName());

                   //todo try to convert type found to type requested
                    if (field.getType().equals(obj.getClass())) {
                        field.set(abstractSerializer, obj);
                    } else {
                        if (field.getType().equals(obj.getClass().getInterfaces()[0])) {
                            field.set(abstractSerializer, obj);
                        } else {
                            field.set(abstractSerializer, context.deserialize(jObject.get(field.getName()), field.getType()));
                        }
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException iae) {
                iae.printStackTrace();
            }
        }
        System.out.println(jsonObject);

        return abstractSerializer;
    }

}
