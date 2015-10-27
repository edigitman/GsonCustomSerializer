/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.agitman.customserializer.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;

import ro.agitman.customserializer.entity.*;

/**
 *
 * @author gitmaal
 */
public class MyGson {

    private static final MyGson INSTANCE = new MyGson();
    private final GsonBuilder gsonBuilder;
		
    
    private MyGson() {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.enableComplexMapKeySerialization();

        gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer());

        gsonBuilder.registerTypeAdapter(A.class, new CustomSerializer());
        gsonBuilder.registerTypeAdapter(B.class, new CustomSerializer());
        gsonBuilder.registerTypeAdapter(C.class, new CustomSerializer());        
        gsonBuilder.registerTypeAdapter(D.class, new CustomSerializer());

        gsonBuilder.registerTypeAdapter(A.class, new CustomDeserializer());
        gsonBuilder.registerTypeAdapter(B.class, new CustomDeserializer());
        gsonBuilder.registerTypeAdapter(C.class, new CustomDeserializer());
        gsonBuilder.registerTypeAdapter(D.class, new CustomDeserializer());
        gsonBuilder.registerTypeAdapter(AbstractSerializer.class, new CustomDeserializer());
    }

    public static MyGson getInstance(){
        return INSTANCE;
    }
    
    public Gson getGson(){
        return gsonBuilder.create();
    }
    
}
