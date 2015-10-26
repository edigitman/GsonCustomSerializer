/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.agitman.customserializer;

import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import ro.agitman.customserializer.entity.A;
import ro.agitman.customserializer.entity.AbstractSerializer;
import ro.agitman.customserializer.entity.B;
import ro.agitman.customserializer.entity.C;
import ro.agitman.customserializer.utils.MyGson;

/**
 *
 * @author gitmaal
 */
public class TestSerializer {

    @Test
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
}
