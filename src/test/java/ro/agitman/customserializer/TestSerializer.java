/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.agitman.customserializer;

import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import ro.agitman.customserializer.entity.*;
import ro.agitman.customserializer.utils.MyGson;

/**
 *
 * @author gitmaal
 */
public class TestSerializer {

    @Test
    @Ignore
    public void testSerialize(){
        List<C> cList = new ArrayList<C>();
        cList.add(new C(new BigDecimal("12.3")));
        cList.add(new C(new BigDecimal("34.5")));
        cList.add(new C(new BigDecimal("56.7")));
        cList.add(new C(new BigDecimal("78.9")));

        C c = new C();
        c.setPropBigDecimal(new BigDecimal("123.456"));

        B b = new B();
        b.setPropString("bCcontent");
        b.setPropC(c);

        A a = new A();
        a.setPropLong(10L);
        a.setPropStr("name");
        a.setPropB(b);
        a.setListC(cList);

        Gson g = MyGson.getInstance().getGson();
        String json = g.toJson(a);
        System.out.println("Serialized version");
        System.out.println(json);

        System.out.println("Deserialize");
        AbstractSerializer as = g.fromJson(json, AbstractSerializer.class);
    }

    @Test
    @Ignore
    public void testMap(){
        Map<String, C> map = new HashMap<>();
        map.put("unu", new C(new BigDecimal("23.4")));
        map.put("doi", new C(new BigDecimal("34.5")));
        map.put("trei", new C(new BigDecimal("45.6")));

        B b = new B();
        b.setPropString("B name");
        b.setPropC(new C(new BigDecimal("12.3")));
        b.setMap(map);

        Gson g = MyGson.getInstance().getGson();
        String json = g.toJson(b);
        System.out.println("Serialized version");
        System.out.println(json);
    }

    @Test
    public void testObjMap(){
        Map<D, C> map = new HashMap<>();
        map.put(new D(1, "unu"), new C(new BigDecimal("23.4")));
        map.put(new D(2, "doi"), new C(new BigDecimal("34.5")));
        map.put(new D(3, "trei"), new C(new BigDecimal("45.6")));

        B b = new B();
        b.setPropString("B name");
        b.setPropC(new C(new BigDecimal("12.3")));
        b.setObjMap(map);

        Gson g = MyGson.getInstance().getGson();
        String json = g.toJson(b);
        System.out.println("Serialized version");
        System.out.println(json);
    }


}
