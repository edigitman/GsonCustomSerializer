/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.agitman.customserializer.entity;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 *
 * @author gitmaal
 */
public class A extends AbstractSerializer{

    private String propStr;
    private Long propLong;
    private B propB;
    private List<C> listC;

    public String getPropStr() {
        return propStr;
    }

    public void setPropStr(String propStr) {
        this.propStr = propStr;
    }

    public Long getPropLong() {
        return propLong;
    }

    public void setPropLong(Long propLong) {
        this.propLong = propLong;
    }

    public B getPropB() {
        return propB;
    }

    public void setPropB(B propB) {
        this.propB = propB;
    }

    public List<C> getListC() {
        return listC;
    }

    public void setListC(List<C> listC) {
        this.listC = listC;
    }
    
    
}
