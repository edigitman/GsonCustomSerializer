/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.agitman.customserializer.entity;

/**
 *
 * @author gitmaal
 */
public class B extends AbstractSerializer{
    
    private String propString;
    private C propC;

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
    
    
}
