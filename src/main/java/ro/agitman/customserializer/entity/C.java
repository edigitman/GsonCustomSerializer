/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.agitman.customserializer.entity;

import java.math.BigDecimal;

/**
 *
 * @author gitmaal
 */
public class C extends AbstractSerializer {

    private BigDecimal propBigDecimal;

    public C() {
    }

    public C(BigDecimal propBigDecimal) {
        this.propBigDecimal = propBigDecimal;
    }

    public BigDecimal getPropBigDecimal() {
        return propBigDecimal;
    }

    public void setPropBigDecimal(BigDecimal propBigDecimal) {
        this.propBigDecimal = propBigDecimal;
    }

}
