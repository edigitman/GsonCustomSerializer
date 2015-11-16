/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.agitman.customserializer.entity;

import com.google.gson.annotations.Expose;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gitmaal
 */
public class B extends AbstractSerializer{

    @Expose
    private String propString;
    @Expose
    private C propC;
    @Expose
    private Map<String, C> map = new HashMap<>();

    private Map<D, C> objMap = new HashMap<>();

    public String getPropString() {
        return propString;
    }

    public void setPropString(String propString) {
        this.propString = propString;
    }

    public C getPropC() {
        return propC;
    }

    public void setPropC(C propC) {
        this.propC = propC;
    }

    public Map<String, C> getMap() {
        return map;
    }

    public void setMap(Map<String, C> map) {
        this.map = map;
    }

    public Map<D, C> getObjMap() {
        return objMap;
    }

    public void setObjMap(Map<D, C> objMap) {
        this.objMap = objMap;
    }
}
