package ro.agitman.customserializer.entity;

/**
 * Created by gitmaal on 27/10/2015.
 */
public class D extends AbstractSerializer {

    private Integer index;
    private String key;

    public D() {
    }

    public D(Integer index, String key) {
        this.index = index;
        this.key = key;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
