package beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mitsuyasu on 2015/07/27.
 */
public class TempSensorData implements Serializable {

    private Float temp;
    private Date date;

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
